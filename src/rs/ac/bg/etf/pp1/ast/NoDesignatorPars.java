// generated with ast extension for cup
// version 0.8
// 19/4/2020 15:17:14


package rs.ac.bg.etf.pp1.ast;

public class NoDesignatorPars extends DesignatorPars {

    public NoDesignatorPars () {
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
        buffer.append("NoDesignatorPars(\n");

        buffer.append(tab);
        buffer.append(") [NoDesignatorPars]");
        return buffer.toString();
    }
}
