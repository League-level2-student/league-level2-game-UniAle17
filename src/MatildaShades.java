import javax.swing.JFrame;

public class MatildaShades {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;
	
	JFrame frame;
	GameMaker gm;
	
	public static void main(String[] args) {
	
		MatildaShades ms = new MatildaShades();
		ms.setup();
		
		
	}
	
	MatildaShades(){
	
		frame = new JFrame(); 
		gm = new GameMaker();
		
	}
	
	void setup() {
		
		frame.add(gm);
		
		frame.setSize(WIDTH, HEIGHT);
	
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
