// generated with ast extension for cup
// version 0.8
// 30/4/2020 22:50:25


package rs.ac.bg.etf.pp1.ast;

public class NoOptionalDesignatorStatementThird extends OptionalDesignatorStatementThird {

    public NoOptionalDesignatorStatementThird () {
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
        buffer.append("NoOptionalDesignatorStatementThird(\n");

        buffer.append(tab);
        buffer.append(") [NoOptionalDesignatorStatementThird]");
        return buffer.toString();
    }
}
