import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectOrganizer implements ActionListener {

	Matilda mtld;
	ArrayList <Sunglasses>	sunglassesObjects = new ArrayList<Sunglasses>();
	Random ran = new Random();
	int score=0;
	boolean end = false;
	int time=0;
	
	ObjectOrganizer(Matilda mat){
		
		mtld=mat;		
		
	}
	
	void checkCollision() {

		for (int i = 0; i < sunglassesObjects.size(); i++) {
			
			Sunglasses sunglasses = sunglassesObjects.get(i);
			//sunglasses.update();
			
			if(mtld.collisionBox.intersects(sunglasses.collisionBox)){
		
				
				sunglasses.isActive=false;
				score=score+1;
				
			}
			}
		
	}
	
	void addSunglasses(){
		
		sunglassesObjects.add(new Sunglasses(ran.nextInt(MatildaShades.WIDTH), 0, 50, 50));
		
	}
	
	void update(){
		
		for (int i = 0; i < sunglassesObjects.size(); i++) {
			
			Sunglasses sunglassess = sunglassesObjects.get(i);
			sunglassess.update();
			
			if(sunglassess.y>MatildaShades.HEIGHT) {
				
				sunglassess.isActive=false;
				
				end=true;
				
			}
			
		}
		
		checkCollision();
		
		purgeObjects();
		
	}
	
	
		void draw(Graphics g) {
			
			mtld.draw(g);
			
			for (int i = 0; i < sunglassesObjects.size(); i++) {
				   
				Sunglasses sunglassess = sunglassesObjects.get(i);
				sunglassess.draw(g);

				
			}
			
			
			
		}
		
		
		void purgeObjects() {
			
			for (int i = 0; i < sunglassesObjects.size(); i++) {
				
				Sunglasses sunglassess = sunglassesObjects.get(i);
				
					if(sunglassess.isActive==false) {
						
					
					sunglassesObjects.remove(sunglassess);
			
					}	
				}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			time++;
			if(time%5==0) {
				GameMaker.sunglassesSpawn.setDelay(GameMaker.sunglassesSpawn.getDelay()-10);
			}
			addSunglasses();
		}
	
	 }
	 
	

