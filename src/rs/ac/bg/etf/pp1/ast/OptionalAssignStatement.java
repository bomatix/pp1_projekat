// generated with ast extension for cup
// version 0.8
// 20/5/2020 22:23:9


package rs.ac.bg.etf.pp1.ast;

public class OptionalAssignStatement extends OptionalDesignatorStatement {

    private AssignExprSemi AssignExprSemi;

    public OptionalAssignStatement (AssignExprSemi AssignExprSemi) {
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
        buffer.append("OptionalAssignStatement(\n");

        if(AssignExprSemi!=null)
            buffer.append(AssignExprSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalAssignStatement]");
        return buffer.toString();
    }
}
