import java.awt.Rectangle;

public class GameObjects {

	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 boolean isActive = true;
	 Rectangle collisionBox;
	 
	 GameObjects(int x, int y, int height, int width){
		 
		 collisionBox= new Rectangle(x,y, width, height);
		 
		 this.x=x;
		 this.y=y;
		 this.width=width;
		 this.height=height;
		 
	 }
	
	 void update(){
		 
		 collisionBox.setBounds(x, y, width, height);
		 
	 }
	
}
