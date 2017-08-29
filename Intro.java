
public class Intro {

	public static void main(String[] args) {
		boolean test = logic(true, true, false);
		System.out.println(test);
		String starTest = stars(9);
		System.out.println(starTest);
		for(int i = 0; i < 16; i++) {
			System.out.println("Value: " + i + " Coins: " + coins(i));
		}
	}
	
	public static int ret() {
		return 17;
	}
	
	public static boolean logic(boolean a, boolean b, boolean c) {
		return a && b && c;
	}
	
	public static String stars(int n) {
		String starString = "";
		for(int line = 0; line < n; line++) {
			for(int s = 0; s <= line; s++) {
				starString += "*";
			}
			starString += "\n";
		}
		return starString;
	}
	
	//1 cent: -1
	//2 cents: 1
	//3 cents: -1
	//4 cents: 2
	//5 cents: 1
	//6 cents: -1
	//7 cents: 2
	//8 cents: 4
	//9 cents: 3
	//10 cents; 2
	//12 cents: 3
	public static int coins(int n) {
		int numFive = n/5;
		int fiveRem = n%5;
		int numTwo = fiveRem/2;
		int twoRem = fiveRem%2;
		int allTwo = n/2;
		int allTwoRem = n%2;
		if(n == 0) {
			return -1;
		}
		if(twoRem > 0 && allTwoRem == 0) {
			return allTwo;
		}
		if(twoRem > 0) {
			return -1;
		}
		return numFive + numTwo;
	}

}
