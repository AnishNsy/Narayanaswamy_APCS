import java.awt.*;
import javax.swing.JFrame;

//this is the class for the opposing character
//color is blue
public class Mho extends Circles {

	public Mho(boolean lifeStatus, int startPosX, int startPosY) {
		super(lifeStatus, startPosX, startPosY);
	}
	
	//goes through the 2d array to place the mho
	//randomly on a game board while avoiding
	//other objects
	public void place() {
		for(int i = 0; i < 12 ; i++) {
			for(int b = 0; b < 12; b++) {
				if(locArray[i][b] == ) {
					this.drawCircle(g, cirX, cirY);
				}
			}
		}
	}
	
	//When mho touches wall, it dies
	public void contactFence() {
		if(this.posX == fence.getXPos && this.posY == fence.getYPos) {
			
		}
	}
	//when the mho the player does a move, mho
	public void mhoMove() {
		if(this.posX <  happy1.posX && this.posY < happy1.posY) {
			
		}
		else if(this.posX) {
			
		}
		else if(this.posX) {
			
		}
		else()
	}
	

}
