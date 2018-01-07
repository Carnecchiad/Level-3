import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	Rectangle collisionBox;
	int x;
	int y;
	int width;
	int height;
	public boolean isAlive;

	GameObject() {
		isAlive = true;
		collisionBox = new Rectangle(x, y, width, height);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		// g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width,
		// collisionBox.height);
	}
}
