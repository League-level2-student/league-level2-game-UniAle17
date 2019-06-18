import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;


public class GameMaker extends JPanel {

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	
	GameMaker(){
		
		titleFont = new Font("Chalkduster", Font.PLAIN, 48);
		
	}
	
	void updateMenuState(){
		
	}
	
	void updateGameState() {
		
	}
	
	void updateEndState(){
		
	}
	
	
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, MatildaShades.WIDTH, MatildaShades.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Matilda Shades", 115, 100);
		
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, MatildaShades.WIDTH, MatildaShades.HEIGHT);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, MatildaShades.WIDTH, MatildaShades.HEIGHT);
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){	
		
		if(currentState == MENU){
		    drawMenuState(g);
		}
		
		else if(currentState == GAME){
		    drawGameState(g);
		}
		
		else if(currentState == END){
		    drawEndState(g);
		}
		
	}

}
