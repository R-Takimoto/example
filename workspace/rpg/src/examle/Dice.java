package examle;

public class Dice {
	int max;

	public Dice(int n) {
		this.max = n;
	}

	public Dice() {
		this(10);
	}

	public int shake() {
		int rt = new java.util.Random().nextInt(this.max) + 1;

		return rt;
	}
}
