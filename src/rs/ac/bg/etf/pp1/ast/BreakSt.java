// generated with ast extension for cup
// version 0.8
// 17/4/2020 13:25:46


package rs.ac.bg.etf.pp1.ast;

public class BreakSt extends Statement {

    public BreakSt () {
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
        buffer.append("BreakSt(\n");

        buffer.append(tab);
        buffer.append(") [BreakSt]");
        return buffer.toString();
    }
}
