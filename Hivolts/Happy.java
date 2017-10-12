import java.awt.*;
import javax.swing.JFrame;
//class for the player character
public class Happy extends Circles{

	public Happy(boolean lifeStatus, int startPosX, int startPosY) {
		super(lifeStatus, startPosX, startPosY);
	}
	
	
	//goes through the 2d array to place the mho
	//randomly on a game board while avoiding
	//other objects
	public void place(Graphics g) {
		for(int i = 0; i < 12 ; i++) {
			for(int b = 0; b < 12; b++) {
				if(locArray[i] == posX && locArray[b] == posY) {
					this.drawCircle();
				}
			}
		}
	}
}
