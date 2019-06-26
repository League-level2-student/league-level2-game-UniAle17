import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Sunglasses extends GameObjects{

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	
	Sunglasses(int x, int y, int height, int width) {
		super(x, y, height, width);
		
		speed=1;
		
		if (needImage) {
		    loadImage ("glasses.png");
		}
		
		// TODO Auto-generated constructor stub
	}

	void update() {
		
		y+=speed;
		
	}

	void draw(Graphics g){
		
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);	
		
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
        
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
}
