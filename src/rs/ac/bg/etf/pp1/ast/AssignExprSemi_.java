// generated with ast extension for cup
// version 0.8
// 29/4/2020 14:17:57


package rs.ac.bg.etf.pp1.ast;

public class AssignExprSemi_ extends AssignExprSemi {

    private AssignExpr AssignExpr;

    public AssignExprSemi_ (AssignExpr AssignExpr) {
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
        buffer.append("AssignExprSemi_(\n");

        if(AssignExpr!=null)
            buffer.append(AssignExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignExprSemi_]");
        return buffer.toString();
    }
}
