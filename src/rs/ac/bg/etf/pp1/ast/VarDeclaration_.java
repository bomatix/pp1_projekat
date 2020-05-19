// generated with ast extension for cup
// version 0.8
// 19/4/2020 21:50:39


package rs.ac.bg.etf.pp1.ast;

public class VarDeclaration_ extends VarDecl {

    private Type Type;
    private VarIdentList VarIdentList;
    private VarIdent VarIdent;

    public VarDeclaration_ (Type Type, VarIdentList VarIdentList, VarIdent VarIdent) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarIdentList=VarIdentList;
        if(VarIdentList!=null) VarIdentList.setParent(this);
        this.VarIdent=VarIdent;
        if(VarIdent!=null) VarIdent.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarIdentList getVarIdentList() {
        return VarIdentList;
    }

    public void setVarIdentList(VarIdentList VarIdentList) {
        this.VarIdentList=VarIdentList;
    }

    public VarIdent getVarIdent() {
        return VarIdent;
    }

    public void setVarIdent(VarIdent VarIdent) {
        this.VarIdent=VarIdent;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarIdentList!=null) VarIdentList.accept(visitor);
        if(VarIdent!=null) VarIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarIdentList!=null) VarIdentList.traverseTopDown(visitor);
        if(VarIdent!=null) VarIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarIdentList!=null) VarIdentList.traverseBottomUp(visitor);
        if(VarIdent!=null) VarIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclaration_(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarIdentList!=null)
            buffer.append(VarIdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarIdent!=null)
            buffer.append(VarIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclaration_]");
        return buffer.toString();
    }
}
