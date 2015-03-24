import javax.swing.ImageIcon;


public class Character extends Entity{
	int xPos;
	int yPos;
	int dir;
	ImageIcon player;
	boolean hasMoved;
	public Character(int x, int y){
		xPos = x;
		yPos = y;
		dir = 1;
		hasMoved = false;
	}
	
	public void move(){
		
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public ImageIcon getPlayer() {
		return player;
	}

	public void setPlayer(ImageIcon player) {
		this.player = player;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	
	
}
