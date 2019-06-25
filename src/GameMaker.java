import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GameMaker extends JPanel implements ActionListener, KeyListener{

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font messageFont;
	Timer frameDraw;
	Matilda matilda;
	
	GameMaker(){
		
		matilda = new Matilda(250, 700, 50, 50);
		
		titleFont = new Font("Chalkduster", Font.PLAIN, 56);
		messageFont = new Font("Courier New", Font.PLAIN, 30  );
		frameDraw= new Timer(1000/60, this);
		frameDraw.start();
	
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
		g.drawString("Matilda Shades", 200, 100);
		
		g.setFont(messageFont);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to start", 250, 350);
		
		g.setFont(messageFont);
		g.setColor(Color.WHITE);
		g.drawString("Press SPACE for instructions", 180, 600);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, MatildaShades.WIDTH, MatildaShades.HEIGHT);
		
		matilda.draw(g);
       
		
		
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, MatildaShades.WIDTH, MatildaShades.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over for Matilda", 70, 100);
		
		g.setFont(messageFont);
		g.setColor(Color.BLACK);
		g.drawString("You caught", 350, 370);
		
		g.setFont(messageFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 250, 600);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}
		
		else if(currentState == GAME){
		    updateGameState();
		}
		
		else if(currentState == END){
		    updateEndState();
		}

		System.out.println("action");
		repaint();
		//
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		   
			if (currentState == END) {
		        currentState = MENU;
		    } 
			
			else {
		        currentState++;
		    }
		}   
		
		if(currentState == GAME) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
				
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			
		}
		
	}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
