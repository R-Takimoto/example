package rpg11_01;
import rpg20200827.Matango;

public abstract class Character {
	//フィールド
	String name;
	int hp;

	//メソッド
	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}

	//アブストラクトメソッド
	public abstract void attack(Matango m);
}
