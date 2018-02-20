
public class Main {

	public static void main(String[] args) {
    	//test code, prints out 10 randoms or 0s
    	Randp rand = new Randp(6);
    	for(int i = 0; i < 10; i++) {
    		System.out.println(rand.nextInt());
    	}
    	
    	//test for BST
    	int[] testBST = {6, 4, 3, 5, 2, 8, 10};
    	BST root = new BST(testBST[0]);
    	root.printTree();
    	for(int i = 1; i < testBST.length; i++) {
    		root.insert(testBST[i]);
    		System.out.println(root.depth());
    		root.printTree();
    	}
    	root.printTree();
    	do10k();
    	do10k();
    	do10k();
    	do10k();
    	
    	MathSet testSet = new MathSet();
    	testSet.add(2);
    	testSet.add(3);
    	testSet.add(4);
    	testSet.add(5);
    	testSet.print();
    	MathSet testSet2 = new MathSet();
    	testSet2.add(6);
    	testSet2.add(3);
    	testSet2.add(1);
    	testSet2.add(9);
    	testSet2.print();
    	MathSet unionSet = testSet.union(testSet2);
    	unionSet.print();
    	MathSet intersectionSet = testSet.intersection(testSet2);
    	intersectionSet.print();
    }
	
	public static void do10k() {
		Randp tenk = new Randp(10000);
    	BST root10k = new BST(tenk.nextInt());
    	for(int i = 0; i < 9999; i++) {
    		root10k.insert(tenk.nextInt());
    	}
    	System.out.println("Depth of 10k tree = " + root10k.depth());
	}

}
