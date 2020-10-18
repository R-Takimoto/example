package rpg10_01;

import rpg20200827.Matango;

public class Hero {
	String name = "ミナト";
	int hp = 100;

	public  Hero() {
		System.out.println("Heroのコンストラクタが動作");

	}

	public void attack(Matango m) {
		int at;
		at = 10;
		System.out.println(this.name + "の攻撃！");
		m.hp -= at;
		System.out.println( at + "ポイントのダメージをあたえた！");
	}

	public void run() {
		System.out.println(this.name + "は逃げ出した！");
	}

}
