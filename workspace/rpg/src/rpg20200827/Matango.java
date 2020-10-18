package rpg20200827;

public class Matango {
	//フィールド
	public int hp = 50;
	public char suffix;
	public String name;
	final int LEVEL = 10;

	//コンストラクタ
	public Matango(char suffix) {
		this.suffix = suffix;
	}

	//メソッド
	public void attack(Hero h) {
		System.out.println("キノコ" + this.suffix + "の攻撃");
		System.out.println("10のダメージ");
		h.hp -= 10;
	}
	public void run() {
		System.out.println("お化けキノコ" + this.suffix + "逃げ出した！");
	}
}
