// generated with ast extension for cup
// version 0.8
// 20/5/2020 22:23:9


package rs.ac.bg.etf.pp1.ast;

public class EmptyBrackets_ extends EmptyBrackets {

    private LBracket_ LBracket_;
    private RBracket_ RBracket_;

    public EmptyBrackets_ (LBracket_ LBracket_, RBracket_ RBracket_) {
        this.LBracket_=LBracket_;
        if(LBracket_!=null) LBracket_.setParent(this);
        this.RBracket_=RBracket_;
        if(RBracket_!=null) RBracket_.setParent(this);
    }

    public LBracket_ getLBracket_() {
        return LBracket_;
    }

    public void setLBracket_(LBracket_ LBracket_) {
        this.LBracket_=LBracket_;
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
        if(RBracket_!=null) RBracket_.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LBracket_!=null) LBracket_.traverseTopDown(visitor);
        if(RBracket_!=null) RBracket_.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LBracket_!=null) LBracket_.traverseBottomUp(visitor);
        if(RBracket_!=null) RBracket_.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EmptyBrackets_(\n");

        if(LBracket_!=null)
            buffer.append(LBracket_.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RBracket_!=null)
            buffer.append(RBracket_.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EmptyBrackets_]");
        return buffer.toString();
    }
}
