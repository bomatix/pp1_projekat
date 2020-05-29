// generated with ast extension for cup
// version 0.8
// 28/4/2020 19:33:50


package rs.ac.bg.etf.pp1.ast;

public class FormParItem implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private Type Type;
    private String formParItem;
    private EmptyBrackets EmptyBrackets;

    public FormParItem (Type Type, String formParItem, EmptyBrackets EmptyBrackets) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formParItem=formParItem;
        this.EmptyBrackets=EmptyBrackets;
        if(EmptyBrackets!=null) EmptyBrackets.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getFormParItem() {
        return formParItem;
    }

    public void setFormParItem(String formParItem) {
        this.formParItem=formParItem;
    }

    public EmptyBrackets getEmptyBrackets() {
        return EmptyBrackets;
    }

    public void setEmptyBrackets(EmptyBrackets EmptyBrackets) {
        this.EmptyBrackets=EmptyBrackets;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(EmptyBrackets!=null) EmptyBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(EmptyBrackets!=null) EmptyBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(EmptyBrackets!=null) EmptyBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParItem(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+formParItem);
        buffer.append("\n");

        if(EmptyBrackets!=null)
            buffer.append(EmptyBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParItem]");
        return buffer.toString();
    }
}
