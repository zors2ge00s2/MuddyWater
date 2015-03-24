import java.util.ArrayList;


public class Stage {
	Block[][] grid;
	ArrayList<Entity> entities;
	
	public Stage(){
		entities =new ArrayList<Entity>();
		grid = new Block[24][24];
		
	}

	public Block[][] getGrid() {
		return grid;
	}

	public void setGrid(Block[][] grid) {
		this.grid = grid;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	
}
