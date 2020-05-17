// generated with ast extension for cup
// version 0.8
// 17/4/2020 13:25:46


package rs.ac.bg.etf.pp1.ast;

public class FormPars_ extends FormPars {

    private Type Type;
    private String I2;
    private EmptyBrackets EmptyBrackets;

    public FormPars_ (Type Type, String I2, EmptyBrackets EmptyBrackets) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.EmptyBrackets=EmptyBrackets;
        if(EmptyBrackets!=null) EmptyBrackets.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public EmptyBrackets getEmptyBrackets() {
        return EmptyBrackets;
    }

    public void setEmptyBrackets(EmptyBrackets EmptyBrackets) {
        this.EmptyBrackets=EmptyBrackets;
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
        buffer.append("FormPars_(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(EmptyBrackets!=null)
            buffer.append(EmptyBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPars_]");
        return buffer.toString();
    }
}
