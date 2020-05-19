// generated with ast extension for cup
// version 0.8
// 19/4/2020 21:50:39


package rs.ac.bg.etf.pp1.ast;

public class VarIdent_ extends VarIdent {

    private String I1;
    private ArrayDecl ArrayDecl;

    public VarIdent_ (String I1, ArrayDecl ArrayDecl) {
        this.I1=I1;
        this.ArrayDecl=ArrayDecl;
        if(ArrayDecl!=null) ArrayDecl.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ArrayDecl getArrayDecl() {
        return ArrayDecl;
    }

    public void setArrayDecl(ArrayDecl ArrayDecl) {
        this.ArrayDecl=ArrayDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayDecl!=null) ArrayDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayDecl!=null) ArrayDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayDecl!=null) ArrayDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarIdent_(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ArrayDecl!=null)
            buffer.append(ArrayDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarIdent_]");
        return buffer.toString();
    }
}
