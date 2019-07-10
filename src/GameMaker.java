import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameMaker extends JPanel implements ActionListener, KeyListener {

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;

	Font titleFont;
	Font messageFont;

	Timer frameDraw;
	public static Timer sunglassesSpawn;

	Matilda matilda;

	ObjectOrganizer oo;

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = true;

	GameMaker() {

		if (needImage) {
			loadImage("grass.jpg");
		}

		matilda = new Matilda(250, 700, 50, 50);
		oo = new ObjectOrganizer(matilda);
		titleFont = new Font("Chalkduster", Font.PLAIN, 56);
		messageFont = new Font("Courier New", Font.PLAIN, 30);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

	}

	void startGame() {

		sunglassesSpawn = new Timer(3000, oo);
		sunglassesSpawn.start();
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

	void updateMenuState() {

	}

	void updateGameState() {
		matilda.update();
		oo.update();

		if (matilda.isActive == false) {

			currentState = END;

		}
		if(oo.end==true) {
			currentState = END;
		}

	}

	void updateEndState() {

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

		if (gotImage) {
			g.drawImage(image, 0, 0, MatildaShades.WIDTH, MatildaShades.HEIGHT, null);
		}

		else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, MatildaShades.WIDTH, MatildaShades.HEIGHT);
		}

		oo.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, MatildaShades.WIDTH, MatildaShades.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over for Matilda", 70, 100);

		g.setFont(messageFont);
		g.setColor(Color.BLACK);
		g.drawString("You caught "+oo.score+" sunglasses", 250, 370);

		g.setFont(messageFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 250, 600);

	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU) {
			drawMenuState(g);
		}

		else if (currentState == GAME) {
			drawGameState(g);
		}

		else if (currentState == END) {
			drawEndState(g);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		}

		else if (currentState == GAME) {
			updateGameState();
		}

		else if (currentState == END) {
			updateEndState();
		}

		
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

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (currentState == END) {
				currentState = MENU;
				matilda = new Matilda(250, 700, 50, 50);
				oo = new ObjectOrganizer(matilda);
				startGame();
			}

			else {
				currentState++;
			}
			if (currentState == GAME) {

				startGame();

			}
			
	 
			
		}

		if (currentState == END) {
			sunglassesSpawn.stop();
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			matilda.left = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			matilda.right = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			matilda.left = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			matilda.right = false;
		}
	}

}
