package rpg12_01;

import rpg20200827.Matango;

public abstract class Character {
	String name;
	int hp;

	public void run()  {
		System.out.println("にげい");
	}

	public abstract void attack(Matango m) ;

}
