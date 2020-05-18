// generated with ast extension for cup
// version 0.8
// 18/4/2020 23:39:35


package rs.ac.bg.etf.pp1.ast;

public class AllMethodsDeclarationList extends AllMethodsDeclList {

    private AllMethodsDeclList AllMethodsDeclList;
    private AllMethodDecl AllMethodDecl;

    public AllMethodsDeclarationList (AllMethodsDeclList AllMethodsDeclList, AllMethodDecl AllMethodDecl) {
        this.AllMethodsDeclList=AllMethodsDeclList;
        if(AllMethodsDeclList!=null) AllMethodsDeclList.setParent(this);
        this.AllMethodDecl=AllMethodDecl;
        if(AllMethodDecl!=null) AllMethodDecl.setParent(this);
    }

    public AllMethodsDeclList getAllMethodsDeclList() {
        return AllMethodsDeclList;
    }

    public void setAllMethodsDeclList(AllMethodsDeclList AllMethodsDeclList) {
        this.AllMethodsDeclList=AllMethodsDeclList;
    }

    public AllMethodDecl getAllMethodDecl() {
        return AllMethodDecl;
    }

    public void setAllMethodDecl(AllMethodDecl AllMethodDecl) {
        this.AllMethodDecl=AllMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AllMethodsDeclList!=null) AllMethodsDeclList.accept(visitor);
        if(AllMethodDecl!=null) AllMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AllMethodsDeclList!=null) AllMethodsDeclList.traverseTopDown(visitor);
        if(AllMethodDecl!=null) AllMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AllMethodsDeclList!=null) AllMethodsDeclList.traverseBottomUp(visitor);
        if(AllMethodDecl!=null) AllMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllMethodsDeclarationList(\n");

        if(AllMethodsDeclList!=null)
            buffer.append(AllMethodsDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AllMethodDecl!=null)
            buffer.append(AllMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllMethodsDeclarationList]");
        return buffer.toString();
    }
}
