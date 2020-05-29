// generated with ast extension for cup
// version 0.8
// 28/4/2020 19:33:50


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDeclaration_ extends Decl {

    private AbstractClassDecl AbstractClassDecl;

    public AbstractClassDeclaration_ (AbstractClassDecl AbstractClassDecl) {
        this.AbstractClassDecl=AbstractClassDecl;
        if(AbstractClassDecl!=null) AbstractClassDecl.setParent(this);
    }

    public AbstractClassDecl getAbstractClassDecl() {
        return AbstractClassDecl;
    }

    public void setAbstractClassDecl(AbstractClassDecl AbstractClassDecl) {
        this.AbstractClassDecl=AbstractClassDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractClassDecl!=null) AbstractClassDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassDecl!=null) AbstractClassDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassDecl!=null) AbstractClassDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDeclaration_(\n");

        if(AbstractClassDecl!=null)
            buffer.append(AbstractClassDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDeclaration_]");
        return buffer.toString();
    }
}
