import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objects;
	Trainer player;
	GameObject object;

	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		System.out.println("test");
		objects.add(o);
	}

	public void addObject(Trainer t) {
		player = t;
	}

	public void update() {
		player.update();
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}

		purgeObjects();
	}

	public void draw(Graphics g) {
		player.draw(g);
		for (int i = 0; i < objects.size(); i++) {

			GameObject o = objects.get(i);
			o.draw(g);
		}
	}
	
	public void draw2(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {

			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			if (player.collisionBox.intersects(objects.get(i).collisionBox)) {
				if (objects.get(i) instanceof Professor) {
					((Professor) objects.get(i)).setCanTalk(true);
				}
				if (objects.get(i) instanceof Pokeball) {
					((Pokeball) objects.get(i)).setCanUse(true);
				}
				player.collider = true;
			}
		}

	}

}
