//MathSet implements the Set interface
//write union and intersection methods for it 

import java.util.*;

public class MathSet {
	private ArrayList<Integer> elements;
	
	public MathSet() {
		elements = new ArrayList<Integer>();
	}
	
	public void print() {
		System.out.println(elements.toString());
	}
	
	public void add(int d) {
		elements.add(d);
	}
	
	public boolean contains(int d) {
		return elements.contains(d);
	}
	
	public int size() {
		return elements.size();
	}
	
	public int get(int i) {
		return elements.get(i);
	}
	
	public MathSet union(MathSet b) {
		MathSet result = new MathSet();
		for(int i = 0; i < elements.size(); i++) {
			result.add(elements.get(i));
		}
		for(int i = 0; i < b.size(); i++) {
			if(!result.contains(b.get(i))) {
				result.add(b.get(i));
			}
		}
		return result;
	}
	//appears in both
	public MathSet intersection(MathSet b) {
		MathSet result = new MathSet();
		for(int i = 0; i < elements.size(); i++) {
			if(b.contains(elements.get(i))) {
				result.add(elements.get(i));
			}
		}
		return result;
	}
}

	