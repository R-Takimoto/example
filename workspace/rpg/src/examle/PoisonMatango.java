package examle;
import rpg20200827.Hero;
import rpg20200827.Matango;

public class PoisonMatango extends Matango {
	//フィールド
	int remaining = 5;

	//コンストラクタ
	public PoisonMatango(char suffix) {
		super(suffix);
	}

	//メソッド
	public void attack(Hero h) {
		super.attack(h);
		if(this.remaining == 0) {
			int dmg;
			System.out.println("さらに毒の胞子をばらまいた");
			dmg = h.hp / 20;
			h.hp -= dmg;
			System.out.println(dmg + "のダメージ");
			this.remaining --;
		}
	}
}
