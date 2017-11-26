import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Opponent extends GameObject {
	BufferedImage sprite;

	public Opponent(int x, int y, int width, int height, String pokemon) {
		this(pokemon);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Opponent(String pokemon) {
		try {
			if (pokemon.equals("Bulbasaur")) {
				sprite = ImageIO.read(this.getClass().getResourceAsStream("charmander.png"));
			} else if (pokemon.equals("Charmander")) {
				sprite = ImageIO.read(this.getClass().getResourceAsStream("squirtle.gif"));
			} else if (pokemon.equals("Squirtle")) {
				sprite = ImageIO.read(this.getClass().getResourceAsStream("bulbasaur.png"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void draw(Graphics g) {
		super.draw(g);
		g.drawImage(sprite, x, y, null);
	}

}
