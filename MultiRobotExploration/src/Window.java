import java.awt.*;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	static int cols = 30;
	static int rows = 30;
	static int env;
	private Container frame;
	public GridLayout grid = new GridLayout(rows,cols);
	public static HashMap<Integer, Node> map = new HashMap<>();
	
	public Window() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = getContentPane();
		frame.setLayout(grid);
		setTitle("Multi Robot Exploration");
		setResizable(true);
		setSize(1300,1300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		makeButtonsAndGrid();
		setVisible(true);
		if(env == 1) {
			drawYLine(map.get(441),map.get(621));
			drawYLine(map.get(442),map.get(622));
			drawYLine(map.get(443),map.get(623));
			drawYLine(map.get(444),map.get(624));
			drawYLine(map.get(445),map.get(625));
			
			drawYLine(map.get(364),map.get(544));
			drawYLine(map.get(365),map.get(545));
			drawYLine(map.get(366),map.get(546));
			drawYLine(map.get(367),map.get(547));
			drawYLine(map.get(368),map.get(548));
			
			drawYLine(map.get(822),map.get(852));
			drawYLine(map.get(823),map.get(853));
			drawYLine(map.get(824),map.get(854));
			drawYLine(map.get(825),map.get(855));
			drawYLine(map.get(826),map.get(856));
			drawYLine(map.get(827),map.get(857));
			
			drawYLine(map.get(214),map.get(244));
			drawYLine(map.get(215),map.get(245));
			drawYLine(map.get(216),map.get(246));
			drawYLine(map.get(217),map.get(247));
			drawYLine(map.get(218),map.get(248));
			
			drawYLine(map.get(351),map.get(381));
			drawYLine(map.get(352),map.get(382));
			drawYLine(map.get(353),map.get(383));
			drawYLine(map.get(354),map.get(384));
			drawYLine(map.get(355),map.get(385));
		} else {
			drawYLine(map.get(129),map.get(249));
			drawYLine(map.get(135),map.get(255));
			drawYLine(map.get(140),map.get(260));
			drawYLine(map.get(145),map.get(265));
			drawYLine(map.get(150),map.get(270));
			drawYLine(map.get(371),map.get(521));
			drawYLine(map.get(377),map.get(527));
			drawYLine(map.get(383),map.get(533));
			drawYLine(map.get(388),map.get(538));
			drawYLine(map.get(365),map.get(515));
			drawYLine(map.get(603),map.get(783));
			drawYLine(map.get(607),map.get(787));
			drawYLine(map.get(642),map.get(792));
			drawYLine(map.get(648),map.get(798));
			drawYLine(map.get(654),map.get(804));
			drawYLine(map.get(660),map.get(810));
		}
	}
	

	public void makeButtonsAndGrid() {
		for(int i = 0; i < ((cols)*(rows)); i++) {
			JButton a = new JButton();
			a.setBackground(Color.yellow);
			a.setText(String.valueOf(i + 1)); 			
			frame.add(a);
			map.put(i + 1, new Node(a, i%30, (int) i/30));
		}
		for(int i = 1; i <= ((cols)*(rows)); i++) {
			//setN
			if(i - cols >= 0) 
				map.get(i).N = map.get(i - cols);
			
			//SetS
			if(i + cols <= cols*rows)
				map.get(i).S = map.get(i + cols);
			
			//SetE
			if((i + 1)%cols != 1) 
				map.get(i).E = map.get(i + 1);
			
			//SetW
			if((i - 1)%cols != 0) 
				map.get(i).W = map.get(i - 1);
			
			//SetNE
			if((i - cols >= 0) && ((i + 1)%cols != 1))
				map.get(i).NE = map.get(i - cols + 1);
			
			//SetNW
			if((i - cols >= 0) && ((i - 1)%cols != 0))
				map.get(i).NW = map.get(i - cols - 1);
			
			//SetSW
			if((i + cols <= cols*rows) && ((i - 1)%cols != 0))
				map.get(i).SW = map.get(i + cols - 1);
			
			//SetSE
			if((i + cols <= cols*rows) && ((i + 1)%cols != 1))
				map.get(i).SE = map.get(i + cols + 1);
		}	
	}
	public void drawYLine(Node a, Node b) {
		Node currNode = a;
		while(currNode.number != b.number) {
			currNode.setObs();
			currNode = currNode.S;
		}
		b.setObs();
	}
	public void drawXLine(Node a, Node b) {
		
	}
}
