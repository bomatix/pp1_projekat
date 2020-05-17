package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor{
	
	public void visit(Program program) {
		Logger log = Logger.getLogger(getClass());
		
		log.info("printed");
	}

}
