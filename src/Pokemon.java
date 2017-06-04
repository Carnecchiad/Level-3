import javax.swing.*;
public class Pokemon {
JFrame frame;
GamePanel panel;
public static final int width = 500;
public static final int height = 800;
Pokemon(){
	frame = new JFrame();
	panel = new GamePanel();
	frame.add(panel);
	frame.addKeyListener(panel);
	setup();
}
public static void main(String[] args) {
	Pokemon game = new Pokemon();
}
void setup(){
	frame.add(panel);
	frame.setSize(width, height);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.startGame();
}
}
