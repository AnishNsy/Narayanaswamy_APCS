import javax.swing.JOptionPane;

public class Main {
	//the set up for the game board 
	public static void main(String[] args){
		String[][] grid = new String[12][12];
		testSetUp(grid);
		setBoard(grid);
		print(grid);
		HivoltsFrame gameWindow = new HivoltsFrame(1400);
		gameWindow.setDefaultCloseOperation(gameWindow.EXIT_ON_CLOSE);
		gameWindow.setVisible(true);
	}
	
	private static void testSetUp(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				grid[i][j] = " ";
			}
		}
	}

	private static void print(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println(" ");
		}
		
	}

	private static void setBoard(String[][] grid){
		fenceSetUp(grid);
		mhoSetUp(grid);
		happySetUp(grid);
	}

	//randomly sets up the "happy"
	private static void happySetUp(String[][] grid) {
		int position1 = (int)(Math.random()*9.0);
		int position2 = (int)(Math.random()*9.0);
		if(grid[position1+1][position2+1].equals(" ")){
			grid[position1+1][position2+1] = "+";
		}	
	}

	//randomly sets the mhos on the board
	private static void mhoSetUp(String[][] grid) {
		String[] mhoNames = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c"};
		for(int i = 0; i < mhoNames.length; i++){
			int position1 = (int)(Math.random()*9.0);
			int position2 = (int)(Math.random()*9.0);
			if(grid[position1+1][position2+1].equals(" ")){
				grid[position1+1][position2+1] = mhoNames[i];
			}
			else {
				i -= 1;
			}
		}
	}

	private static void fenceSetUp(String[][] grid) {
		fencePerimeterSetUp(grid);
		fenceRandomsSetUp(grid);
	}

	private static void fenceRandomsSetUp(String[][] grid) {
		for(int i = 0; i < 20; i++){
			int position1 = (int)(Math.random()*9.0);
			int position2 = (int)(Math.random()*9.0);
			if(grid[position1+1][position2+1].equals(" ")){
				grid[position1+1][position2+1] = "F";
			}
			else {
				i -= 1;
			}
		}
	}

	private static void fencePerimeterSetUp(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				if(j == 0 || j == grid[i].length-1 || i == 0 || i == grid.length-1){
					grid[i][j] = "F";
				}
			}
		}
		
	}
	
	//key movements qweasdzxc for grid bases movement, j should move the player to a 
	//random spot on the board, but not land on an electric fence. Player either
	//lands on a mho or an open space 
	
	
	
	
}