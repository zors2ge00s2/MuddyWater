import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Engine extends JFrame{
	private Image dbImage;
	private Graphics dbg;
	ArrayList<Stage> stages;
	Character player;

	public Engine(){
		setTitle("Muddy Water- by ForeTP");
		setSize(1200, 1200);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new AL());
		player = new Character(45+50+9, 45+50+9);
		stages = new ArrayList<Stage>();
		stages.add(new Stage());
		stages.get(0).getEntities().add(new AI(45*2 + 50 + 9, 45*2 + 50 + 9, true));

	}

	public class AL extends KeyAdapter{
		/*Directions
		 *1 = right
		 *2 = up
		 *3 = left
		 *4 = down */
		public void keyPressed(KeyEvent e){
			player.setHasMoved(true);
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_A){
				if(player.getDir() != 3){
					player.setDir(3);
				}else{
					if(player.getxPos() <= 59){
						player.setxPos(59);
					}else{
						player.setxPos(player.getxPos() - 45);
					}
				}
			}else if(keyCode == e.VK_D){
				if(player.getDir() != 1){
					player.setDir(1);
				}else{
					if(player.getxPos() >= 1094){
						player.setxPos(1094);
					}else{
						player.setxPos(player.getxPos() + 45);
					}
				}
			}else if(keyCode == e.VK_S){
				if(player.getDir() != 4){
					player.setDir(4);
				}else{
					if(player.getyPos() >= 1094){
						player.setyPos(1094);
					}else{
						player.setyPos(player.getyPos() + 45);
					}
				}
			}else if(keyCode == e.VK_W){
				if(player.getDir() != 2){
					player.setDir(2);
				}else{
					if(player.getyPos() <= 59){
						player.setyPos(59);
					}else{
						player.setyPos(player.getyPos() - 45);
					}
				}
			}
		}



		public void keyReleased(KeyEvent e){

		}
	}


	public void paint(Graphics g){	
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void paintComponent(Graphics g){
		//drawing the tiles
		g.setColor(Color.BLACK);
		for(int i = 0; i < 24; i++){
			for(int j = 0; j < 24; j++){
				g.drawRect((i*45)+50, (j*45)+50, 45, 45);

			}
		}

		//drawing the character
		g.setColor(Color.RED);
		g.drawOval(player.getxPos(), player.getyPos(), 24, 24);
		//dir
		/*Directions
		 *1 = right
		 *2 = up
		 *3 = left
		 *4 = down */
		if(player.getDir() == 1){
			g.drawRect(player.getxPos()+9, player.getyPos()+9, 20, 2);
		}else if(player.getDir() == 2){
			g.drawRect(player.getxPos()+9, player.getyPos()-9, 2, 20);
		}else if(player.getDir() == 3){
			g.drawRect(player.getxPos()-9, player.getyPos()+9, 20, 2);
		}else if(player.getDir() == 4){
			g.drawRect(player.getxPos()+9, player.getyPos()+9, 2, 20);

		}

		g.setColor(Color.BLACK);
		
		for(int i = 0; i < stages.get(0).getEntities().size(); i++){
			g.drawOval(stages.get(0).getEntities().get(i).getxPos(), stages.get(0).getEntities().get(i).getyPos(), 24, 24);
		}
		System.out.println(stages.get(0).getEntities().get(0).getxPos());
		if(player.isHasMoved()){
			moveEntities();
			player.setHasMoved(false);
		}
		repaint();
	}

	public void moveEntities(){
		for(int i = 0; i < stages.get(0).getEntities().size(); i++){
			stages.get(0).getEntities().get(i).move();
		}
	}

	public static void main(String[] args) {
		new Engine();
	}

}
