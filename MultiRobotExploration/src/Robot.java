
import java.awt.Color;

import javax.swing.JButton;
enum Dir
{
    N,S,E,W,NE,NW,SE,SW,R
}
public class Robot {
	int x;
	int y;
	JButton button;
	public int square;
	public boolean leader;
	
	public Robot(int square) {
		this.button = Window.map.get(square).button;
		button.setBackground(Color.red);
		this.square = square;
		Window.map.get(square).setOccu();
	}	
	
	public void setLeader(boolean t) {
		leader = t;
		Window.map.get(square).setOccuL();
	}
	
	public boolean move(Dir dir) {
		if(canMove(dir)) {
		switch(dir) {
		case N: 
			if(!Window.map.get(square).N.obstacle) {
				Window.map.get(square).setVis(); 
				if(leader) {
					Window.map.get(square).N.setOccuL();
				} else {
					Window.map.get(square).N.setOccu();	
				}	
				this.x = Window.map.get(square).N.x;
				this.y = Window.map.get(square).N.y;
				this.button = Window.map.get(square).N.button;
				this.square = Window.map.get(square).N.number;
				updateFront();
				break;
			} else {
				return false;
			}
		case S: 
			if(!Window.map.get(square).S.obstacle) {
				Window.map.get(square).setVis(); 
				if(leader) {
					Window.map.get(square).S.setOccuL();
				} else {
					Window.map.get(square).S.setOccu();	
				}	
				this.x = Window.map.get(square).S.x;
				this.y = Window.map.get(square).S.y;
				this.button = Window.map.get(square).S.button;
				this.square = Window.map.get(square).S.number;
				updateFront();
				break;
			} else {
				return false;
			}
		case E: 
			if(!Window.map.get(square).E.obstacle) {
				Window.map.get(square).setVis(); 
				if(leader) {
					Window.map.get(square).E.setOccuL();
				} else {
					Window.map.get(square).E.setOccu();	
				}	
				this.x = Window.map.get(square).E.x;
				this.y = Window.map.get(square).E.y;
				this.button = Window.map.get(square).E.button;
				this.square = Window.map.get(square).E.number;
				updateFront();
				break;
			} else {
				return false;
			}
		case W: 
			if(!Window.map.get(square).W.obstacle) {
				Window.map.get(square).setVis(); 
				if(leader) {
					Window.map.get(square).W.setOccuL();
				} else {
					Window.map.get(square).W.setOccu();	
				}	
				this.x = Window.map.get(square).W.x;
				this.y = Window.map.get(square).W.y;
				this.button = Window.map.get(square).W.button;
				this.square = Window.map.get(square).W.number;
				updateFront();
				break;
			} else {
				return false;
			}
		case NE: 
			if(!Window.map.get(square).NE.obstacle) {
				Window.map.get(square).setVis(); 
				if(leader) {
					Window.map.get(square).NE.setOccuL();
				} else {
					Window.map.get(square).NE.setOccu();	
				}	
				this.x = Window.map.get(square).NE.x;
				this.y = Window.map.get(square).NE.y;
				this.button = Window.map.get(square).NE.button;
				this.square = Window.map.get(square).NE.number;
				updateFront();
				break;
			} else {
				return false;
			}
		case NW: 
			if(!Window.map.get(square).NW.obstacle) {
				Window.map.get(square).setVis(); 
				if(leader) {
					Window.map.get(square).NW.setOccuL();
				} else {
					Window.map.get(square).NW.setOccu();	
				}	
				this.x = Window.map.get(square).NW.x;
				this.y = Window.map.get(square).NW.y;
				this.button = Window.map.get(square).NW.button;
				this.square = Window.map.get(square).NW.number;
				updateFront();
				break;
			} else {
				return false;
			}
		case SW: 
			if(!Window.map.get(square).SW.obstacle) {
				Window.map.get(square).setVis(); 
				if(leader) {
					Window.map.get(square).SW.setOccuL();
				} else {
					Window.map.get(square).SW.setOccu();	
				}	
				this.x = Window.map.get(square).SW.x;
				this.y = Window.map.get(square).SW.y;
				this.button = Window.map.get(square).SW.button;
				this.square = Window.map.get(square).SW.number;
				updateFront();
				break;
			} else {
				return false;
			}
			
		case SE: 
			if(!Window.map.get(square).SE.obstacle) {
				Window.map.get(square).setVis(); 
				if(leader) {
					Window.map.get(square).SE.setOccuL();
				} else {
					Window.map.get(square).SE.setOccu();	
				}	
				this.x = Window.map.get(square).SE.x;
				this.y = Window.map.get(square).SE.y;
				this.button = Window.map.get(square).SE.button;
				this.square = Window.map.get(square).SE.number;
				updateFront();	
				break;
			} else {
				return false;
			}
		case R:
			return true;
		}	
		}

		return true;
	}
	public void updateFront() {
		if(Window.map.get(square).N != null && Window.map.get(square).N.unknown) {
			Window.map.get(square).N.setFront();
		}
		if(Window.map.get(square).S != null && Window.map.get(square).S.unknown) {
			Window.map.get(square).S.setFront();
		}
		if(Window.map.get(square).E != null && Window.map.get(square).E.unknown) {
			Window.map.get(square).E.setFront();
		}
		if(Window.map.get(square).W != null && Window.map.get(square).W.unknown) {
			Window.map.get(square).W.setFront();
		}
		if(Window.map.get(square).NE != null && Window.map.get(square).NE.unknown) {
			Window.map.get(square).NE.setFront();
		}
		if(Window.map.get(square).NW != null && Window.map.get(square).NW.unknown) {
			Window.map.get(square).NW.setFront();
		}
		if(Window.map.get(square).SE != null && Window.map.get(square).SE.unknown) {
			Window.map.get(square).SE.setFront();
		}		
		if(Window.map.get(square).SW != null && Window.map.get(square).SW.unknown) {
			Window.map.get(square).SW.setFront();
		}
	}
	public boolean canMove(Dir dir) {
		switch(dir) {
		case N: 
			if(Window.map.get(square).N != null && !Window.map.get(square).N.obstacle) {
				return true;
			} else {
				return false;
			}
		case S: 
			if(Window.map.get(square).S != null && !Window.map.get(square).S.obstacle) {
				return true;
			} else {
				return false;
			}
		case E: 
			if(Window.map.get(square).E != null && !Window.map.get(square).E.obstacle) {
				return true;
			} else {
				return false;
			}
		case W: 
			if(Window.map.get(square).W != null && !Window.map.get(square).W.obstacle) {
				return true;
			} else {
				return false;
			}
		case NE: 
			if(Window.map.get(square).NE != null && !Window.map.get(square).NE.obstacle) {
				return true;
			} else {
				return false;
			}
		case NW: 
			if(Window.map.get(square).NW != null && !Window.map.get(square).NW.obstacle) {
				return true;
			} else {
				return false;
			}
		case SW: 
			if(Window.map.get(square).SW != null && !Window.map.get(square).SW.obstacle) {
				return true;
			} else {
				return false;
			}
			
		case SE: 
			if(Window.map.get(square).SE != null && !Window.map.get(square).SE.obstacle) {
				return true;
			} else {
				return false;
			}
		case R:
			return true;
		}	
		return true;
	}
}
