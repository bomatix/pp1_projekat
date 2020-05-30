package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());

	private int mainPc;
	
	private void load(Obj obj, boolean array, int index) {
		if(array) {
			Code.load(obj);
			Code.loadConst(index);
			Code.put(Code.aload);
		}
		else {
			Code.load(obj);
		}
	}
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(PrintSt printSt) {
		if(printSt.getExpr().struct == Tab.intType){
			Code.loadConst(5);
			Code.put(Code.print);
		}else{
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
		if(expr.getAssignOp() instanceof AddopRightAssign) {
			AddopRight ar = ((AddopRightAssign)expr.getAssignOp()).getAddopRight();
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
		Code.store(expr.getDesignatorExpr().obj);
	}
	
	public void visit(DesignatorExpr designatorExpr) {
		SyntaxNode parent = designatorExpr.getParent();
		
		boolean isArray = false;
		
		if(designatorExpr.getDesignatorList() instanceof DesignatorsList) {
			if(((DesignatorsList) designatorExpr.getDesignatorList()).getDesignator() instanceof DesignatorArr) {
				isArray = true;
			}
		}
		
		if(AssignExpr.class != parent.getClass()) {
			if(parent.getClass() == DesignatorStatementExpression.class)  {
				DesignatorStatementExpression dse = (DesignatorStatementExpression) parent;
				if(!(dse.getDesignatorStatement() instanceof DesignatorActPars)) {
					Code.load(designatorExpr.obj);
				}
			}
			else {				
				Code.load(designatorExpr.obj);
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
			Code.store(expression.getDesignatorExpr().obj);
		}
		else {
			Code.loadConst(1);
			Code.put(Code.sub);
			Code.store(expression.getDesignatorExpr().obj);
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
