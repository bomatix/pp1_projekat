// generated with ast extension for cup
// version 0.8
// 17/4/2020 11:52:18


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDelcaration extends AbstractClassDecl {

    private String ident;
    private Extends Extends;
    private VarDeclList VarDeclList;
    private AllMethodsDeclList AllMethodsDeclList;

    public AbstractClassDelcaration (String ident, Extends Extends, VarDeclList VarDeclList, AllMethodsDeclList AllMethodsDeclList) {
        this.ident=ident;
        this.Extends=Extends;
        if(Extends!=null) Extends.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.AllMethodsDeclList=AllMethodsDeclList;
        if(AllMethodsDeclList!=null) AllMethodsDeclList.setParent(this);
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident=ident;
    }

    public Extends getExtends() {
        return Extends;
    }

    public void setExtends(Extends Extends) {
        this.Extends=Extends;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public AllMethodsDeclList getAllMethodsDeclList() {
        return AllMethodsDeclList;
    }

    public void setAllMethodsDeclList(AllMethodsDeclList AllMethodsDeclList) {
        this.AllMethodsDeclList=AllMethodsDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Extends!=null) Extends.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(AllMethodsDeclList!=null) AllMethodsDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Extends!=null) Extends.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(AllMethodsDeclList!=null) AllMethodsDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Extends!=null) Extends.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(AllMethodsDeclList!=null) AllMethodsDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDelcaration(\n");

        buffer.append(" "+tab+ident);
        buffer.append("\n");

        if(Extends!=null)
            buffer.append(Extends.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AllMethodsDeclList!=null)
            buffer.append(AllMethodsDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDelcaration]");
        return buffer.toString();
    }
}
