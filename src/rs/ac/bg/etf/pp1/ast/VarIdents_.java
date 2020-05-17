// generated with ast extension for cup
// version 0.8
// 17/4/2020 11:52:18


package rs.ac.bg.etf.pp1.ast;

public class VarIdents_ extends VarIdents {

    private VarIdents VarIdents;
    private String ident;
    private ArrayDecl ArrayDecl;

    public VarIdents_ (VarIdents VarIdents, String ident, ArrayDecl ArrayDecl) {
        this.VarIdents=VarIdents;
        if(VarIdents!=null) VarIdents.setParent(this);
        this.ident=ident;
        this.ArrayDecl=ArrayDecl;
        if(ArrayDecl!=null) ArrayDecl.setParent(this);
    }

    public VarIdents getVarIdents() {
        return VarIdents;
    }

    public void setVarIdents(VarIdents VarIdents) {
        this.VarIdents=VarIdents;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident=ident;
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
        if(VarIdents!=null) VarIdents.accept(visitor);
        if(ArrayDecl!=null) ArrayDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarIdents!=null) VarIdents.traverseTopDown(visitor);
        if(ArrayDecl!=null) ArrayDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarIdents!=null) VarIdents.traverseBottomUp(visitor);
        if(ArrayDecl!=null) ArrayDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarIdents_(\n");

        if(VarIdents!=null)
            buffer.append(VarIdents.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+ident);
        buffer.append("\n");

        if(ArrayDecl!=null)
            buffer.append(ArrayDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarIdents_]");
        return buffer.toString();
    }
}
