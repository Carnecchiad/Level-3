import java.awt.Graphics;

public class Charmander extends GameObject {

	public Charmander(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void draw(Graphics g) {
		super.draw(g);
		g.drawImage(GamePanel.charmanderImg, x, y, null);
	}
}