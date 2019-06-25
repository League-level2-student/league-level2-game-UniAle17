import java.awt.Color;
import java.awt.Graphics;

public class Matilda extends GameObjects{

	Matilda(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
      
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
}
