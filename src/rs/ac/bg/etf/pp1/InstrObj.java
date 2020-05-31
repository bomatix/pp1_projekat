package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Obj;

public class InstrObj {
	public int instr;
	public Obj obj;
	
	public static int load = -1;
	
	public InstrObj(int instr) {
		this.instr = instr;
	}
	
	public InstrObj(Obj obj) {
			this.obj = obj;
		}
	
	public InstrObj(int instr, Obj obj) {
		this.instr = instr;
		this.obj = obj;
	}
}
