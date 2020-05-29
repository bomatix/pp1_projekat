// generated with ast extension for cup
// version 0.8
// 29/4/2020 14:17:57


package rs.ac.bg.etf.pp1.ast;

public class PrintSt extends Statement {

    private Expr Expr;
    private OptionalPrintParam OptionalPrintParam;

    public PrintSt (Expr Expr, OptionalPrintParam OptionalPrintParam) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.OptionalPrintParam=OptionalPrintParam;
        if(OptionalPrintParam!=null) OptionalPrintParam.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public OptionalPrintParam getOptionalPrintParam() {
        return OptionalPrintParam;
    }

    public void setOptionalPrintParam(OptionalPrintParam OptionalPrintParam) {
        this.OptionalPrintParam=OptionalPrintParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(OptionalPrintParam!=null) OptionalPrintParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(OptionalPrintParam!=null) OptionalPrintParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(OptionalPrintParam!=null) OptionalPrintParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintSt(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalPrintParam!=null)
            buffer.append(OptionalPrintParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintSt]");
        return buffer.toString();
    }
}
