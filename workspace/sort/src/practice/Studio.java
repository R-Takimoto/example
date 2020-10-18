package practice;

public class Studio {
	//フィールド
	private String name;
	private int capacity;
	private String couse;

	//メソッド
	//ゲッター・セッター
	public String getName() {
		return name;
	}
	public int getCapacity() {
		return capacity;
	}
	public String getCouse() {
		return couse;
	}
	//コンストラクタ
	public Studio(String name, int cap, String cou) {
		this.name = name;
		this.capacity = cap;
		this.couse = cou;
	}
}
