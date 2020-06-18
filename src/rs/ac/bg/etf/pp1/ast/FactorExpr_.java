// generated with ast extension for cup
// version 0.8
// 18/5/2020 22:55:47


package rs.ac.bg.etf.pp1.ast;

public class FactorExpr_ extends Factor {

    private LParen_ LParen_;
    private Expr Expr;
    private RParen_ RParen_;

    public FactorExpr_ (LParen_ LParen_, Expr Expr, RParen_ RParen_) {
        this.LParen_=LParen_;
        if(LParen_!=null) LParen_.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.RParen_=RParen_;
        if(RParen_!=null) RParen_.setParent(this);
    }

    public LParen_ getLParen_() {
        return LParen_;
    }

    public void setLParen_(LParen_ LParen_) {
        this.LParen_=LParen_;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public RParen_ getRParen_() {
        return RParen_;
    }

    public void setRParen_(RParen_ RParen_) {
        this.RParen_=RParen_;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LParen_!=null) LParen_.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(RParen_!=null) RParen_.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LParen_!=null) LParen_.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(RParen_!=null) RParen_.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LParen_!=null) LParen_.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(RParen_!=null) RParen_.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorExpr_(\n");

        if(LParen_!=null)
            buffer.append(LParen_.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RParen_!=null)
            buffer.append(RParen_.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorExpr_]");
        return buffer.toString();
    }
}
