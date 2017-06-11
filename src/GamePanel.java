import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
Timer timer;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int BATTLE_STATE = 2;
final int END_STATE = 3;
int CURRENT_STATE = GAME_STATE;
public static BufferedImage trainerImg;
Trainer trainer;
ObjectManager manager;
public GamePanel(){
	timer = new Timer(1, this);
	trainer = new Trainer(200, 200, 50, 50);
	manager = new ObjectManager();
	manager.addObject(trainer);
	try {
		trainerImg = ImageIO.read(this.getClass().getResourceAsStream("red.png"));
	} catch(IOException e){
		e.printStackTrace();
	}
}

void startGame(){
	timer.start();
}

void updateMenuState(){
	
}

void updateGameState(){
	manager.update();
}

void  updateBattleState(){
	
}

void updateEndState(){
	
}

void drawMenuState(){
	
}

void drawGameState(Graphics g){
	manager.draw(g);
}

void  drawBattleState(){
	
}

void drawEndState(){
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
