package rs.ac.bg.etf.pp1;

import java.io.Externalizable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.ac.bg.etf.pp1.ast.*;

public class SemanticAnalyzer extends VisitorAdaptor{
	
	Logger log = Logger.getLogger(getClass());
	
	private Struct currentType = null;
	private ArrayList<SyntaxNode> nodes = null;
	private Boolean hasDesignatorList = null;
	private Obj currentMethod = null;
	private int currentMethodParsCount = 0;
	private ArrayList<Struct> currentPars = null;
	private int forCount = 0;
	private boolean main;
	
	private boolean errorDetected;
	private int varCount;
	
	public boolean isErrorDetected() {
		return errorDetected;
	}
	
	public int getVarCount() {
		return varCount;
	}

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	
	// Global Consts
	
	public void visit(ConstType constType) {
		constType.struct = constType.getType().struct;
		currentType = constType.struct;
	}
	
	public void visit(ConstDeclaration_ constDecl) {
		currentType = null;
	}
	
	public void visit(ConstIdent_ constIdent) {
		report_info("Konstanta " + constIdent.getConstName(), constIdent);
		Obj constName = Tab.find(constIdent.getConstName());
		if(constName == Tab.noObj) {
			constIdent.obj = Tab.insert(Obj.Con, constIdent.getConstName(), currentType);
			if(constIdent.getConstValue() instanceof NumConst) {
				constIdent.obj.setAdr(((NumConst)constIdent.getConstValue()).getN1());
			}
			if(constIdent.getConstValue() instanceof CharConst) {
				constIdent.obj.setAdr(((CharConst)constIdent.getConstValue()).getC1());
			}
			if(constIdent.getConstValue() instanceof BoolConst) {
				constIdent.obj.setAdr(((BoolConst)constIdent.getConstValue()).getB1().equals("true")?1:0);
			}
		}
		else {
			report_error("Greska: Identifikator " + constIdent.getConstName() + " je vec definisan!", constIdent);
		}
		
	}
	
	//End Global Consts
	
	//Global Vars
	
	public void visit(VarType varType) {
		varType.struct = varType.getType().struct;
		currentType = varType.struct;
	}
	
	public void visit(VarDeclaration_ varDecl) {
		currentType = null;
	}
	
	public void visit(VarIdent_ varIdent) {
		report_info("Promenljiva " + varIdent.getVarIdent(), varIdent);
		Obj varName = Tab.find(varIdent.getVarIdent());
		if(varName == Tab.noObj) {
			if(varIdent.getArrayDecl() instanceof NoArrayDeclaration) {				
				varIdent.obj = Tab.insert(Obj.Var, varIdent.getVarIdent(), currentType);
			}
			else {
				varIdent.obj = Tab.insert(Obj.Var, varIdent.getVarIdent(), new Struct(Struct.Array, currentType));
			}
		}
		else {
			report_error("Greska: Identifikator " + varIdent.getVarIdent() + " je vec definisan!", varIdent);
		}
	}
	
	public void visit(FactorExpression expression) {
		if(expression.getExpr().struct != Tab.intType) {
			report_error("Greska: Tip unutar [] mora biti int", expression);
		}
	}
	
	
	// End Global Vars
	
	// For	
	
	public void visit(OpenFor openFor) {
		forCount++;
	}
	
	public void visit(CloseFor closeFor) {
		forCount--;
	}
	
	public void visit(BreakSt breakSt) {
		if(forCount == 0) 
			report_error("Greska: break naredba se moze izvrsiti samo u okviru for petlje", breakSt);
	}
	
	public void visit(ContinueSt continueSt) {
		if(forCount == 0) 
			report_error("Greska: continue naredba se moze izvrsiti samo u okviru for petlje", continueSt);
	}
	
	// End For
	
	// Conditions
	
	public void visit(ConditionItem conditionItem) {
		if(conditionItem.getCondTerm().struct == Tab.boolType) {
			conditionItem.struct = Tab.boolType;
		}
	}
	
	public void visit(ConditionList conditionList) {
		if(conditionList.getCondition().struct == Tab.boolType 
				&& conditionList.getCondTerm().struct == Tab.boolType) {
			conditionList.struct = Tab.boolType;
		}
	}
	
