import java.awt.Graphics;

public class Obstacle extends GameObject {
	Obstacle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	void draw(Graphics g) {
		// g.drawRect(x, y, width, height);
	}
}
