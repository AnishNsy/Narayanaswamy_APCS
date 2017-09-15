import javax.swing.JOptionPane;

public class TestFlagMain {

	public static void main(String[] args) {
		int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the width of the flag: "));
		Rectangle test = new Rectangle(size);
		test.setDefaultCloseOperation(test.EXIT_ON_CLOSE);
		test.setVisible(true);
		
	}
}
	
