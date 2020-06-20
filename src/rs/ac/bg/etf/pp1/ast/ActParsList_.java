// generated with ast extension for cup
// version 0.8
// 20/5/2020 22:23:9


package rs.ac.bg.etf.pp1.ast;

public class ActParsList_ extends ActParsList {

    private ActParsList ActParsList;
    private ActParsItem ActParsItem;

    public ActParsList_ (ActParsList ActParsList, ActParsItem ActParsItem) {
        this.ActParsList=ActParsList;
        if(ActParsList!=null) ActParsList.setParent(this);
        this.ActParsItem=ActParsItem;
        if(ActParsItem!=null) ActParsItem.setParent(this);
    }

    public ActParsList getActParsList() {
        return ActParsList;
    }

    public void setActParsList(ActParsList ActParsList) {
        this.ActParsList=ActParsList;
    }

    public ActParsItem getActParsItem() {
        return ActParsItem;
    }

    public void setActParsItem(ActParsItem ActParsItem) {
        this.ActParsItem=ActParsItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsList!=null) ActParsList.accept(visitor);
        if(ActParsItem!=null) ActParsItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsList!=null) ActParsList.traverseTopDown(visitor);
        if(ActParsItem!=null) ActParsItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsList!=null) ActParsList.traverseBottomUp(visitor);
        if(ActParsItem!=null) ActParsItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsList_(\n");

        if(ActParsList!=null)
            buffer.append(ActParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsItem!=null)
            buffer.append(ActParsItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsList_]");
        return buffer.toString();
    }
}
