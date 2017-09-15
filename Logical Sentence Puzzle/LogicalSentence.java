
public class LogicalSentence {

	PropositionConstant pc;
	public LogicalSentence(PropositionConstant a) {
		pc = a;
	}
	
	public LogicalSentence() {
		
	}
	
	public boolean evaluate(TruthAssignment ta) {
		return ta.get(pc);
	}
	
	
}
