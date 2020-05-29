// generated with ast extension for cup
// version 0.8
// 29/4/2020 15:9:45


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDeclaration extends AbstractMethodDecl {

    private TypeVoid TypeVoid;
    private String varName;
    private FormPars FormPars;

    public AbstractMethodDeclaration (TypeVoid TypeVoid, String varName, FormPars FormPars) {
        this.TypeVoid=TypeVoid;
        if(TypeVoid!=null) TypeVoid.setParent(this);
        this.varName=varName;
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
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

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeVoid!=null) TypeVoid.accept(visitor);
        if(FormPars!=null) FormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeVoid!=null) TypeVoid.traverseTopDown(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeVoid!=null) TypeVoid.traverseBottomUp(visitor);
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
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

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDeclaration]");
        return buffer.toString();
    }
}
