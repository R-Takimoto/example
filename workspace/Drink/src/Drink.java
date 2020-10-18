
public class Drink {
	private String name;
	private Maker maker;
	private int size;
	private int price;
	private boolean isHot;

	public Drink(String name,Maker maker,int size,int price,boolean isHot){
		 this.name = name;
		 this.maker = maker;
		 this.size = size;
		 this.price = price;
		 this.isHot = isHot;

	}

	public String getName() {
		return name;
	}

	public Maker getMaker() {
		return maker;
	}

	public int getSize() {
		return size;
	}

	public int getPrice() {
		return price;
	}

	public boolean isHot() {
		return isHot;
	}



}
