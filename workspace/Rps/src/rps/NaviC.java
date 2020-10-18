package rps;

public class NaviC extends Navi {

	public NaviC(String name) {
		super(name);
		this.num = new java.util.Random().nextInt(3);
	}

	public void shake() {
		this.num = new java.util.Random().nextInt(3);
	}
}
