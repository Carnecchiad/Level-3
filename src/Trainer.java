import java.awt.Graphics;

public class Trainer extends GameObject {
int speed;
boolean up;
boolean down;
boolean left;
boolean right;
public Trainer(int x, int y, int width, int height){
	super();
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	speed = 2;
	up = false;
	down = false;
	left = false;
	right = false;
}

void update(){
	super.update();
	if(up){
		y -= speed;
	}
	if(down){
		y += speed;
	}
	if(left){
		x -= speed;
	}
	if(right){
		x += speed;
	}
}

void draw(Graphics g){
	g.drawImage(GamePanel.trainerImg, x, y, width, height, null);
}
}
