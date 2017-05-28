import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
Timer timer;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int BATTLE_STATE = 2;
final int END_STATE = 3;
public GamePanel(){
	timer = new Timer(1, this);
}

void startGame(){
	timer.start();
}

void updateMenuState(){
	
}

void updateGameState(){
	
}

void  updateBattleState(){
	
}

void updateEndState(){
	
}

void drawMenuState(){
	
}

void drawGameState(){
	
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
