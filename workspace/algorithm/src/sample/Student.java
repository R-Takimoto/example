package sample;

public class Student {
	//フィールド
	String name;
	String number;

	//メソッド

	//コンストラクタ
	public Student(String n, String i) {
		this.name = n;
		this.number = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
