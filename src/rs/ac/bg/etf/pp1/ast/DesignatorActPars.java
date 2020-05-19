// generated with ast extension for cup
// version 0.8
// 19/4/2020 21:50:39


package rs.ac.bg.etf.pp1.ast;

public class DesignatorActPars extends DesignatorStatement {

    private ActParsExpression ActParsExpression;

    public DesignatorActPars (ActParsExpression ActParsExpression) {
        this.ActParsExpression=ActParsExpression;
        if(ActParsExpression!=null) ActParsExpression.setParent(this);
    }

    public ActParsExpression getActParsExpression() {
        return ActParsExpression;
    }

    public void setActParsExpression(ActParsExpression ActParsExpression) {
        this.ActParsExpression=ActParsExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsExpression!=null) ActParsExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsExpression!=null) ActParsExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsExpression!=null) ActParsExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorActPars(\n");

        if(ActParsExpression!=null)
            buffer.append(ActParsExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorActPars]");
        return buffer.toString();
    }
}
