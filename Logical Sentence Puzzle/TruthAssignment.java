
public class TruthAssignment {
	
	PropositionConstant[] pcArray;
	boolean[] vArray;
	int currIndex;
	
	public TruthAssignment() {
		pcArray = new PropositionConstant[20];
		vArray = new boolean[20];
		currIndex = 0;
	}
	
	public void put(PropositionConstant pc, boolean v) {
		pcArray[currIndex] = pc;
		vArray[currIndex] = v;
		currIndex++;
	}
	
	public boolean get(PropositionConstant pc) {
		for(int i = 0; i < currIndex; i++) {
			if(pc.equals(pcArray[i])) {
				return vArray[i];
			}
		}
		System.out.println("Propositional Constant " + pc.pcName + " not found.");
		return false;
	}
	
	public void set(PropositionConstant pc, boolean v) {
		for(int i = 0; i < currIndex; i++) {
			if(pc.equals(pcArray[i])) {
				vArray[i] =  v;
			}
		}
	}

}
