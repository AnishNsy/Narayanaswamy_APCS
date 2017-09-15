
public class Conjunction extends LogicalSentence{

	LogicalSentence OperLeft, OperRight;
	
	public Conjunction(LogicalSentence a, LogicalSentence b) {
		OperLeft = a;
		OperRight = b;
	}
	
	public boolean evaluate(TruthAssignment ta) {
		return OperLeft.evaluate(ta) & OperRight.evaluate(ta);
	}
	
	

	
}
