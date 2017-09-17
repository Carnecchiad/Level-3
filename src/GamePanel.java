import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int BATTLE_STATE = 2;
	final int END_STATE = 3;
	int CURRENT_STATE = GAME_STATE;
	public static BufferedImage trainerImg;
	public static BufferedImage labImg;
	Trainer trainer;
	ObjectManager manager;
	Obstacle shelf1;
	Obstacle shelf2;
	Obstacle shelf3;

	public GamePanel() {
		timer = new Timer(1, this);
		trainer = new Trainer(155, 200, 50, 50);
		shelf1 = new Obstacle(221, 240, 145, 60);
		shelf2 = new Obstacle(0, 240, 135, 60);
		shelf3 = new Obstacle(300, 30, 120, 60);
		manager = new ObjectManager();
		manager.addObject(trainer);
		manager.addObject(shelf1);
		manager.addObject(shelf2);
		manager.addObject(shelf3);
		try {
			trainerImg = ImageIO.read(this.getClass().getResourceAsStream("spritesheet.png"));
			labImg = ImageIO.read(this.getClass().getResourceAsStream("lab.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	public void paintComponent(Graphics g) {
		if (CURRENT_STATE == MENU_STATE) {
			// drawMenuState(g);
		} else if (CURRENT_STATE == GAME_STATE) {
			drawGameState(g);
		} else if (CURRENT_STATE == END_STATE) {
			// drawEndState(g);
		}

	}

	void updateGameState() {
		manager.update();
		manager.checkCollision();
	}

	void updateBattleState() {

	}

	void updateEndState() {

	}

	void drawMenuState() {

	}

	void drawGameState(Graphics g) {
		g.drawImage(labImg, 0, 0, Pokemon.width, Pokemon.height, null);
		manager.draw(g);
	}

	void drawBattleState() {

	}

	void drawEndState() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (CURRENT_STATE == MENU_STATE) {
			updateMenuState();
		} else if (CURRENT_STATE == GAME_STATE) {
			updateGameState();
		} else if (CURRENT_STATE == END_STATE) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP && !trainer.left && !trainer.right) {
			trainer.up = true;
			trainer.buttonpressed = 3;
			if (trainer.frame < 3) {
				trainer.frame++;
			} else {
				trainer.frame = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && !trainer.left && !trainer.right) {
			trainer.down = true;
			trainer.buttonpressed = 0;
			if (trainer.frame < 3) {
				trainer.frame++;
			} else {
				trainer.frame = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && !trainer.up && !trainer.down) {
			trainer.left = true;
			trainer.buttonpressed = 1;
			if (trainer.frame < 3) {
				trainer.frame++;
			} else {
				trainer.frame = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && !trainer.up && !trainer.down) {
			trainer.right = true;
			trainer.buttonpressed = 2;
			if (trainer.frame < 3) {
				trainer.frame++;
			} else {
				trainer.frame = 0;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			trainer.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			trainer.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			trainer.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			trainer.right = false;
		}
	}

}
