package seiretu;

public class Fruits {


	public Fruits(String name, int zaiko, int tanka) {
		super();
		this.name = name;
		this.zaiko = zaiko;
		this.tanka = tanka;
	}


	String name ;
	int zaiko;
	int tanka ;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZaiko() {
		return zaiko;
	}
	public void setZaiko(int zaiko) {
		this.zaiko = zaiko;
	}
	public int getTanka() {
		return tanka;
	}
	public void setTanka(int tanka) {
		this.tanka = tanka;
	}



}
