// generated with ast extension for cup
// version 0.8
// 18/5/2020 22:55:47


package rs.ac.bg.etf.pp1.ast;

public class Subtract extends AddopLeft {

    public Subtract () {
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
        buffer.append("Subtract(\n");

        buffer.append(tab);
        buffer.append(") [Subtract]");
        return buffer.toString();
    }
}
