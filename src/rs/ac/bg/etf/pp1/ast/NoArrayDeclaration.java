// generated with ast extension for cup
// version 0.8
// 19/4/2020 21:50:39


package rs.ac.bg.etf.pp1.ast;

public class NoArrayDeclaration extends ArrayDecl {

    public NoArrayDeclaration () {
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
        buffer.append("NoArrayDeclaration(\n");

        buffer.append(tab);
        buffer.append(") [NoArrayDeclaration]");
        return buffer.toString();
    }
}
