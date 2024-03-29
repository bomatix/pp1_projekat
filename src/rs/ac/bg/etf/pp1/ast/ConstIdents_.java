// generated with ast extension for cup
// version 0.8
// 30/4/2020 22:50:25


package rs.ac.bg.etf.pp1.ast;

public class ConstIdents_ extends ConstIdents {

    private ConstIdents ConstIdents;
    private ConstIdent ConstIdent;

    public ConstIdents_ (ConstIdents ConstIdents, ConstIdent ConstIdent) {
        this.ConstIdents=ConstIdents;
        if(ConstIdents!=null) ConstIdents.setParent(this);
        this.ConstIdent=ConstIdent;
        if(ConstIdent!=null) ConstIdent.setParent(this);
    }

    public ConstIdents getConstIdents() {
        return ConstIdents;
    }

    public void setConstIdents(ConstIdents ConstIdents) {
        this.ConstIdents=ConstIdents;
    }

    public ConstIdent getConstIdent() {
        return ConstIdent;
    }

    public void setConstIdent(ConstIdent ConstIdent) {
        this.ConstIdent=ConstIdent;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstIdents!=null) ConstIdents.accept(visitor);
        if(ConstIdent!=null) ConstIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstIdents!=null) ConstIdents.traverseTopDown(visitor);
        if(ConstIdent!=null) ConstIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstIdents!=null) ConstIdents.traverseBottomUp(visitor);
        if(ConstIdent!=null) ConstIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstIdents_(\n");

        if(ConstIdents!=null)
            buffer.append(ConstIdents.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstIdent!=null)
            buffer.append(ConstIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstIdents_]");
        return buffer.toString();
    }
}
