package practice;

public class Drink {
	//フィールド
	private String name;
	private String affiliation;
	private int capacity;
	private int price;
	private String temperature;

	//メソッド
	//ゲッター・セッター
	public String getName() {
		return name;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getPrice() {
		return price;
	}

	public String getTemperature() {
		return temperature;
	}
	//コンストラクタ
	public Drink(String n, String a, int c, int p, String t) {
		this.name = n;
		this.affiliation = a;
		this.capacity = c;
		this.price = p;
		this.temperature = t;
	}


}