	public void visit(ConditionTermItem conditionTermItem) {
		if(conditionTermItem.getCondFact().struct == Tab.boolType) {
			conditionTermItem.struct = Tab.boolType;
		}
	}
	
	public void visit(ConditionTermList conditionTermList) {
		if(conditionTermList.getCondTerm().struct == Tab.boolType 
				&& conditionTermList.getCondFact().struct == Tab.boolType) {
			conditionTermList.struct = Tab.boolType;
		}
	}
	
	public void visit(ConditionFactExpr conditionFactExpr) {
		// What about x == 3 && 2 ? Should it work?
//		if(conditionFactExpr instanceof ConditionFactExpr && 2) {
//			
//		}
	}
	
	public void visit(ConditionFact conditionFact) {
		Expr left = conditionFact.getExpr(), right = conditionFact.getExpr1();
		if(left.struct != null && right.struct != null && left.struct.compatibleWith(right.struct)) {
			if(left.struct.getKind() == Struct.Array || left.struct.getKind() == Struct.Class
					|| right.struct.getKind() == Struct.Array || right.struct.getKind() == Struct.Class) {
				
				if(conditionFact.getRelOp() instanceof Equal || conditionFact.getRelOp() instanceof NotEqual) {
					conditionFact.struct = Tab.boolType;
					report_info("Tipovi su kompatiblni", conditionFact);
				}
				else {
					report_error("Greska: Uz promenljive tipa klase ili niza, mogu se koristiti samo operatori != i ==", conditionFact);
				}
				
			} 
			else {
				conditionFact.struct = Tab.boolType;
				report_info("Tipovi su kompatiblni", conditionFact);
			}
		}
		else {
			report_error("Greska: Tipovi nisu kompatibilni", conditionFact);
		}
	}
	
	// End Conditions
	
	// Method Declaration
	
	public void visit(MethodDeclaration methodDeclaration) {
		currentMethod.setLevel(currentMethodParsCount);
		currentMethodParsCount = 0;
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		currentMethod = null;
	}
	
	public void visit(ReturnSt returnSt) {
		if(currentMethod == null) {
			report_error("Greska: return naredba se ne moze izvrsiti izvan tela metoda i funkcija", returnSt);
		}
		else {
			if(currentMethod.getType() == Tab.noType) {
				if(!(returnSt.getOptionalExpr() instanceof NoOptionalExpression)) 
					report_error("Greska: Funkcija " + currentMethod.getName() + " je tipa void i ne moze imati povratni parametar", returnSt);
			}
			else if (currentMethod.getType() != returnSt.getOptionalExpr().struct) {
				report_error("Greska: Povratni tip funkcije " + currentMethod.getName() + " se ne poklapa sa tipom u return naredbi", returnSt);
			}
		}
	}
	
	public void visit(OptionalExpression optionalExpression) {
		optionalExpression.struct = optionalExpression.getExpr().struct;
	}
	
	public void visit(MethodNameVoid methodNameVoid) {
		Obj methodName = Tab.find(methodNameVoid.getName());
		if(methodName == Tab.noObj) {			
			methodNameVoid.obj = Tab.insert(Obj.Meth, methodNameVoid.getName(), Tab.noType);
			currentMethod = methodNameVoid.obj;
			Tab.openScope();
			if(methodNameVoid.getName().equals("main")) {
				main = true;
			}
		}
		else {
			report_error("Greska: Metoda " + methodNameVoid.getName() + " je vec deklarisana", methodNameVoid);
		}
	}
	
	public void visit(MethodNameType methodNameType) {
		Obj methodName = Tab.find(methodNameType.getName());
		if(methodName == Tab.noObj) {			
			methodNameType.obj = Tab.insert(Obj.Meth, methodNameType.getName(), methodNameType.getType().struct);
			currentMethod = methodNameType.obj;
			Tab.openScope();
		}
		else {
			report_error("Greska: Metoda " + methodNameType.getName() + " je vec deklarisana", methodNameType);
		}
	}
	
	
	public void visit(FormParItem formParItem) {
		Struct type = formParItem.getType().struct;
		Obj param = Tab.find(formParItem.getFormParItem());
		if(param == Tab.noObj) {
			formParItem.obj = Tab.insert(Obj.Var, formParItem.getFormParItem(), type);
			formParItem.obj.setFpPos(currentMethodParsCount++);
		}
		else {
			if(param.getKind() != Obj.Var && param.getKind() != Obj.Con) {
				if(formParItem.getEmptyBrackets() instanceof NoEmptyBrackets) {					
					formParItem.obj = Tab.insert(Obj.Var, formParItem.getFormParItem(), type);
				}
				else {
					formParItem.obj = Tab.insert(Obj.Var, formParItem.getFormParItem(), new Struct(Struct.Array, type));
				}
				formParItem.obj.setFpPos(currentMethodParsCount++);
			}
			else {
				log.error("Greska: Identifikator " + formParItem.getFormParItem() + " je vec deklarisan.");
			}
		}
	}
	
