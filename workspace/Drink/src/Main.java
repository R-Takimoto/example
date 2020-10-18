import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Maker m1= new Maker("コカ・コーラ", "078-000-0000");
		Maker m2= new Maker("アサヒ飲料", "06-000-0000");

		Drink d1 = new Drink("コーラ",m1,350,120,false);
		Drink d2 = new Drink("〇〇茶",m2,500,140,false);
		Drink d3 = new Drink("アクエリアス",m1,600,140,false);
		Drink d4 = new Drink("ブラックコーヒー",m2,180,110,true);

		List<Drink> drinks = new ArrayList<>();
		drinks.add(d1);
		drinks.add(d2);
		drinks.add(d3);
		drinks.add(d4);

		showDrinks(drinks);

	}

	public static void showDrinks(List<Drink> drinks) {
		for (Drink d : drinks) {
			System.out.println("商品名:"+ d.getName());
			System.out.println("メーカー：" + d.getMaker().getName()+"("+d.getMaker().getTel()+")");
			System.out.println("容量:" + d.getSize());
			System.out.println("価格:" + d.getPrice());
			System.out.println("温度:" + showHot(d.isHot()));
			System.out.println("-----------");
		}

	}

	public static String showHot(boolean bool) {
		return bool ? "ホット":"コールド";
	}

}
