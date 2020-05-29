package rs.ac.bg.etf.pp1;

import java.util.ArrayList;

import org.apache.log4j.Logger;

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

	public void report_error(String message, SyntaxNode info) {
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
	
	// End Global Vars
	
	public void visit(MethodDeclarations methodDeclarations) {
		
	}
	
	public void visit(MethodDeclaration methodDeclaration) {
		currentMethod.setLevel(currentMethodParsCount);
		currentMethodParsCount = 0;
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		currentMethod = null;
	}
	
	public void visit(MethodNameVoid methodNameVoid) {
		Obj methodName = Tab.find(methodNameVoid.getName());
		if(methodName == Tab.noObj) {			
			methodNameVoid.obj = Tab.insert(Obj.Meth, methodNameVoid.getName(), Tab.noType);
			currentMethod = methodNameVoid.obj;
			Tab.openScope();
		}
		else {
			report_error("Greska: Metoda " + methodNameVoid.getName() + " je vec deklarisana", methodNameVoid);
		}
	}
	
	public void visit(MethodNameType methodNameType) {
		Obj methodName = Tab.find(methodNameType.getName());
		if(methodName == Tab.noObj) {			
			methodNameType.obj = Tab.insert(Obj.Meth, methodNameType.getName(), Tab.noType);
			currentMethod = methodNameType.obj;
			Tab.openScope();
		}
		else {
			report_error("Greska: Metoda " + methodNameType.getName() + " je vec deklarisana", methodNameType);
		}
	}
	
	public void visit(FormPars_ formPars) {
		
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
	
	public void visit(DesignatorStatementExpression designatorStatementExpression) {
//		Obj method = Tab.find(designatorStatementExpression.getDesignatorExpr())
		if(designatorStatementExpression.getDesignatorStatement() instanceof DesignatorActPars) {
			String name = designatorStatementExpression.getDesignatorExpr().getVarName();
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
		
	}
	
	public void visit(DesignatorExpr designatorExpression) {
		Obj name = Tab.find(designatorExpression.getVarName());
		if(name == Tab.noObj) {
			designatorExpression.obj = Tab.noObj;
			report_error("Greska: Promenljiva " + designatorExpression.getVarName() + " nije deklarisana", designatorExpression);
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
		if(designatorArr.getExpr().struct != Tab.intType) { 
			report_error("Greska: Izraz u nizu mora biti tipe int!", designatorArr);
		}
	}
	
	
	public void visit(TermList_ termList) {
		Struct f = termList.getFactor().struct;
		Struct tl = termList.getTermList().struct;
		if(tl.equals(f) && tl == Tab.intType) {
			termList.struct = tl;
			report_info("Validan termList", termList);
		}
		else {
			report_error("Greska na liniji "+ termList.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
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
	
	public void visit(AddExpression addExpression) {
		Struct te = addExpression.getExpression().struct;
		Struct t = addExpression.getTerm().struct;
		if(te.equals(t) && te == Tab.intType) {
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
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
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
