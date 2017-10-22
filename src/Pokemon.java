import java.awt.Dimension;

import javax.swing.*;
public class Pokemon {
JFrame frame;
GamePanel panel;
public static final int width1 = 358;
public static final int height1 = 429;
Pokemon(){
	frame = new JFrame();
	panel = new GamePanel();
	//frame.add(panel);
	frame.addKeyListener(panel);
	setup();
}
public static void main(String[] args) {
	Pokemon game = new Pokemon();
}
void setup(){
	frame.add(panel);
	frame.getContentPane().setPreferredSize(new Dimension(width1, height1));
	frame.pack();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.startGame();
}

}
