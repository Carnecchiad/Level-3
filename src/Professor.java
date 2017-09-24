import java.awt.Graphics;

public class Professor extends GameObject {

	public Professor(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		super.draw(g);
		g.drawImage(GamePanel.professorImg, 240, 80, null);
	}
}
