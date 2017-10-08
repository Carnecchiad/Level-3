
public class Pokeball extends GameObject {
	boolean canUse;

	public Pokeball(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox.setBounds(x, y, width, height);
	}

	void setCanUse(boolean canTalk) {
		this.canUse = canTalk;
	}

	boolean canUse() {
		return canUse;
	}
}
