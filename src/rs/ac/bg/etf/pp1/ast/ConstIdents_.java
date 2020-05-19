// generated with ast extension for cup
// version 0.8
// 19/4/2020 15:17:14


package rs.ac.bg.etf.pp1.ast;

public class ConstIdents_ extends ConstIdents {

    private ConstIdents ConstIdents;
    private String I2;
    private ConstValue ConstValue;

    public ConstIdents_ (ConstIdents ConstIdents, String I2, ConstValue ConstValue) {
        this.ConstIdents=ConstIdents;
        if(ConstIdents!=null) ConstIdents.setParent(this);
        this.I2=I2;
        this.ConstValue=ConstValue;
        if(ConstValue!=null) ConstValue.setParent(this);
    }

    public ConstIdents getConstIdents() {
        return ConstIdents;
    }

    public void setConstIdents(ConstIdents ConstIdents) {
        this.ConstIdents=ConstIdents;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public ConstValue getConstValue() {
        return ConstValue;
    }

    public void setConstValue(ConstValue ConstValue) {
        this.ConstValue=ConstValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstIdents!=null) ConstIdents.accept(visitor);
        if(ConstValue!=null) ConstValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstIdents!=null) ConstIdents.traverseTopDown(visitor);
        if(ConstValue!=null) ConstValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstIdents!=null) ConstIdents.traverseBottomUp(visitor);
        if(ConstValue!=null) ConstValue.traverseBottomUp(visitor);
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

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(ConstValue!=null)
            buffer.append(ConstValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstIdents_]");
        return buffer.toString();
    }
}
