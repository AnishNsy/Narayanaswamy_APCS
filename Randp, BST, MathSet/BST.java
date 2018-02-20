
public class BST {
	//dont use generic type, use type int
	public boolean leaf;
	private int datum;
	private BST left;
	private BST right;
	
	public BST(int d) {
		datum = d;
		left = null;
		right = null;
	}
	//accessors
	public int getDatum() {
		return datum;
	}
	public BST getLeft() {
		return left;
	}
	
	public BST getRight() {
		return right;
	}
	
	public void insert(int d) {
		if(datum == d) {
			//nothing to do
		}
		else if(datum > d) {
			if(left == null) {
				BST node = new BST(d);
				left = node;
			}
			else {
				left.insert(d);
			}
		}
		else {
			if(right == null) {
				BST node = new BST(d);
				right = node;
			}
			else {
				right.insert(d);
			}
		}
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public int depth() {
		int retVal = 1;
		if(isLeaf()) {
			return retVal;
		}
		int leftDepth = 0;
		int rightDepth = 0;
		if(left != null) {
			leftDepth = left.depth();
		}
		if(right != null) {
			rightDepth = right.depth();
		}

		return max(leftDepth, rightDepth) + 1;
	}
	
	public static int max(int a, int b) {
		if(a > b) {
			return a; 
		}
		else {
			return b;
		}
	}
	
	//utilities
	public void printTree() {
		System.out.print("( ");
		if(left != null) {
			left.printTree();
		}
		System.out.print(") ");
		System.out.print(datum + " ");
		System.out.print("( ");
		if(right != null) {
			right.printTree();
		}
		System.out.println(") ");
	}
	

}
