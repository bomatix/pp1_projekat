package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	private Stack<Obj> vars = new Stack<>();
	private Stack<InstrObj> io = new Stack<>();

	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(PrintSt printSt) {
		Struct st = printSt.getExpr().struct;
		if(st.getKind() == Struct.Int){
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else if (st.getKind() == Struct.Array && st.getElemType() == Tab.intType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(ConstIdent constIdent) {
		Code.load(constIdent.obj);
	}
	
	public void visit(VarIdent varIdent) {
		Code.load(varIdent.obj);
	}
	
	public void visit(NumConst numConst) {
		Obj cnst = Tab.insert(Obj.Con, "$", Tab.intType);
		cnst.setLevel(0);
		cnst.setAdr(numConst.getN1());
		
		Code.load(cnst);
	}
	
	public void visit(CharConst charConst) {
		Obj cnst = Tab.insert(Obj.Con, "$", Tab.charType);
		cnst.setLevel(0);
		cnst.setAdr(charConst.getC1());
		
		Code.load(cnst); 
	}
	
	public void visit(BoolConst boolConst) {
		Obj cnst = Tab.insert(Obj.Con, "$", Tab.boolType);
		cnst.setLevel(0);
		int boolValue  = 0;
		if(boolConst.getB1().equals("true")) boolValue = 1;
		cnst.setAdr(boolValue);
				
		Code.load(cnst);
	}
	
	public void visit(FactorNum numConst) {
		Obj cnst = Tab.insert(Obj.Con, "$", Tab.intType);
		cnst.setLevel(0);
		cnst.setAdr(numConst.getN1());
		
		Code.load(cnst);
	}
	
	public void visit(FactorChar charConst) {
		Obj cnst = Tab.insert(Obj.Con, "$", Tab.charType);
		cnst.setLevel(0);
		cnst.setAdr(charConst.getC1());
		
		Code.load(cnst); 
	}
	
	public void visit(FactorBool boolConst) {
		Obj cnst = Tab.insert(Obj.Con, "$", Tab.boolType);
		cnst.setLevel(0);
		int boolValue  = 0;
		if(boolConst.getB1().equals("true")) boolValue = 1;
		cnst.setAdr(boolValue);
				
		Code.load(cnst);
	}
	
	public void visit(FactorNew factorNew) {
		if(factorNew.getFactorExpr() instanceof FactorExpr) {
			Code.put(Code.newarray);
			if(factorNew.getType().struct == Tab.charType) {
				Code.put(0);
			}
			else {
				Code.put(1);
			}
		}
	}
	
	public void visit(AssignExpr_ expr) {
		DesignatorList dl = expr.getDesignatorExpr().getDesignatorList();
		if(expr.getAssignOp() instanceof AddopRightAssign) {
			AddopRight ar = ((AddopRightAssign)expr.getAssignOp()).getAddopRight();
//			if(dl instanceof DesignatorsList) {
//				Code.load(new Obj(Obj.Elem, "$", expr.getDesignatorExpr().obj.getType().getElemType()));
//			}
			if(ar instanceof PlusEqual) {				
				Code.put(Code.add);
			}
			else if(ar instanceof MinusEqual) {				
				Code.put(Code.sub);
			}
		}
		else if(expr.getAssignOp() instanceof MulopRightAssign) {
			MulopRight mr = ((MulopRightAssign)expr.getAssignOp()).getMulopRight();
			if(mr instanceof MulEqual) {
				Code.put(Code.mul);
			}
			else if(mr instanceof DivEqual) {
				Code.put(Code.div);
			}
			else {
				Code.put(Code.rem);
			}
		}
		if(dl instanceof DesignatorsList) {
			Code.store(new Obj(Obj.Elem, "$", expr.getDesignatorExpr().obj.getType().getElemType()));
		}
		else {			
			Code.store(expr.getDesignatorExpr().obj);
		}
	}
	
	public void visit(NegativeTermExpression expression) {
		Code.loadConst(-1);
		Code.put(Code.mul);
	}
	
	public void visit(DesignatorExpr designatorExpr) {
		SyntaxNode parent = designatorExpr.getParent();
		
		// Nije dodela nego Expr
		if(AssignExpr_.class != parent.getClass()) {
			// DesignatorStatementExpr => Statement
			if(parent.getClass() == DesignatorStatementExpression.class)  {
				DesignatorStatementExpression dse = (DesignatorStatementExpression) parent;
				// Ako nije funkcija
				if(!(dse.getDesignatorStatement() instanceof DesignatorActPars)) {
					if(!(designatorExpr.obj.getType().getKind() == Struct.Array && designatorExpr.getDesignatorList() instanceof DesignatorList)) {						
						Code.load(designatorExpr.obj);
					}
					else {
						Code.put(Code.dup2);
						Code.load(new Obj(Obj.Elem, "$", designatorExpr.obj.getType().getElemType()));
					}
					
				}
			}
			else {				
				if(designatorExpr.obj.getType().getKind() == Struct.Array && designatorExpr.getDesignatorList() instanceof DesignatorList) {
					Code.load(new Obj(Obj.Elem, "$", designatorExpr.obj.getType().getElemType()));
				}
			}
		}
		else {
			AssignOp ao = ((AssignExpr_) parent).getAssignOp();
			if(ao instanceof AddopRightAssign || ao instanceof MulopRightAssign) {
				if(designatorExpr.getDesignatorList() instanceof DesignatorsList) {
					Code.put(Code.dup2);
					Code.load(new Obj(Obj.Elem, "$", designatorExpr.obj.getType().getElemType()));
				}
			}
		}
	}
	
	public void visit(DesignatorName designatorName) {
		DesignatorList dl = ((DesignatorExpr)designatorName.getParent()).getDesignatorList();
		if(dl instanceof DesignatorsList) {
			Code.load(designatorName.obj);
		}
		else if(designatorName.getParent().getParent().getClass() != AssignExpr_.class) {
			Code.load(designatorName.obj);
			vars.add(designatorName.obj);
//			io.push(new InstrObj(designatorName.obj));
		}
		else {
			AssignExpr_ ae = (AssignExpr_)designatorName.getParent().getParent();
			if(ae.getAssignOp() instanceof AddopRightAssign || ae.getAssignOp() instanceof MulopRightAssign) {
				Code.load(designatorName.obj);
			}
		}
	}
	
	public void visit(TermList_ termList) {
		MulOp mulOp = termList.getMulOp();
		if(mulOp instanceof MulopLeft_) {
			if(((MulopLeft_) mulOp).getMulopLeft() instanceof Multiply) {
				Code.put(Code.mul);
			}
			if(((MulopLeft_) mulOp).getMulopLeft() instanceof Divide) {
				Code.put(Code.div);
			}
			if(((MulopLeft_) mulOp).getMulopLeft() instanceof Mod) {
				Code.put(Code.rem);
			}
		}
		else {
			if(((MulopRight_) mulOp).getMulopRight() instanceof DivEqual) {
//				Code.put(Code.div);
//				Code.put(Code.dup);
//				Code.store(vars.pop());
				Obj var = vars.remove(0);
				io.push(new InstrObj(-1, var));
				io.push(new InstrObj(var));
//				io.push(new InstrObj(Code.dup));
				io.push(new InstrObj(Code.div));
			}
			else if(((MulopRight_) mulOp).getMulopRight() instanceof MulEqual) {
//				Code.put(Code.mul);
//				Code.put(Code.dup);
//				Code.store(vars.pop());
				Obj var = vars.remove(0);
				io.push(new InstrObj(-1, var));
				io.push(new InstrObj(var));
//				io.push(new InstrObj(Code.dup));
				io.push(new InstrObj(Code.mul));
			}
			else if(((MulopRight_) mulOp).getMulopRight() instanceof ModEqual) {
//				Code.put(Code.rem);
//				Code.put(Code.dup);
//				Code.store(vars.pop());
				Obj var = vars.remove(0);
				io.push(new InstrObj(-1, var));
				io.push(new InstrObj(var));
//				io.push(new InstrObj(Code.dup));
				io.push(new InstrObj(Code.rem));
			}
		}
	}
	
	public void visit(Expr expr) {
		if(expr.getExpression() instanceof AddExpression) {
			while(!io.isEmpty()) {
				InstrObj instrObj = io.pop();
				if(instrObj.obj != null) {
					if(instrObj.instr == -1) {
						Code.load(instrObj.obj);
					}
					else {						
						Code.store(instrObj.obj);
					}
				}
				else {
					Code.put(instrObj.instr);
				}
			}
		}
	}
	
	public void visit(AddExpression addExpression) {
		AddOp addop = addExpression.getAddOp();
		if(addop instanceof AddopLeft_) {
			if(((AddopLeft_) addop).getAddopLeft() instanceof Add) {
				Code.put(Code.add);
			}
			if(((AddopLeft_) addop).getAddopLeft() instanceof Subtract) {
				Code.put(Code.sub);
			}
		}
		else {
			if(((AddopRight_) addop).getAddopRight() instanceof PlusEqual) {
				Obj var = vars.remove(0);
				io.push(new InstrObj(-1, var));
				io.push(new InstrObj(var));
//				io.push(new InstrObj(Code.dup));
				io.push(new InstrObj(Code.add));
			}
			else if(((AddopRight_) addop).getAddopRight() instanceof MinusEqual) {
				Obj var = vars.remove(0);
				io.push(new InstrObj(-1, var));
				io.push(new InstrObj(var));
//				io.push(new InstrObj(Code.dup));
				io.push(new InstrObj(Code.add));
			}
		}
	}
	
	public void visit(ActParsItem item) {
//		Code.load(item.getExpr());
	}
	
	public void visit(DesignatorStatementExpression expression) {
		Obj method = expression.getDesignatorExpr().obj;
		if(expression.getDesignatorStatement() instanceof DesignatorActPars) {			
			int offset = method.getAdr() - Code.pc;
			Code.put(Code.call);
			Code.put2(offset);
			if(method.getType() != Tab.noType){
				Code.put(Code.pop);
			}
		}
		else if(expression.getDesignatorStatement() instanceof DesignatorPlusPlus) {
			Code.loadConst(1);
			Code.put(Code.add);
			if(expression.getDesignatorExpr().getDesignatorList() instanceof DesignatorsList) {
				Code.store(new Obj(Obj.Elem, "$", expression.getDesignatorExpr().obj.getType().getElemType()));
			}
			else {				
				Code.store(expression.getDesignatorExpr().obj);
			}
		}
		else {
			Code.loadConst(1);
			Code.put(Code.sub);
			if(expression.getDesignatorExpr().getDesignatorList() instanceof DesignatorsList) {
				Code.store(new Obj(Obj.Elem, "$", expression.getDesignatorExpr().obj.getType().getElemType()));
			}
			else {				
				Code.store(expression.getDesignatorExpr().obj);
			}
		}
	}

	public void visit(MethodNameVoid methodNameVoid) {
		if("main".equalsIgnoreCase(methodNameVoid.getName())){
			mainPc = Code.pc;
		}
		
		methodNameVoid.obj.setAdr(Code.pc);
		
		Code.put(Code.enter);
		Code.put(methodNameVoid.obj.getLevel());
		Code.put(methodNameVoid.obj.getLocalSymbols().size());
	}
	
	public void visit(MethodNameType methodNameType) {
		// TODO: Pogledati povratnu vrednost
		methodNameType.obj.setAdr(Code.pc);	
		
		Code.put(Code.enter);
		Code.put(methodNameType.obj.getLevel());
		Code.put(methodNameType.obj.getLocalSymbols().size());
	}
	
	public void visit(MethodDeclaration methodDeclaration) {
		// Pogledati uslov ??
		// U return staviti proveru da li ima return narede
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(ReturnSt returnSt) {
		if(Code.buf[Code.pc - 1] != Code.return_) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		}
	}
	
	
}
