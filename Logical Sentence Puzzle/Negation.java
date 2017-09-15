
public class Negation extends LogicalSentence{

	LogicalSentence ls;
	
	public Negation(LogicalSentence a) {
		ls = a;
	}
	
	public boolean evaluate(TruthAssignment ta) {
		return !ls.evaluate(ta);
	}

}
