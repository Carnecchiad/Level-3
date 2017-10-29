import java.awt.Graphics;

public class Sprite1 extends GameObject {

	public Sprite1(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void draw(Graphics g) {
		super.draw(g);
		g.drawImage(GamePanel.professorImg, 150, 200, null);
	}
}
