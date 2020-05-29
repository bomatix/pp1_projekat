// generated with ast extension for cup
// version 0.8
// 29/4/2020 14:17:57


package rs.ac.bg.etf.pp1.ast;

public class CloseFor implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public CloseFor () {
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("CloseFor(\n");

        buffer.append(tab);
        buffer.append(") [CloseFor]");
        return buffer.toString();
    }
}