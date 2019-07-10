import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Matilda extends GameObjects{

	boolean right= false;
	boolean left= false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Matilda(int x, int y, int height, int width) {
		super(x, y, height, width);
		
		if (needImage) {
		    loadImage ("matilda.jpg");
		}
		
		speed=20;
		
		
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
      
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        
        if (gotImage) {
        	g.drawImage(image, x, y-100, width+200, height+200, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
        
        
	}
	
	void update(){
		super.update();
			
		collisionBox.setBounds(x+110, y-10, width+50, height+70);
		
			if(right==true) {
				x+=speed;
			}
			
			if(left==true) {
				x-=speed;
			}
			
		}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        needImage = false;
	    }
	}
	
}
