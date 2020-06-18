// generated with ast extension for cup
// version 0.8
// 18/5/2020 22:55:47


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDeclaration extends AbstractClassDecl {

    private String I1;
    private Extends Extends;
    private VarDeclList VarDeclList;
    private AllMethodsDeclList AllMethodsDeclList;

    public AbstractClassDeclaration (String I1, Extends Extends, VarDeclList VarDeclList, AllMethodsDeclList AllMethodsDeclList) {
        this.I1=I1;
        this.Extends=Extends;
        if(Extends!=null) Extends.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.AllMethodsDeclList=AllMethodsDeclList;
        if(AllMethodsDeclList!=null) AllMethodsDeclList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        buffer.append("AbstractClassDeclaration(\n");

        buffer.append(" "+tab+I1);
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
        buffer.append(") [AbstractClassDeclaration]");
        return buffer.toString();
    }
}
