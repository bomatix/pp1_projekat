// generated with ast extension for cup
// version 0.8
// 30/4/2020 22:50:25


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private DesignatorExpr DesignatorExpr;
    private DesignatorPars DesignatorPars;

    public FactorDesignator (DesignatorExpr DesignatorExpr, DesignatorPars DesignatorPars) {
        this.DesignatorExpr=DesignatorExpr;
        if(DesignatorExpr!=null) DesignatorExpr.setParent(this);
        this.DesignatorPars=DesignatorPars;
        if(DesignatorPars!=null) DesignatorPars.setParent(this);
    }

    public DesignatorExpr getDesignatorExpr() {
        return DesignatorExpr;
    }

    public void setDesignatorExpr(DesignatorExpr DesignatorExpr) {
        this.DesignatorExpr=DesignatorExpr;
    }

    public DesignatorPars getDesignatorPars() {
        return DesignatorPars;
    }

    public void setDesignatorPars(DesignatorPars DesignatorPars) {
        this.DesignatorPars=DesignatorPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorExpr!=null) DesignatorExpr.accept(visitor);
        if(DesignatorPars!=null) DesignatorPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorExpr!=null) DesignatorExpr.traverseTopDown(visitor);
        if(DesignatorPars!=null) DesignatorPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorExpr!=null) DesignatorExpr.traverseBottomUp(visitor);
        if(DesignatorPars!=null) DesignatorPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(DesignatorExpr!=null)
            buffer.append(DesignatorExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorPars!=null)
            buffer.append(DesignatorPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
