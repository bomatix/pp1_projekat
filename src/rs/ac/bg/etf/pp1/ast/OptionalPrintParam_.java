// generated with ast extension for cup
// version 0.8
// 17/4/2020 11:52:18


package rs.ac.bg.etf.pp1.ast;

public class OptionalPrintParam_ extends OptionalPrintParam {

    private Integer numconst;

    public OptionalPrintParam_ (Integer numconst) {
        this.numconst=numconst;
    }

    public Integer getNumconst() {
        return numconst;
    }

    public void setNumconst(Integer numconst) {
        this.numconst=numconst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalPrintParam_(\n");

        buffer.append(" "+tab+numconst);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalPrintParam_]");
        return buffer.toString();
    }
}
