// generated with ast extension for cup
// version 0.8
// 29/4/2020 15:9:45


package rs.ac.bg.etf.pp1.ast;

public class MulopLeft_ extends MulOp {

    private MulopLeft MulopLeft;

    public MulopLeft_ (MulopLeft MulopLeft) {
        this.MulopLeft=MulopLeft;
        if(MulopLeft!=null) MulopLeft.setParent(this);
    }

    public MulopLeft getMulopLeft() {
        return MulopLeft;
    }

    public void setMulopLeft(MulopLeft MulopLeft) {
        this.MulopLeft=MulopLeft;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulopLeft!=null) MulopLeft.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulopLeft!=null) MulopLeft.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulopLeft!=null) MulopLeft.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopLeft_(\n");

        if(MulopLeft!=null)
            buffer.append(MulopLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopLeft_]");
        return buffer.toString();
    }
}
