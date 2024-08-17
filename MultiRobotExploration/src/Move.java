
public class Move {
	Robot r;
	Dir d;
	Boolean ignore = false;
	public Move(Robot r, Dir d) {
		this.r = r;
		this.d = d;
	}
	public void setNoMove() {
		ignore = true;
	}
}
