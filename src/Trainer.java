import java.awt.Graphics;

public class Trainer extends GameObject {
	double speed;
	double xd;
	double yd;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean canmove;
	boolean collider;

	public Trainer(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		yd = y;
		xd = x;
		speed = .2;
		up = false;
		down = false;
		left = false;
		right = false;
		canmove = true;
		collider = false;
	}

	void update() {
		if (!collider) {
			y = (int) yd;
			x = (int) xd;
		} else {
			yd = y;
			xd = x;
			collider = false;
		}
		if (up) {
			yd -= speed;
		}
		if (down) {
			yd += speed;
		}
		if (left) {
			xd -= speed;
		}
		if (right) {
			xd += speed;
		}
		if (xd < 0) {
			xd = 0;
		} else if (xd > 358 - width) {
			xd = 358 - width;
		} else if (yd < 0) {
			yd = 0;
		} else if (yd > 429 - height) {
			yd = 429 - height;
		}

		collisionBox.setBounds((int) xd, (int) yd, width, height);
	}

	void draw(Graphics g) {
		super.draw(g);
		g.drawImage(GamePanel.trainerImg, x, y, width, height, null);
	}
}
