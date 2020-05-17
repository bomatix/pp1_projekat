// generated with ast extension for cup
// version 0.8
// 17/4/2020 11:52:18


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDeclaration extends AbstractMethodDecl {

    private TypeVoid TypeVoid;
    private String varName;
    private FormParsList FormParsList;

    public AbstractMethodDeclaration (TypeVoid TypeVoid, String varName, FormParsList FormParsList) {
        this.TypeVoid=TypeVoid;
        if(TypeVoid!=null) TypeVoid.setParent(this);
        this.varName=varName;
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
    }

    public TypeVoid getTypeVoid() {
        return TypeVoid;
    }

    public void setTypeVoid(TypeVoid TypeVoid) {
        this.TypeVoid=TypeVoid;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeVoid!=null) TypeVoid.accept(visitor);
        if(FormParsList!=null) FormParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeVoid!=null) TypeVoid.traverseTopDown(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeVoid!=null) TypeVoid.traverseBottomUp(visitor);
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractMethodDeclaration(\n");

        if(TypeVoid!=null)
            buffer.append(TypeVoid.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDeclaration]");
        return buffer.toString();
    }
}
