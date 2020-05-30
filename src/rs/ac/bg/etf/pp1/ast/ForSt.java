// generated with ast extension for cup
// version 0.8
// 30/4/2020 15:47:30


package rs.ac.bg.etf.pp1.ast;

public class ForSt extends Statement {

    private OptionalDesignatorStatement OptionalDesignatorStatement;
    private OptionalCondition OptionalCondition;
    private OptionalDesignatorStatementThird OptionalDesignatorStatementThird;
    private OpenFor OpenFor;
    private Statement Statement;
    private CloseFor CloseFor;

    public ForSt (OptionalDesignatorStatement OptionalDesignatorStatement, OptionalCondition OptionalCondition, OptionalDesignatorStatementThird OptionalDesignatorStatementThird, OpenFor OpenFor, Statement Statement, CloseFor CloseFor) {
        this.OptionalDesignatorStatement=OptionalDesignatorStatement;
        if(OptionalDesignatorStatement!=null) OptionalDesignatorStatement.setParent(this);
        this.OptionalCondition=OptionalCondition;
        if(OptionalCondition!=null) OptionalCondition.setParent(this);
        this.OptionalDesignatorStatementThird=OptionalDesignatorStatementThird;
        if(OptionalDesignatorStatementThird!=null) OptionalDesignatorStatementThird.setParent(this);
        this.OpenFor=OpenFor;
        if(OpenFor!=null) OpenFor.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.CloseFor=CloseFor;
        if(CloseFor!=null) CloseFor.setParent(this);
    }

    public OptionalDesignatorStatement getOptionalDesignatorStatement() {
        return OptionalDesignatorStatement;
    }

    public void setOptionalDesignatorStatement(OptionalDesignatorStatement OptionalDesignatorStatement) {
        this.OptionalDesignatorStatement=OptionalDesignatorStatement;
    }

    public OptionalCondition getOptionalCondition() {
        return OptionalCondition;
    }

    public void setOptionalCondition(OptionalCondition OptionalCondition) {
        this.OptionalCondition=OptionalCondition;
    }

    public OptionalDesignatorStatementThird getOptionalDesignatorStatementThird() {
        return OptionalDesignatorStatementThird;
    }

    public void setOptionalDesignatorStatementThird(OptionalDesignatorStatementThird OptionalDesignatorStatementThird) {
        this.OptionalDesignatorStatementThird=OptionalDesignatorStatementThird;
    }

    public OpenFor getOpenFor() {
        return OpenFor;
    }

    public void setOpenFor(OpenFor OpenFor) {
        this.OpenFor=OpenFor;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public CloseFor getCloseFor() {
        return CloseFor;
    }

    public void setCloseFor(CloseFor CloseFor) {
        this.CloseFor=CloseFor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalDesignatorStatement!=null) OptionalDesignatorStatement.accept(visitor);
        if(OptionalCondition!=null) OptionalCondition.accept(visitor);
        if(OptionalDesignatorStatementThird!=null) OptionalDesignatorStatementThird.accept(visitor);
        if(OpenFor!=null) OpenFor.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(CloseFor!=null) CloseFor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalDesignatorStatement!=null) OptionalDesignatorStatement.traverseTopDown(visitor);
        if(OptionalCondition!=null) OptionalCondition.traverseTopDown(visitor);
        if(OptionalDesignatorStatementThird!=null) OptionalDesignatorStatementThird.traverseTopDown(visitor);
        if(OpenFor!=null) OpenFor.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(CloseFor!=null) CloseFor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalDesignatorStatement!=null) OptionalDesignatorStatement.traverseBottomUp(visitor);
        if(OptionalCondition!=null) OptionalCondition.traverseBottomUp(visitor);
        if(OptionalDesignatorStatementThird!=null) OptionalDesignatorStatementThird.traverseBottomUp(visitor);
        if(OpenFor!=null) OpenFor.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(CloseFor!=null) CloseFor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForSt(\n");

        if(OptionalDesignatorStatement!=null)
            buffer.append(OptionalDesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalCondition!=null)
            buffer.append(OptionalCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalDesignatorStatementThird!=null)
            buffer.append(OptionalDesignatorStatementThird.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OpenFor!=null)
            buffer.append(OpenFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CloseFor!=null)
            buffer.append(CloseFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForSt]");
        return buffer.toString();
    }
}
