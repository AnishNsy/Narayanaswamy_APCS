import java.awt.*;
import javax.swing.JFrame;

public class Circles {

	boolean lifeStatus;
	int posX;
	int posY;
	
	//Parent class for Happy, Mho
	
	public Circles(boolean lifeStatus, int startPosX, int startPosY) {
		this.lifeStatus = lifeStatus;
		this.posX = startPosX;
		this.posY = startPosY;	
	}
	
	public void setLife(boolean newStatus) {
		 lifeStatus = newStatus;
	}
	public void setPos(int newPosX, int newPosY) {
		posX = newPosX;
		posY = newPosY;
	}
	
	
	public void drawCircle(Graphics g, int posX, int posY) {
		g.setColor(Color.YELLOW);
		g.drawOval(posX, posY, 100, 100);
		
	}


	
	

}
