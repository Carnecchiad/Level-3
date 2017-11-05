import java.awt.Graphics;

public class Bulbasaur extends GameObject {

	public Bulbasaur(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void draw(Graphics g) {
		super.draw(g);
		g.drawImage(GamePanel.bulbasaurImg, x, y, null);
	}
}