	// End Method Declaration
	
	// Method Call
	
	
	
	public void visit(DesignatorStatementExpression designatorStatementExpression) {
//		Obj method = Tab.find(designatorStatementExpression.getDesignatorExpr())
		if(designatorStatementExpression.getDesignatorStatement() instanceof DesignatorActPars) {
			String name = designatorStatementExpression.getDesignatorExpr().getDesignatorName().getVarName();
			Obj method = Tab.find(name);
			if(method != Tab.noObj) {
				if(method.getKind() == Obj.Meth) {
					DesignatorStatement designatorStatement = designatorStatementExpression.getDesignatorStatement();
					if(designatorStatement instanceof DesignatorActPars) {
						ActParsList actPars = ((DesignatorActPars) designatorStatement).getActParsList();
						if(actPars instanceof ActParsList_ || actPars instanceof ActPars_) {
							ArrayList<Obj> vars = new ArrayList(method.getLocalSymbols());
							for(int i = 0; i < currentPars.size(); i++) {
								if(currentPars.get(i) == null || i >= method.getLevel()) {
									report_error("Greska: Navedeni argumenti se ne poklapaju sa parametrima funkcije " + name, designatorStatementExpression);
								}
								else if(!currentPars.get(i).assignableTo(vars.get(i).getType())) {
									report_error("Greska: Nisu istog tipa", designatorStatementExpression);
								}
								else {
									report_info("Uspesan poziv funkcije: " + name, designatorStatement);
								}
							}
						}
						else if(actPars instanceof NoActParsList && currentPars == null && method.getLevel() == 0) {
							report_info("Uspesan poziv funkcije: " + name, designatorStatement);
						}
					}
					method.getLocalSymbols();
				}
			}
			else {
				report_error("Greska: Funkcija " + name + " nije definisana.", designatorStatementExpression);
			}
			report_info("Poziv funkcije ", designatorStatementExpression);
			currentPars = null;
		}
	}
	
	public void visit(ActParsItem actPars) {
		if(currentPars == null) currentPars = new ArrayList();
		currentPars.add(actPars.getExpr().struct);
	}
	
