package run;

import game.Slot;

public class Main {

	public static void main(String[] args) {

		Slot s = new Slot();

		int m = s.start(1000);

		System.out.println(m);
	}

}
