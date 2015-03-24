
public class AI extends Entity {
	int xPos;
	int yPos;
	boolean isFriendly;

	public AI(int x, int y, boolean friendly){
		xPos = x;
		yPos = y;
		isFriendly = friendly;
	}

	public void interact(){

	}

	public void attack(){

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

	public void move(){
		double rng = Math.random();
		if(rng < .25){
			if(xPos >= 1094){
				xPos = 1094;
			}else{
				xPos = xPos + 45;
			}
		}else if(rng > .25 && rng < .50){
			if(xPos <= 59){
				xPos = 59;
			}else{
				xPos = xPos - 45;
			}
		}else if(rng > .50 && rng < .75){
			if(yPos <= 59){
				yPos = 59;
			}else{
				yPos = yPos - 45;
			}
		}else if(rng < 75){
			if(yPos >= 1094){
				yPos = 1094;
			}else{
				yPos = yPos + 45;
			}
		}
	}
}


