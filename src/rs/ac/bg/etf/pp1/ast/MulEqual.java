// generated with ast extension for cup
// version 0.8
// 30/4/2020 15:47:30


package rs.ac.bg.etf.pp1.ast;

public class MulEqual extends MulopRight {

    public MulEqual () {
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
        buffer.append("MulEqual(\n");

        buffer.append(tab);
        buffer.append(") [MulEqual]");
        return buffer.toString();
    }
}