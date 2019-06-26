import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectOrganizer implements ActionListener {

	Matilda mtld;
	ArrayList <Sunglasses>	sunglassesObjects = new ArrayList<Sunglasses>();
	Random ran = new Random();
	
	
	ObjectOrganizer(Matilda mat){
		
		mtld=mat;		
		
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
				
			}
			
		}
		
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
			
		}
	
	 }
	 
	

