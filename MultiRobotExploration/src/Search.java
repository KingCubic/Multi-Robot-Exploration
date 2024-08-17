
import java.util.ArrayList;
import java.util.Random;


public class Search {
	static int numRobots;
	public static boolean comExplr() {
	    new Thread() {
	        public void run() {
	            try {
	            	Thread.sleep(10000);
	            	//Initialize the robots
	            	ArrayList<Robot> robots = new ArrayList<>();
//	            	for(int i = 1; i <= numRobots; i++) {
//	            		robots.add(new Robot(i));
//	            		robots.get(i-1).updateFront();
//	            		if(i == numRobots - 1) 
//	            			robots.get(i - 1).setLeader(true);
//	            	}
	            	robots.add(new Robot(400));
	            	robots.get(0).updateFront();
	            	robots.add(new Robot(211));
	            	robots.get(1).updateFront();
	            	robots.add(new Robot(580));
	            	robots.get(2).updateFront();
	            	robots.get(0).setLeader(true);
	            	
	            	
	            	//Default total number of moves
	        		int totalSteps = 500;
	        		int t = 0;
	        		int configsK = 40;
	        		while(t < totalSteps) {
	        			
	        			//For each generated configuration
	        			ArrayList<ArrayList<Move>> pop = new ArrayList<>();
	        			for(int i = 1; i <= configsK; i++) {
	        				ArrayList<Move> Config = new ArrayList<>();
	        				
	        				//Set a movement for each of the robots randomly
	        				for(Robot r: robots) {
	        					int num = new Random().nextInt(Dir.values().length);
	        					Move m = new Move(r, Dir.values()[num]);
	        					Config.add(m);
	        				}
	        				
	        				//add it to the population of configurations
	        				pop.add(Config);
	        			}
	        			//For each population of configurations
	        			//find one with highest utility
	        			double finalUtil = 0;
	        			ArrayList<Move> finalPop = new ArrayList<>();
	        			for(ArrayList<Move> m: pop) {
	        				double tempUtil = 0;
	        				
	        				for(Move r: m) {
	        					double tempUtil2 = 10000;
	        					Dir d = r.d;
	        					double dist = distRobot(Window.map.get(r.r.square).getDir(d));
	        					double distImprovement = distRobot(Window.map.get(r.r.square));
	        					if(!r.r.canMove(r.d)) {
	        						tempUtil2 = tempUtil2 - 1;
	        					}
	        					if(!r.r.leader) { 
	        						if(dist > 5) {
	        							tempUtil2 = tempUtil2 - 1;
	        						}
	        						if(dist > 7) {
	        							if(dist > distImprovement)  {	
	        								r.setNoMove();
	        								continue;
	        							}
	        						}
	        					}
	        					tempUtil2 = tempUtil2 - distFront(Window.map.get(r.r.square).getDir(d), r.r);
	        					tempUtil = tempUtil + tempUtil2;
	        				}

	        				//if util < previous util ignore
	        				if(tempUtil > finalUtil) {
	        					finalPop = m;
	        					finalUtil = tempUtil;
	        				}
	        			}
	        			//Execute highest utility
	        			for(Move m: finalPop) {
	        				if(m.r.leader)
	        					m.r.move(m.d);
	        			}
	        			for(Move m: finalPop) {
	        				if(!m.ignore && !m.r.leader)
	        					m.r.move(m.d);
	        			}
	        			
	        			Thread.sleep(100);
	        			t = t + 1;
	        		}
	        	robots = null;
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        System.out.println("Search complete.");
			System.exit(0);
	        }
		
	    }.start();

		return true;
	}
	public static double distFront(Node r, Robot t) {
		double dist = 100000000000.00;
		double testDist = 10000000000.00;
		for(int i = 1; i <= Window.cols*Window.rows; i++) {
			if(Window.map.get(i).frontier) {
				testDist = Math.hypot(r.x - Window.map.get(i).x, r.y - Window.map.get(i).y);
				if(testDist < dist)
				dist = testDist;
			}
		}
		return dist;
	}
	public static double distRobot(Node r){
		double dist = 1000000;
		double testDist = 1000000000;
		for(int i = 1; i <= Window.cols*Window.rows; i++) {
			if(Window.map.get(i).occuL) {
				testDist = Math.hypot(r.x - Window.map.get(i).x, r.y - Window.map.get(i).y);
				if(testDist < dist) {
				dist = testDist;
				}
			}
		}
		return dist;
	}
	
}
