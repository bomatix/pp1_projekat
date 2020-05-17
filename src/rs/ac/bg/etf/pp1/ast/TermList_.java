// generated with ast extension for cup
// version 0.8
// 17/4/2020 13:25:46


package rs.ac.bg.etf.pp1.ast;

public class TermList_ extends TermList {

    private TermList TermList;
    private Factor Factor;
    private MulOp MulOp;

    public TermList_ (TermList TermList, Factor Factor, MulOp MulOp) {
        this.TermList=TermList;
        if(TermList!=null) TermList.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.MulOp=MulOp;
        if(MulOp!=null) MulOp.setParent(this);
    }

    public TermList getTermList() {
        return TermList;
    }

    public void setTermList(TermList TermList) {
        this.TermList=TermList;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public MulOp getMulOp() {
        return MulOp;
    }

    public void setMulOp(MulOp MulOp) {
        this.MulOp=MulOp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermList!=null) TermList.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
        if(MulOp!=null) MulOp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermList!=null) TermList.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(MulOp!=null) MulOp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermList!=null) TermList.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(MulOp!=null) MulOp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermList_(\n");

        if(TermList!=null)
            buffer.append(TermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MulOp!=null)
            buffer.append(MulOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermList_]");
        return buffer.toString();
    }
}
