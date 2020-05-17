// generated with ast extension for cup
// version 0.8
// 17/4/2020 11:52:18


package rs.ac.bg.etf.pp1.ast;

public class FactorChar extends Factor {

    private char charconst;

    public FactorChar (char charconst) {
        this.charconst=charconst;
    }

    public char getCharconst() {
        return charconst;
    }

    public void setCharconst(char charconst) {
        this.charconst=charconst;
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
        buffer.append("FactorChar(\n");

        buffer.append(" "+tab+charconst);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorChar]");
        return buffer.toString();
    }
}
