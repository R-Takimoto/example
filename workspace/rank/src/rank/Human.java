package rank;

public abstract class Human {
	//フィールド
	String name;
	char sex;

	//メソッド
	abstract public void sleep();

	//コンストラクタ
	public Human(String n, char s) {
		this.name = n;
		this.sex = s;
	}
}
