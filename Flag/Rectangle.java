import java.awt.*;
import javax.swing.JFrame;

// Draw a rectangle
public class Rectangle extends JFrame {
	 
	int extraX;
	int extraY;
	final int originY = 75;
	final int originX = 0;
	private final Color BISQUE = new Color(0xcdb79e);
	int fWidth;
	int rectX;
	int rectY;
	int blueX;
	int blueY;
	int topStarX;
	int topStarY;
	int starD;
	
	public Rectangle (int width) {
		init(width);
	}
	
	//Sets the size of the window
	
	public void init(int width) {
		fWidth = width;
		rectX = (int)(fWidth*1.9);
		rectY = fWidth;
		blueX = (int)(fWidth*0.76);
		blueY = (int)(fWidth*0.5385);
		topStarX = (int)(fWidth*.063);
		topStarY = (int)(fWidth*.054);
		starD= (int)(fWidth*.0616);
		setSize(rectX,rectY);
//		Dimension actualSize = getContentPane().getSize();
//		extraX = rectX - actualSize.width;
//		extraY = rectY - actualSize.height;
//		setSize(rectX + extraX, rectY + extraY);
		setBackground(Color.WHITE);
		repaint();
	}
	

	public void paint(Graphics g) {
		
				
		g.setColor(Color.WHITE);
		g.drawRect(originX, originY, rectX, rectY);
		
		
		//there are 13 stripes from top to bottom,
		//starting with red
		//fifty stars: 6-5 alternating 9 times
		//100 is the depth of the bar on top of the window
		
		for(int i = 0; i <= 12; i++) {
			if(i%2 == 0) {
				g.setColor(Color.RED);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.fillRect(originX, originY + i*((rectY)/13), rectX, (rectY)/13);
		}
		
		//Blue Field in the top left
		g.setColor(Color.BLUE);
		g.fillRect(originX, originY, blueX, blueY);
		
		//star(g, topStarX, topStarY);
		int rowY = topStarY;
		for(int i = 0; i < 5; i++) {
			rowStarOne(g, rowY + i*2*topStarY);
		}
		rowY = 2*topStarY;
		for(int i = 0; i < 4; i++) {
			rowStarTwo(g, rowY + i*2*topStarY);
		}
				
	}
	
	public void star(Graphics g, int currStarX, int currStarY) {
		//r*cos(t)+ h = x
				//r*cos(t)+ k = y
				//18 for first point
				//big*.382 is the radius of the inner circle
				
				int[] starX = new int[10];
				int[] starY = new int[10];
				int angle = 54;
				int angleStep = 36;
				for(int i = 0; i < 10; i++) { 
					double currAng = (angle + i*angleStep)*(Math.PI/180.0);
					double currRad;
					if(i%2 == 0) {
						currRad = starD/2;
					}
					else {
						currRad = 0.382*(starD/2);
					}
					starX[i] = (int)((currRad)*(Math.cos(currAng)) + currStarX + originX);
					starY[i] = (int)((currRad)*(Math.sin(currAng)) + currStarY+ originY);
			
				}
				g.setColor(Color.WHITE);
				g.fillPolygon(starX, starY, 10);		
	}
	
	public void rowStarOne(Graphics g, int yRow) {
		int currX = topStarX;
		for(int i = 0; i < 6; i++) {
			star(g, (currX + i*2*topStarX), yRow);
		}
	}
	
	public void rowStarTwo(Graphics g, int yRow) {
		int currX = topStarX + topStarY;
		for(int i = 0; i < 5; i++) {
			star(g, (currX + i*2*topStarX), yRow);
		}
	}
}
	
		
	

	

