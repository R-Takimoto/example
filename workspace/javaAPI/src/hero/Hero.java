package hero;

public class Hero {
	//フィールド
	String name;
	String job;
	int money;

	//メソッド


	//コンストラクタ
	public Hero(String n, String j, int m) {
		this.name = n;
		this.job = j;
		this.money = m;
	}

	public String getName() {
		return this.name;
	}

	public String getJob() {
		return this.job;
	}

	public int getMoney() {
		return this.money;
	}
}
