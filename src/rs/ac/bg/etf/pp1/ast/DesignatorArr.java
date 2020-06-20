// generated with ast extension for cup
// version 0.8
// 20/5/2020 22:23:9


package rs.ac.bg.etf.pp1.ast;

public class DesignatorArr extends Designator {

    private LBracket_ LBracket_;
    private Expr Expr;
    private RBracket_ RBracket_;

    public DesignatorArr (LBracket_ LBracket_, Expr Expr, RBracket_ RBracket_) {
        this.LBracket_=LBracket_;
        if(LBracket_!=null) LBracket_.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.RBracket_=RBracket_;
        if(RBracket_!=null) RBracket_.setParent(this);
    }

    public LBracket_ getLBracket_() {
        return LBracket_;
    }

    public void setLBracket_(LBracket_ LBracket_) {
        this.LBracket_=LBracket_;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public RBracket_ getRBracket_() {
        return RBracket_;
    }

    public void setRBracket_(RBracket_ RBracket_) {
        this.RBracket_=RBracket_;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LBracket_!=null) LBracket_.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(RBracket_!=null) RBracket_.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LBracket_!=null) LBracket_.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(RBracket_!=null) RBracket_.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LBracket_!=null) LBracket_.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(RBracket_!=null) RBracket_.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorArr(\n");

        if(LBracket_!=null)
            buffer.append(LBracket_.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RBracket_!=null)
            buffer.append(RBracket_.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorArr]");
        return buffer.toString();
    }
}
