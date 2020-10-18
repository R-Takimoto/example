package read;

public class Fruit {
	//フィールド
	private String name;
	private int zaiko;
	private int price;
	public String getName() {
		return name;
	}

	//ゲッター・セッター
	public void setName(String name) {
		this.name = name;
	}
	public int getZaiko() {
		return zaiko;
	}
	public void setZaiko(int zaiko) {
		this.zaiko = zaiko;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	//コンストラクタ
	public Fruit(String name, int zaiko, int price) {
		super();
		this.name = name;
		this.zaiko = zaiko;
		this.price = price;
	}

}
