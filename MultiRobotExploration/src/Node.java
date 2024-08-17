import java.awt.Color;

import javax.swing.JButton;

public class Node {
	public JButton button;
	public Node N;
	public Node S;
	public Node E;
	public Node W;
	public Node NE;
	public Node NW;
	public Node SE;
	public Node SW;

	
	
	public boolean visited;
	public boolean frontier;
	public boolean unknown;
	public boolean obstacle;
	public boolean occu;
	public boolean occuL;
	public int number;
	public int x;
	public int y;
	
	public Node(JButton button, int x, int y) {
		this.number = Integer.parseInt(button.getText());
		this.visited = false;
		this.frontier = false;
		this.obstacle = false;
		this.unknown = true;
		this.occu = false;
		this.occuL = false;
		this.button = button;	
		this.x = x;
		this.y = y;
	}
	public void setVis() {
		this.visited = true;
		this.unknown = false;
		this.obstacle = false;
		this.frontier = false;
		this.occu = false;
		this.occuL = false;
		this.button.setBackground(Color.green);
	}
	public void setObs() {
		this.unknown = false;
		this.obstacle = true;
		this.occu = false;
		this.occuL = false;
		this.button.setBackground(Color.black);
	}
	public void setFront() {
		if(this.unknown = true) {
			this.frontier = true;
			this.occu = false;
			this.occuL = false;
			//??? maybe false???
			this.unknown = false;
			this.button.setBackground(Color.orange);
		}
	}
	public void setOccu() {
		this.obstacle = true;
		this.unknown = false;
		this.frontier = false;
		this.occu = true;
		this.button.setBackground(Color.red);
	}
	public void setOccuL() {
		this.obstacle = true;
		this.unknown = false;
		this.frontier = false;
		this.occu = true;
		this.occuL = true;
		
		this.button.setBackground(Color.BLUE);
	}
	public Node getDir(Dir d) {
		if(this.N != null && d == Dir.N)
			return this.N;
		if(this.S != null && d == Dir.S)
			return this.S;
		if(this.E != null && d == Dir.E)
			return this.E;
		if(this.W != null && d == Dir.W)
			return this.W;
		
		if(this.NE != null && d == Dir.NE)
			return this.NE;
		if(this.NW != null && d == Dir.NW)
			return this.NW;
		if(this.SW != null && d == Dir.SW)
			return this.SW;
		if(this.SE != null && d == Dir.SE)
			return this.SE;
		return this;
	}
	
}
