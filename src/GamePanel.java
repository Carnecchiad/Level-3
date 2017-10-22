import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
	public static BufferedImage professorImg;
	public static BufferedImage battleImg;
	boolean haveTalked;
	Trainer trainer;
	Professor oak;
	ObjectManager manager;
	Obstacle shelf1;
	Obstacle shelf2;
	Obstacle shelf3;
	Pokeball ball1;
	Pokeball ball2;
	Pokeball ball3;
	Obstacle machine;
	Obstacle plant1;
	Obstacle plant2;
	Obstacle table;

	public GamePanel() {
		timer = new Timer(1, this);
		trainer = new Trainer(155, 200, 50, 50);
		oak = new Professor(240, 80, 34, 41);
		shelf1 = new Obstacle(221, 240, 145, 60);
		shelf2 = new Obstacle(0, 240, 135, 60);
		shelf3 = new Obstacle(248, 20, 120, 60);
		ball1 = new Pokeball(224, 137, 18, 19);
		ball2 = new Pokeball(253, 137, 15, 19);
		ball3 = new Pokeball(281, 137, 15, 19);
		machine = new Obstacle(30, 115, 50, 75);
		plant1 = new Obstacle(0, 360, 20, 53);
		plant2 = new Obstacle(333, 360, 20, 53);
		table = new Obstacle(0, 15, 245, 35);
		haveTalked = false;
		manager = new ObjectManager();
		manager.addObject(trainer);
		manager.addObject(oak);
		manager.addObject(shelf1);
		manager.addObject(shelf2);
		manager.addObject(shelf3);
		manager.addObject(ball1);
		manager.addObject(ball2);
		manager.addObject(ball3);
		manager.addObject(machine);
		manager.addObject(plant1);
		manager.addObject(plant2);
		manager.addObject(table);
		try {
			trainerImg = ImageIO.read(this.getClass().getResourceAsStream("spritesheet.png"));
			labImg = ImageIO.read(this.getClass().getResourceAsStream("lab.png"));
			professorImg = ImageIO.read(this.getClass().getResourceAsStream("Oak.png"));
			battleImg = ImageIO.read(this.getClass().getResourceAsStream("battleScene.png"));
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
		else if(CURRENT_STATE == BATTLE_STATE) {
			drawBattleState(g);
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
		g.drawImage(labImg, 0, 0, Pokemon.width1, Pokemon.height1, null);
		manager.draw(g);
	}

	void drawBattleState(Graphics g) {
		g.drawImage(battleImg, 0, 0, Pokemon.width1, Pokemon.height1, null);
		//manager.draw(g);
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE && oak.canTalk == true) {
			JOptionPane.showMessageDialog(this,
					"Hi there, My name is Oak.\n Today is the day you will recieve your first Pokemon!",
					"Professor Oak", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(this.getClass().getResource("Oak.png")));
			JOptionPane.showMessageDialog(this, "Go ahead, Choose one of those Pokemon there!", "Professor Oak",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("Oak.png")));
			haveTalked = true;
		}
		oak.setCanTalk(false);
		if (e.getKeyCode() == KeyEvent.VK_SPACE && ball1.canUse && ball3.canUse && haveTalked) {
			int c = JOptionPane.showOptionDialog(this, "Charmander", "Choose Charmander?", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("charmander.png")), null,
					null);
			if (c == 0) {
				JOptionPane.showMessageDialog(this, "Charmander eh? Very nice choice. Now Let's have a battle!",
						"Professor Oak", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(this.getClass().getResource("Oak.png")));
				CURRENT_STATE = BATTLE_STATE;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE && ball1.canUse && haveTalked) {
			int b = JOptionPane.showOptionDialog(this, "Bulbasaur", "Choose Bulbasaur?", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("bulbasaur.png")), null,
					null);
			if (b == 0) {
				JOptionPane.showMessageDialog(this, "Bulbasaur eh? Very nice choice. Now Let's have a battle!",
						"Professor Oak", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(this.getClass().getResource("Oak.png")));
				CURRENT_STATE = BATTLE_STATE;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE && ball3.canUse && haveTalked) {
			int s = JOptionPane.showOptionDialog(this, "Squirtle", "Choose Squirtle?", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("squirtle.gif")), null,
					null);
			if (s == 0) {
				JOptionPane.showMessageDialog(this, "Squirtle eh? Very nice choice. Now Let's have a battle!",
						"Professor Oak", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(this.getClass().getResource("Oak.png")));
				
				CURRENT_STATE = BATTLE_STATE;
			}

		}
		ball1.setCanUse(false);
		ball2.setCanUse(false);
		ball3.setCanUse(false);
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
