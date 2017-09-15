
public class PropositionConstant {

	String pcName; 
	public PropositionConstant(String c) {
		pcName = c;	
	}
	
	public boolean isEqual(PropositionConstant a) {
		return pcName.equals(a.pcName);
	}

}
