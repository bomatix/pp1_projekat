// generated with ast extension for cup
// version 0.8
// 18/4/2020 23:39:35


package rs.ac.bg.etf.pp1.ast;

public class NoExpressionList extends ExprList {

    public NoExpressionList () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoExpressionList(\n");

        buffer.append(tab);
        buffer.append(") [NoExpressionList]");
        return buffer.toString();
    }
}
