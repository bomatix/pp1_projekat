// generated with ast extension for cup
// version 0.8
// 29/4/2020 15:9:45


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDeclaration_ extends AllMethodDecl {

    private AbstractMethodDecl AbstractMethodDecl;

    public AbstractMethodDeclaration_ (AbstractMethodDecl AbstractMethodDecl) {
        this.AbstractMethodDecl=AbstractMethodDecl;
        if(AbstractMethodDecl!=null) AbstractMethodDecl.setParent(this);
    }

    public AbstractMethodDecl getAbstractMethodDecl() {
        return AbstractMethodDecl;
    }

    public void setAbstractMethodDecl(AbstractMethodDecl AbstractMethodDecl) {
        this.AbstractMethodDecl=AbstractMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractMethodDecl!=null) AbstractMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractMethodDecl!=null) AbstractMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractMethodDecl!=null) AbstractMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractMethodDeclaration_(\n");

        if(AbstractMethodDecl!=null)
            buffer.append(AbstractMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDeclaration_]");
        return buffer.toString();
    }
}
