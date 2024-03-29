package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.ac.bg.etf.pp1.ast.*;

public class MJTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(MJTest.class);
		
		Reader br = null;
		try {
			File sourceCode = new File("test/program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
			Symbol s = p.parse();  //pocetak parsiranja
//			Symbol s = p.debug_parse();  //pocetak parsiranja
	       
//			log.info(s.value);
	        Program prog = (Program)(s.value); 
	        
	        Tab.init();
			// ispis sintaksnog stabla
			log.info("===================================");

			// ispis prepoznatih programskih konstrukcija
			SemanticAnalyzer sa = new SemanticAnalyzer();
			prog.traverseBottomUp(sa); 
			
			Tab.dump();
	      
			if(!p.errorDetected && !sa.isErrorDetected()) {
				File objFile = new File("test/program.obj");
				if(objFile.exists()) objFile.delete();
				
				CodeGenerator codeGenerator = new CodeGenerator();
				prog.traverseBottomUp(codeGenerator);
				// dodaj counter za metode
				Code.dataSize = sa.getVarCount();
				Code.mainPc = codeGenerator.getMainPc();
				Code.write(new FileOutputStream(objFile));
				log.info("Parsiranje uspesno zavrseno!");
			}
			else {
				log.error("Parsiranje NIJE uspesno zavrseno!");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}
	}
	
}