	public void visit(FactorBool factorBool) {
		factorBool.struct = Tab.boolType;
	}
	
	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
	}
	
	public void visit(FactorNew factorNew) {
		factorNew.struct = factorNew.getType().struct;
	}
	
	public void visit(FactorNum factorNum) {
		factorNum.struct = Tab.intType;
	}
	
	public void visit(FactorDesignator factorDesignator) {
		factorDesignator.struct = factorDesignator.getDesignatorExpr().obj.getType();
	}
	
	public void visit(DesignatorName designatorName) {
		Obj name = Tab.find(designatorName.getVarName());
		if(name != Tab.noObj) {
			designatorName.obj = name;
		}
	}
	
	public void visit(DesignatorExpr designatorExpression) {
		Obj name = Tab.find(designatorExpression.getDesignatorName().getVarName());
		if(name == Tab.noObj) {
			designatorExpression.obj = Tab.noObj;
			report_error("Greska: Promenljiva " + designatorExpression.getDesignatorName().getVarName() + " nije deklarisana", designatorExpression);
		}
		else {
			designatorExpression.obj = name;
			if(hasDesignatorList == Boolean.FALSE) {
				if(name.getType().getKind() != designatorExpression.getDesignatorList().struct.getKind()) {
					report_error("Greska: Promenljiva " + name.getName() + " nije niz!", designatorExpression);
				}
				else {
					report_info("Pristup nizu validan", designatorExpression);
				}
			}
			else if(hasDesignatorList == null) {
//				report_info("Pristup samo identifikatoru.", designatorExpression);
			}
			else {
				//pristup za klase
			}
		}
		hasDesignatorList = null;
	}
	
	public void visit(DesignatorsList designatorsList) {
		if(designatorsList.getDesignator().struct == Tab.arrType) {			
			if(designatorsList.getDesignatorList() instanceof NoDesignatorList) {
				hasDesignatorList = false;
			}
			else {
				hasDesignatorList = true;
			}
			designatorsList.struct = Tab.arrType;
		}
	}
	
	public void visit(NoDesignatorList noDesignatorList) {
		noDesignatorList.struct = Tab.noType;
	}
	
	public void visit(DesignatorDot designatorDot) {
		Obj fieldNode = Tab.find(designatorDot.getFieldName());
		// Provera da li postoji u klasi
		if(fieldNode != Tab.noObj) {
			designatorDot.struct = fieldNode.getType();
		}
		else {
			report_error("Greska: Ne postoji identifikator " + designatorDot.getFieldName(), designatorDot);
		}
	}
	
	public void visit(DesignatorArr designatorArr) {
		designatorArr.struct = Tab.arrType;
		if(designatorArr.getExpr().struct.getKind() == Struct.Array) {
			Struct t = ((DesignatorExpr)designatorArr.getParent().getParent()).getDesignatorName().obj.getType().getElemType();
			if(t.getKind() != Struct.Int) report_error("Greska: Niz izraz u nizu mora biti tipa int!", designatorArr);
		}
		else if(designatorArr.getExpr().struct != Tab.intType) { 
			report_error("Greska: Izraz u nizu mora biti tipa int!", designatorArr);
		}
	}
	
	public void visit(FactorExpr_ expr) {
		expr.struct = expr.getExpr().struct;
	}
	
	public void visit(TermList_ termList) {
		Struct f = termList.getFactor().struct;
		Struct tl = termList.getTermList().struct;
		
		boolean expr1 = f.getElemType() == Tab.intType || f == Tab.intType;
		boolean expr2 = tl.getElemType() == Tab.intType || tl == Tab.intType;
		
		if(expr1 && expr2) {
			termList.struct = tl;
			report_info("Validno sabiranje", termList);
		}
//		if(tl.equals(f) && tl == Tab.intType) {
//			termList.struct = tl;
//			report_info("Validan termList", termList);
//		}
		else {
			report_error("Greska na liniji "+ termList.getLine()+" : nekompatibilni tipovi u izrazu za mnozenje.", null);
			termList.struct = Tab.noType;
		}
	}
	
	public void visit(TermFactor termFactor) {
		termFactor.struct = termFactor.getFactor().struct;
	}
	
	public void visit(Term term) { 
		term.struct = term.getTermList().struct;
	}
	
	public void visit(TermExpression termExpression) {
		termExpression.struct = termExpression.getTerm().struct;
	}
	
	public void visit(Expr expr) {
		expr.struct = expr.getExpression().struct;
	}
	
	public void visit(NegativeTermExpression expression) {
		expression.struct = expression.getTerm().struct;
	}
	
	public void visit(AddExpression addExpression) {
		Struct te = addExpression.getExpression().struct;
		Struct t = addExpression.getTerm().struct;
		
		boolean expr1 = t.getElemType() == Tab.intType || t == Tab.intType;
		boolean expr2 = te.getElemType() == Tab.intType || te == Tab.intType;
		
		if(expr1 && expr2) {
			addExpression.struct = te;
			report_info("Validno sabiranje", addExpression);
		}
		else {
			report_error("Greska na liniji "+ addExpression.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpression.struct = Tab.noType;
		}
	}
	
//	public void visit(DesignatorArr designatorArr) {
//		if(designatorArr.getExpr().struct.assignableTo(Tab.intType)) {
//			report_info("Okej niz", designatorArr);
//		} 
//		else {
//			report_error("Nije okej niz", designatorArr);
//		}
//	}
	
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(Program program) {
		varCount = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		if(!main) {
			errorDetected = true;
			log.error("Greska: Program nema main metodu");
		}
	}
	
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if(typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola!", null);
			type.struct = Tab.noType;
		} else {
			if(Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
//				report_info("Pronadjen tip " + type.getTypeName(), type);
			} else {
				report_error("Greska: Tip " + type.getTypeName() + " ne predstavlja tip!", type);
				type.struct = Tab.noType;
			}
		}
	}
	
}
