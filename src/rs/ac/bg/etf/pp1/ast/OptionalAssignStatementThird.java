// generated with ast extension for cup
// version 0.8
// 18/5/2020 22:55:47


package rs.ac.bg.etf.pp1.ast;

public class OptionalAssignStatementThird extends OptionalDesignatorStatementThird {

    private AssignExpr AssignExpr;

    public OptionalAssignStatementThird (AssignExpr AssignExpr) {
        this.AssignExpr=AssignExpr;
        if(AssignExpr!=null) AssignExpr.setParent(this);
    }

    public AssignExpr getAssignExpr() {
        return AssignExpr;
    }

    public void setAssignExpr(AssignExpr AssignExpr) {
        this.AssignExpr=AssignExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignExpr!=null) AssignExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignExpr!=null) AssignExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignExpr!=null) AssignExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalAssignStatementThird(\n");

        if(AssignExpr!=null)
            buffer.append(AssignExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalAssignStatementThird]");
        return buffer.toString();
    }
}
