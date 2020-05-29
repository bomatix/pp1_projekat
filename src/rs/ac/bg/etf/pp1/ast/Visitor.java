// generated with ast extension for cup
// version 0.8
// 29/4/2020 15:9:45


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(FormPars FormPars);
    public void visit(Factor Factor);
    public void visit(DesignatorPars DesignatorPars);
    public void visit(Statement Statement);
    public void visit(CondFactExpr CondFactExpr);
    public void visit(DesignatorStatementExpr DesignatorStatementExpr);
    public void visit(EmptyBrackets EmptyBrackets);
    public void visit(MethodDecl MethodDecl);
    public void visit(FactorExpr FactorExpr);
    public void visit(ActParsExpression ActParsExpression);
    public void visit(AddopLeft AddopLeft);
    public void visit(AddopRight AddopRight);
    public void visit(ExprList ExprList);
    public void visit(AbstractMethodDecl AbstractMethodDecl);
    public void visit(MulopRight MulopRight);
    public void visit(DeclList DeclList);
    public void visit(AllMethodsDeclList AllMethodsDeclList);
    public void visit(MulopLeft MulopLeft);
    public void visit(TypeVoid TypeVoid);
    public void visit(OptionalDesignatorStatement OptionalDesignatorStatement);
    public void visit(AbstractClassDecl AbstractClassDecl);
    public void visit(VarDecl VarDecl);
    public void visit(OptionalPrintParam OptionalPrintParam);
    public void visit(RelOp RelOp);
    public void visit(AllMethodDecl AllMethodDecl);
    public void visit(FormParsList FormParsList);
    public void visit(DesignatorList DesignatorList);
    public void visit(AssignExprSemi AssignExprSemi);
    public void visit(Condition Condition);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(OptionalDesignatorStatementThird OptionalDesignatorStatementThird);
    public void visit(ArrayDecl ArrayDecl);
    public void visit(StatementList StatementList);
    public void visit(ConstIdent ConstIdent);
    public void visit(ConstDecl ConstDecl);
    public void visit(ForDesignatorStatement ForDesignatorStatement);
    public void visit(VarIdentList VarIdentList);
    public void visit(MulOp MulOp);
    public void visit(CondTerm CondTerm);
    public void visit(ClassDecl ClassDecl);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(AssignExpr AssignExpr);
    public void visit(Expression Expression);
    public void visit(AddOp AddOp);
    public void visit(ConstValue ConstValue);
    public void visit(VarIdent VarIdent);
    public void visit(AssignOp AssignOp);
    public void visit(TermList TermList);
    public void visit(Extends Extends);
    public void visit(OptionalCondition OptionalCondition);
    public void visit(MethodName MethodName);
    public void visit(ActPars ActPars);
    public void visit(OptionalMinus OptionalMinus);
    public void visit(Designator Designator);
    public void visit(VarDeclList VarDeclList);
    public void visit(CondFact CondFact);
    public void visit(OptionalExpr OptionalExpr);
    public void visit(ActParsList ActParsList);
    public void visit(Decl Decl);
    public void visit(ConstIdents ConstIdents);
    public void visit(LessEqual LessEqual);
    public void visit(Less Less);
    public void visit(GreaterEqual GreaterEqual);
    public void visit(Greater Greater);
    public void visit(NotEqual NotEqual);
    public void visit(Equal Equal);
    public void visit(ModEqual ModEqual);
    public void visit(DivEqual DivEqual);
    public void visit(MulEqual MulEqual);
    public void visit(Mod Mod);
    public void visit(Divide Divide);
    public void visit(Multiply Multiply);
    public void visit(MulopRight_ MulopRight_);
    public void visit(MulopLeft_ MulopLeft_);
    public void visit(MinusEqual MinusEqual);
    public void visit(PlusEqual PlusEqual);
    public void visit(Subtract Subtract);
    public void visit(Add Add);
    public void visit(AddopRight_ AddopRight_);
    public void visit(AddopLeft_ AddopLeft_);
    public void visit(MulopRightAssign MulopRightAssign);
    public void visit(AddopRightAssign AddopRightAssign);
    public void visit(Assign Assign);
    public void visit(DesignatorArr DesignatorArr);
    public void visit(DesignatorDot DesignatorDot);
    public void visit(NoDesignatorList NoDesignatorList);
    public void visit(DesignatorsList DesignatorsList);
    public void visit(DesignatorExpr DesignatorExpr);
    public void visit(NoDesignatorPars NoDesignatorPars);
    public void visit(DesignatorPars_ DesignatorPars_);
    public void visit(ConditionFactExpr ConditionFactExpr);
    public void visit(ConditionFact ConditionFact);
    public void visit(ConditionTermItem ConditionTermItem);
    public void visit(ConditionTermList ConditionTermList);
    public void visit(ConditionItem ConditionItem);
    public void visit(ConditionList ConditionList);
    public void visit(AssignExprSemiError AssignExprSemiError);
    public void visit(AssignExprSemi_ AssignExprSemi_);
    public void visit(AssignExpr_ AssignExpr_);
    public void visit(DesignatorMinusMinus DesignatorMinusMinus);
    public void visit(DesignatorPlusPlus DesignatorPlusPlus);
    public void visit(DesignatorActPars DesignatorActPars);
    public void visit(DesignatorStatementExpression DesignatorStatementExpression);
    public void visit(FactorExpression FactorExpression);
    public void visit(FactorExpr_ FactorExpr_);
    public void visit(FactorNew FactorNew);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(ActParsItem ActParsItem);
    public void visit(NoActParsList NoActParsList);
    public void visit(ActPars_ ActPars_);
    public void visit(ActParsList_ ActParsList_);
    public void visit(TermFactor TermFactor);
    public void visit(TermList_ TermList_);
    public void visit(Term Term);
    public void visit(TermExpression TermExpression);
    public void visit(AddExpression AddExpression);
    public void visit(Expr Expr);
    public void visit(NoMinus NoMinus);
    public void visit(Minus Minus);
    public void visit(NoOptionalExpression NoOptionalExpression);
    public void visit(OptionalExpression OptionalExpression);
    public void visit(OptionalConditionError OptionalConditionError);
    public void visit(NoOptionalCondition NoOptionalCondition);
    public void visit(OptionalCondition_ OptionalCondition_);
    public void visit(OptionalAssignStatementThird OptionalAssignStatementThird);
    public void visit(NoOptionalDesignatorStatementThird NoOptionalDesignatorStatementThird);
    public void visit(OptionalDesignatorStatementThird_ OptionalDesignatorStatementThird_);
    public void visit(OptionalAssignStatement OptionalAssignStatement);
    public void visit(NoOptionalDesignatorStatement NoOptionalDesignatorStatement);
    public void visit(OptionalDesignatorStatement_ OptionalDesignatorStatement_);
    public void visit(OptionalPrintParam_ OptionalPrintParam_);
    public void visit(CloseFor CloseFor);
    public void visit(OpenFor OpenFor);
    public void visit(Statements Statements);
    public void visit(PrintSt PrintSt);
    public void visit(ReadSt ReadSt);
    public void visit(ReturnSt ReturnSt);
    public void visit(ContinueSt ContinueSt);
    public void visit(AssignExpression AssignExpression);
    public void visit(BreakSt BreakSt);
    public void visit(ForSt ForSt);
    public void visit(IfSt IfSt);
    public void visit(IfElseSt IfElseSt);
    public void visit(DesignatorSt DesignatorSt);
    public void visit(NoStatementList NoStatementList);
    public void visit(StatementList_ StatementList_);
    public void visit(ClassName ClassName);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(AbstractMethodDeclaration_ AbstractMethodDeclaration_);
    public void visit(MethodDeclaration_ MethodDeclaration_);
    public void visit(NoAllMethodsDeclarationList NoAllMethodsDeclarationList);
    public void visit(AllMethodsDeclarationList AllMethodsDeclarationList);
    public void visit(ExtendsErrorAll ExtendsErrorAll);
    public void visit(ExtendsError ExtendsError);
    public void visit(NoExtends NoExtends);
    public void visit(Extends_ Extends_);
    public void visit(AbstractClassDeclaration AbstractClassDeclaration);
    public void visit(Type Type);
    public void visit(AbstractMethodDeclarationError AbstractMethodDeclarationError);
    public void visit(AbstractMethodDeclaration AbstractMethodDeclaration);
    public void visit(NoEmptyBrackets NoEmptyBrackets);
    public void visit(EmptyBrackets_ EmptyBrackets_);
    public void visit(FormParItem FormParItem);
    public void visit(FormParsListError FormParsListError);
    public void visit(NoFormParsList NoFormParsList);
    public void visit(FormParsListItem FormParsListItem);
    public void visit(FormParsList_ FormParsList_);
    public void visit(FormParsError FormParsError);
    public void visit(FormPars_ FormPars_);
    public void visit(NoVarDeclaration NoVarDeclaration);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(MethodNameType MethodNameType);
    public void visit(MethodNameVoid MethodNameVoid);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(NoMethodDeclarations NoMethodDeclarations);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(Voidd Voidd);
    public void visit(Type_ Type_);
    public void visit(NoArrayDeclaration NoArrayDeclaration);
    public void visit(ArrayDeclaration ArrayDeclaration);
    public void visit(VarType VarType);
    public void visit(VarIdent_ VarIdent_);
    public void visit(NoVarIdentList NoVarIdentList);
    public void visit(VarIdentError VarIdentError);
    public void visit(VarIdentList_ VarIdentList_);
    public void visit(VarDeclError VarDeclError);
    public void visit(VarDeclaration_ VarDeclaration_);
    public void visit(ConstType ConstType);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(ConstIdent_ ConstIdent_);
    public void visit(NoConstIdents NoConstIdents);
    public void visit(ConstIdents_ ConstIdents_);
    public void visit(ConstDeclaration_ ConstDeclaration_);
    public void visit(ClassDeclaration_ ClassDeclaration_);
    public void visit(AbstractClassDeclaration_ AbstractClassDeclaration_);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(NoDeclarationList NoDeclarationList);
    public void visit(Declarations Declarations);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
