//Boston Woods
//Project Implementation
//Algorithm 1
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		String inp = "";
		Scanner input = new Scanner(System.in);
    	System.out.println("Choose environment 1 or 2:");
    	Window.env = input.nextInt();
    	System.out.println("Choose the number of robots: ");
    	Search.numRobots = input.nextInt();		
    	System.out.println("Enter s to start:");
		inp = input.next();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Window();
				Search.comExplr();
			}	
		});	
	}

}