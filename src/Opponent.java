import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Opponent extends GameObject {
	static BufferedImage sprite;

	public Opponent(String pokemon) {
		try {
			if (pokemon.equals("Bulbasaur")) {
				sprite = ImageIO.read(this.getClass().getResourceAsStream("charmander.png"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Opponent(int x, int y, int width, int height, String pokemon) {
		this(pokemon);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}
