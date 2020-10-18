package characters;

public abstract class character {
	//フィールド
	private String name;
	private int money;

	//メソッド
	abstract public int skill();

	//セッター・ゲッター
	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	//コンストラクタ
	public character(String name) {
		this.name = name;
	}

}
