// generated with ast extension for cup
// version 0.8
// 29/4/2020 14:17:57


package rs.ac.bg.etf.pp1.ast;

public class FormParsList_ extends FormParsList {

    private FormParsList FormParsList;
    private FormParItem FormParItem;

    public FormParsList_ (FormParsList FormParsList, FormParItem FormParItem) {
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
        this.FormParItem=FormParItem;
        if(FormParItem!=null) FormParItem.setParent(this);
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
    }

    public FormParItem getFormParItem() {
        return FormParItem;
    }

    public void setFormParItem(FormParItem FormParItem) {
        this.FormParItem=FormParItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsList!=null) FormParsList.accept(visitor);
        if(FormParItem!=null) FormParItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
        if(FormParItem!=null) FormParItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        if(FormParItem!=null) FormParItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsList_(\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParItem!=null)
            buffer.append(FormParItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsList_]");
        return buffer.toString();
    }
}
