package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.apache.log4j.Logger;

import com.sun.org.apache.xpath.internal.operations.Div;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	private static final int LEFT_TO_RIGHT = 1, RIGHT_TO_LEFT = 2;
	
	private Stack<SyntaxNode> ops = new Stack<>();
	private LinkedList<SyntaxNode> out = new LinkedList();
	private int arr;

	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	public CodeGenerator() {
		init();
	}
	
	private void init() {
		Code.put(Code.enter);
        Obj chrMethod = Tab.find("chr");
        chrMethod.setAdr(Code.pc);
        Obj ordMethod = Tab.find("ord");
        ordMethod.setAdr(Code.pc);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.exit);
        Code.put(Code.return_);
 
        Code.put(Code.enter);
        Obj lenMethod = Tab.find("len");
        lenMethod.setAdr(Code.pc);        
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.arraylength);
        Code.put(Code.exit);
        Code.put(Code.return_);
	}
	
	public void visit(PrintSt printSt) {
		Struct st = printSt.getExpr().struct;
		generate();
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
		out.push(constIdent);
	}
	
	public void visit(FactorNum numConst) {
		out.push(numConst);
	}
	
	public void visit(FactorChar charConst) {
		out.push(charConst);
	}
	
	public void visit(FactorBool boolConst) {
		out.push(boolConst);
	}
	
	public void visit(FactorNew factorNew) {
		addOperator(factorNew);
	}
	
	public void visit(LBracket_ op) {
		addOperator(op);
	}
	
	public void visit(RBracket_ op) {
		addOperator(op);
	}
	
	public void visit(LParen_ op) {
		addOperator(op);
	}
	
	public void visit(RParen_ op) {
		addOperator(op);
	}
	
	public void visit(NegativeTermExpression op) {
		addOperator(op);
	}
	
	public void visit(ReadSt readSt) {
		ops.push(readSt);
		generate();
	}
	
	private int getPrecedence(SyntaxNode op) {
		if(op instanceof LParen_ ||
			op instanceof RParen_ ||
			op instanceof LBracket_ ||
			op instanceof RBracket_ ||
			op instanceof DesignatorMinusMinus ||
			op instanceof DesignatorPlusPlus) {
			return 1;
		}
		else if(op instanceof Multiply ||
				op instanceof Divide ||
				op instanceof Mod || 
				op instanceof FactorNew ||
				op instanceof NegativeTermExpression) {
			return 3;
		}
		else if(op instanceof Add ||
				op instanceof Subtract) {
			return 4;
		}
		else if(op instanceof Assign ||
				op instanceof PlusEqual ||
				op instanceof MinusEqual ||
				op instanceof MulEqual ||
				op instanceof DivEqual ||
				op instanceof ModEqual) {
			return 14;
		}
		else return -1;
	}
	
	private int getAssociativity(SyntaxNode op) {
		if(op instanceof LParen_ ||
			op instanceof RParen_ ||
			op instanceof LBracket_ ||
			op instanceof RBracket_ ||
			op instanceof DesignatorMinusMinus ||
			op instanceof DesignatorPlusPlus ||
			op instanceof Multiply ||
			op instanceof Divide ||
			op instanceof Mod ||
			op instanceof Add ||
			op instanceof Subtract ||
			op instanceof NegativeTermExpression) {
			return LEFT_TO_RIGHT;
		}
		else if(op instanceof Assign ||
				op instanceof PlusEqual ||
				op instanceof MinusEqual ||
				op instanceof MulEqual ||
				op instanceof DivEqual ||
				op instanceof ModEqual ||
				op instanceof FactorNew) {
			return RIGHT_TO_LEFT;
		}
		else return -1;
	}
	
	private boolean isOperator(SyntaxNode node) {
		if(node instanceof LParen_ ||
			node instanceof RParen_ ||
			node instanceof LBracket_ ||
			node instanceof RBracket_ ||
			node instanceof DesignatorMinusMinus ||
			node instanceof DesignatorPlusPlus || 
			node instanceof Multiply ||
			node instanceof Divide ||
			node instanceof Mod ||
			node instanceof Add ||
			node instanceof Subtract ||
			node instanceof Assign ||
			node instanceof PlusEqual ||
			node instanceof MinusEqual ||
			node instanceof MulEqual ||
			node instanceof DivEqual ||
			node instanceof ModEqual ||
			node instanceof FactorNew ||
			node instanceof ReadSt ||
			node instanceof NegativeTermExpression) {
			return true;
		}
		return false;
	}
	
	private void addOperator(SyntaxNode op) {
		if(op instanceof RParen_) {
			SyntaxNode top;
			try {			
				top = ops.peek();
			}
			catch (EmptyStackException e) {
				top = null;
			}
			while(!(top instanceof LParen_)) {
				out.push(ops.pop());
				try {			
					top = ops.peek();
				}
				catch (EmptyStackException e) {
					top = null;
				}
			}
			if(top!= null && top instanceof LParen_) ops.pop();
		}
		else if(op instanceof RBracket_) {
			SyntaxNode top;
			try {			
				top = ops.peek();
			}
			catch (EmptyStackException e) {
				top = null;
			}
			while(!(top instanceof LBracket_)) {
				out.push(ops.pop());
				try {			
					top = ops.peek();
				}
				catch (EmptyStackException e) {
					top = null;
				}
			}
			if(top instanceof LBracket_) ops.pop();
			out.push(op);
		}
		else if(op instanceof LParen_ || op instanceof LBracket_) {
			ops.push(op);
		}
		else {
			
			int precedence = getPrecedence(op);
			int associativity = getAssociativity(op);
			SyntaxNode top;
			try {			
				top = ops.peek();
			}
			catch (EmptyStackException e) {
				top = null;
			}
			int topPrecedence = getPrecedence(top);
			while(top != null && 
					(topPrecedence < precedence || 
							(topPrecedence == precedence && associativity == LEFT_TO_RIGHT))
					&& !(top instanceof LParen_ || top instanceof LBracket_)) {
				out.push(ops.pop());
				try {			
					top = ops.peek();
					topPrecedence = getPrecedence(top);
				}
				catch (EmptyStackException e) {
					top = null;
				}
			}
			ops.push(op);
		}
	}
	
	private void loadOperands(LinkedList<Obj> objs) {
		Obj obj1 = objs.pop();
		
		Obj objI1 = null, objI2 = null, objArr1 = null, objArr2 = null;
		
		if(obj1.getKind() == Obj.Elem) {
			obj1 = loadNestedArray(objs, obj1);
		}
		else if(obj1.getKind() != Obj.NO_VALUE) Code.load(obj1);
		
		Obj obj2 = objs.pop();
		if(obj2.getKind() == Obj.Elem) {
			obj2 = loadNestedArray(objs, obj2);
			Code.put(Code.dup_x1); Code.put(Code.pop);
		}
		else if(obj2.getKind() != Obj.NO_VALUE) {
			Code.load(obj2);
			Code.put(Code.dup_x1); Code.put(Code.pop);
		}
		
	}
	
	private void EqualOp(LinkedList<Obj> objs, int operation) {
		Obj obj1 = objs.pop();
		Obj objI1 = null, objArr1 = null, objI2 = null, objArr2 = null;
		Obj temp = null;
		
		if(obj1.getKind() == Obj.Elem) {
			objI1 = objs.pop(); objArr1 = objs.pop();
		}
		
		Obj obj2 = objs.pop();
		// Ako je levi niz
		if(obj2.getKind() == Obj.Elem) {
			objI2 = objs.pop(); objArr2 = objs.pop();
			Code.load(objArr2);
			// Ako je desni na steku
			if(obj1.getKind() == Obj.NO_VALUE) {
				// Ako je indeks na steku
				if(objI2.getKind() == Obj.NO_VALUE) {
					Code.put(Code.dup_x2); Code.put(Code.pop); // Dupliraj levi iznad indeksa i desnog i popuj sa vrha
				}
				else {					
					Code.put(Code.dup_x1); Code.put(Code.pop); // Dupliraj levi iznad desnog i popuj sa vrha
				}
			}
			else {
				if(objI2.getKind() == Obj.NO_VALUE) {
					Code.put(Code.dup_x1); Code.put(Code.pop);
				}
			}
			
			// Ako indeks nije na steku
			if(objI2.getKind() != Obj.NO_VALUE) {				
				Code.load(objI2);
				// Ako je desni na steku
				if(obj1.getKind() == Obj.NO_VALUE) {
					Code.put(Code.dup_x1);	// Dupliraj indeks iznad desnog						
				}
				else Code.put(Code.dup); // Dupliraj indeks
			}
			else { // indeks na steku
				if(obj1.getKind() == Obj.NO_VALUE) { // desni na steku			
					Code.put(Code.dup_x1); Code.put(Code.pop); Code.put(Code.dup_x1);
				}
				else Code.put(Code.dup);
			}
			Code.load(objArr2);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			
			Code.load(obj2);
			if(obj1.getKind() == Obj.NO_VALUE) {
				Code.put(Code.dup_x1); Code.put(Code.pop);								
			}
		}
		else {
			Code.load(obj2);
			if(obj1.getKind() == Obj.NO_VALUE) {
				Code.put(Code.dup_x1); Code.put(Code.pop);
			}
		}
		
		if(obj1.getKind() == Obj.Elem) {
			Code.load(objArr1);
			Code.load(objI1);
			Code.load(obj1);
		}
		else if(obj1.getKind() != Obj.NO_VALUE) {						
			Code.load(obj1);
		}
		Code.put(operation);
		if(obj2.getKind() == Obj.Elem) {
			Code.put(Code.dup_x2);
		}
		else {
			Code.put(Code.dup);						
		}
		
		Code.store(obj2);
		objs.push(new Obj(Obj.NO_VALUE, "$", Tab.intType));
	}
	
	private Obj loadNestedArray(LinkedList<Obj> objs, Obj start) {
		Obj obj = objs.pop(), objI = null;
		
		if(obj.getKind() == Obj.Elem) {
			objI = loadNestedArray(objs, obj);
		}
		else objI = obj;
		Obj objArr = objs.pop();
		Code.load(objArr);
		if(objI.getKind() == Obj.NO_VALUE) {
			Code.put(Code.dup_x1); Code.put(Code.pop);
		}
		else {			
			Code.load(objI);
		}
		Code.load(start);
		Obj ret = new Obj(Obj.NO_VALUE, "$", Tab.intType);
		return ret;
	}
	
	private void storeNestedArray(LinkedList<Obj> objs, Obj start) {
		storeNestedArray(objs, start, true);
	}
	
	private Obj storeNestedArray(LinkedList<Obj> objs, Obj start, boolean first) {
		Obj obj = objs.pop(), objI = null;
		
		if(obj.getKind() == Obj.Elem) {
//			objI = loadNestedArray(objs, obj);
			objI = storeNestedArray(objs, obj, false);
			Code.put(Code.dup_x1); Code.put(Code.pop);
		}
		else objI = obj;
		Obj objArr = objs.pop();
		Code.load(objArr);
		if(objI.getKind() == Obj.NO_VALUE) {
			Code.put(Code.dup_x2); Code.put(Code.pop);
		}
		else {
			Code.put(Code.dup_x1); Code.put(Code.pop);
			Code.load(objI);
			Code.put(Code.dup_x1); Code.put(Code.pop);
		}
		Obj ret = new Obj(Obj.NO_VALUE, "$", Tab.intType);
		if(!first) {
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
			Code.load(start);
		}
		return ret;
	}
	
	
	// kada treba koristiti vrednost elementa niza i upisati u element niza
	private void storeLoadNestedArray(LinkedList<Obj> objs, Obj start) {
		Obj obj = objs.pop(), objI = null;
		
		if(obj.getKind() == Obj.Elem) {
			objI = loadNestedArray(objs, obj);
		}
		else objI = obj;
		Obj objArr = objs.pop();
		Code.load(objArr);
		if(objI.getKind() == Obj.NO_VALUE) {
			Code.put(Code.dup_x2); Code.put(Code.pop);
			Code.put(Code.dup_x1);
		}
		else {
			Code.put(Code.dup_x1); Code.put(Code.pop);
			Code.load(objI);
			Code.put(Code.dup_x1);
		}
		Code.load(objArr);
		Code.put(Code.dup_x1); Code.put(Code.pop);
		Code.load(start);
		Code.put(Code.dup_x1); Code.put(Code.pop);
	}
	
	private void generate() {
		LinkedList<Obj> objs = new LinkedList<>();
		boolean newArray = false, loadArray = false;
		while(!ops.isEmpty()) {
			out.push(ops.pop());
		}
		while(!out.isEmpty()) {
			SyntaxNode sn = out.pollLast();
			if(sn instanceof RBracket_) {
				objs.push(new Obj(Obj.Elem, "$", Tab.intType));
			}
			else if(!isOperator(sn)) {
				Obj obj = null;
				if(sn instanceof DesignatorName) {
					obj = ((DesignatorName) sn).obj;
					if(obj.getType().getKind() == Struct.Array) arr++;
				}
				else if(sn instanceof FactorNum) {
					obj = new Obj(Obj.Con, "$", Tab.intType);
					obj.setLevel(0);
					obj.setAdr(((FactorNum)sn).getN1());
				}
				else if(sn instanceof NumConst) {
					obj = new Obj(Obj.Con, "$", Tab.intType);
					obj.setLevel(0);
					obj.setAdr(((NumConst)sn).getN1());
				}
				else if(sn instanceof CharConst) {
					obj = new Obj(Obj.Con, "$", Tab.charType);
					obj.setLevel(0);
					obj.setAdr(((CharConst)sn).getC1());
				}
				else if(sn instanceof FactorChar) {
					obj = new Obj(Obj.Con, "$", Tab.charType);
					obj.setLevel(0);
					obj.setAdr(((FactorChar)sn).getC1());
				}
				else if(sn instanceof BoolConst) {
					obj = new Obj(Obj.Con, "$", Tab.charType);
					obj.setLevel(0);
					obj.setAdr(((BoolConst)sn).getB1().equals("true")?1:0);
				}
				else if(sn instanceof FactorBool) {
					obj = new Obj(Obj.Con, "$", Tab.charType);
					obj.setLevel(0);
					obj.setAdr(((FactorBool)sn).getB1().equals("true")?1:0);
				}
				objs.push(obj);
			}
			else {
				if(sn instanceof NegativeTermExpression) {
					Obj obj = objs.pop();
					if(obj.getKind() == Obj.Elem) {
						loadNestedArray(objs, obj);
					}
					else if(obj.getKind() != Obj.NO_VALUE) Code.load(obj);
					Code.loadConst(-1);
					Code.put(Code.mul);
					objs.push(new Obj(Obj.NO_VALUE, "$", Tab.intType));
				}
				
				if(sn instanceof FactorNew) {
					FactorNew fn = (FactorNew) sn;
					if(fn.getFactorExpr() instanceof FactorExpr) {
						newArray = true;
						Obj obj = objs.pop();
						if(obj.getKind() != Obj.NO_VALUE) 
							Code.load(obj);
						Code.put(Code.newarray);
						if(fn.getType().struct == Tab.charType) {
							Code.put(0);
						}
						else {
							Code.put(1);
						}
					}
				}
				
				if(sn instanceof DesignatorPlusPlus) {
					Obj obj = objs.pop();
					Code.loadConst(1);
					if(obj.getKind() == Obj.Elem) {						
						storeLoadNestedArray(objs, obj);
					}
					else {
						Code.load(obj);
						Code.put(Code.dup_x1); Code.put(Code.pop);
					}
					Code.put(Code.add);
					Code.store(obj);
				}
				if(sn instanceof DesignatorMinusMinus) {
					Obj obj = objs.pop();
					Code.loadConst(1);
					if(obj.getKind() == Obj.Elem) {						
						storeLoadNestedArray(objs, obj);
					}
					else {
						Code.load(obj);
						Code.put(Code.dup_x1); Code.put(Code.pop);
					}
					Code.put(Code.sub);
					Code.store(obj);
				}
				if(sn instanceof Assign) {	
					Obj obj1 = null, obj2 = null;
					Obj objI1 = null, objArr1 = null, objI2 = null, objArr2 = null;
					if(!newArray) {						
						obj1 = objs.pop();
						if(obj1.getKind() == Obj.Elem) {
							obj1 = loadNestedArray(objs, obj1);
						}
						else if(obj1.getKind() != Obj.NO_VALUE) Code.load(obj1);
						obj2 = objs.pop();
						if(obj2.getKind() == Obj.Elem) {
							storeNestedArray(objs, obj2);
						}
					}
					else {
						newArray = false;
						obj2 = objs.pop();	
					}
					Code.store(obj2);
				}
				
				
				if(sn instanceof PlusEqual) {
					EqualOp(objs, Code.add);
				}
				if(sn instanceof MinusEqual) {
					EqualOp(objs, Code.sub);
				}
				if(sn instanceof MulEqual) {
					EqualOp(objs, Code.mul);
				}
				if(sn instanceof DivEqual) {
					EqualOp(objs, Code.div);
				}
				if(sn instanceof ModEqual) {
					EqualOp(objs, Code.rem);
				}
				
				
				if(sn instanceof Multiply) {
					loadOperands(objs);
					Code.put(Code.mul);
					objs.push(new Obj(Obj.NO_VALUE, "$", Tab.intType));
					
				}
				if(sn instanceof Divide) {
					loadOperands(objs);
					Code.put(Code.div);
					objs.push(new Obj(Obj.NO_VALUE, "$", Tab.intType));
				}
				if(sn instanceof Mod) {
					loadOperands(objs);
					Code.put(Code.rem);
					objs.push(new Obj(Obj.NO_VALUE, "$", Tab.intType));
				}
				if(sn instanceof Add) {
					loadOperands(objs);
					Code.put(Code.add);
					objs.push(new Obj(Obj.NO_VALUE, "$", Tab.intType));
				}
				if(sn instanceof Subtract) {
					loadOperands(objs);
					Code.put(Code.sub);
					objs.push(new Obj(Obj.NO_VALUE, "$", Tab.intType));
				}
				
				if(sn instanceof ReadSt) {
					Obj obj = objs.pop();
					Code.put(Code.read);
					if(obj.getKind() == Obj.Elem) {
						storeNestedArray(objs, obj);
						Code.store(obj);
					}
					else {
						Code.store(obj);
					}
				}
			}
		}
		
		
		// THINK ABOUT THIS
		// UNUSED VALUES LEFT ON STACK
		while(!objs.isEmpty()) {
			Obj obj = objs.pop();	
			if(obj.getKind() == Obj.Elem) {
				loadNestedArray(objs, obj);
			}
			else if(obj.getKind() != Obj.NO_VALUE) Code.load(obj);

		}
	}
	
	
	public void visit(Multiply mul) {
		addOperator(mul);
	}
	
	public void visit(Divide div) {
		addOperator(div);
	}
	
	public void visit(Mod mod) {
		addOperator(mod);
	}
	
	public void visit(Add add) {
		addOperator(add);
	}
	
	public void visit(Subtract min) {
		addOperator(min);
	}

	public void visit(Assign equal) {
		addOperator(equal);
	}

	public void visit(PlusEqual plusEqual) {
		addOperator(plusEqual);
	}
	
	public void visit(MinusEqual minusEqual) {
		addOperator(minusEqual);
	}
	
	public void visit(MulEqual mulEqual) {
		addOperator(mulEqual);
	}
	
	public void visit(DivEqual divEqual) {
		addOperator(divEqual);
	}
	
	public void visit(ModEqual modEqual) {
		addOperator(modEqual);
	}
	
	public void visit(DesignatorPlusPlus plusPlus) {
		addOperator(plusPlus);
	}
	
	public void visit(DesignatorMinusMinus minusMinus) {
		addOperator(minusMinus);
	}
	
	public void visit(AssignExpr_ expr) {
		generate();
	}
	
	public void visit(DesignatorSt designatorSt) {
		DesignatorStatementExpression dse = (DesignatorStatementExpression)designatorSt.getDesignatorStatementExpr();
		if(dse.getDesignatorStatement() instanceof DesignatorActPars) {
			Code.put(Code.call);
			Code.put2(dse.getDesignatorExpr().getDesignatorName().obj.getAdr() - Code.pc + 1);
		}
		else {			
			generate();
		}
	}
	
	
	public void visit(DesignatorName designatorName) {
		out.push(designatorName);
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
