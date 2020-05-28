// generated with ast extension for cup
// version 0.8
// 26/4/2020 23:38:6


package rs.ac.bg.etf.pp1.ast;

public class AssignExpression extends Statement {

    private AssignExprSemi AssignExprSemi;

    public AssignExpression (AssignExprSemi AssignExprSemi) {
        this.AssignExprSemi=AssignExprSemi;
        if(AssignExprSemi!=null) AssignExprSemi.setParent(this);
    }

    public AssignExprSemi getAssignExprSemi() {
        return AssignExprSemi;
    }

    public void setAssignExprSemi(AssignExprSemi AssignExprSemi) {
        this.AssignExprSemi=AssignExprSemi;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignExprSemi!=null) AssignExprSemi.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignExprSemi!=null) AssignExprSemi.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignExprSemi!=null) AssignExprSemi.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignExpression(\n");

        if(AssignExprSemi!=null)
            buffer.append(AssignExprSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignExpression]");
        return buffer.toString();
    }
}
