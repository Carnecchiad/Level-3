import java.awt.Graphics;
import java.util.ArrayList;
public class ObjectManager {
	ArrayList<GameObject> objects;
	
	public ObjectManager(){
		objects = new ArrayList<GameObject>();
	}
	
	public void addObject(GameObject o){
		System.out.println("test");
		objects.add(o);
	}
	
	public void update(){
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		
		purgeObjects();
	}
	
	public void draw(Graphics g){
		for (int i = 0; i < objects.size(); i++) {
			
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}
	
	private void purgeObjects(){
		for (int i = 0; i < objects.size(); i++) {
			if(!objects.get(i).isAlive){
				objects.remove(i);
			}
		}
	}
	
}
