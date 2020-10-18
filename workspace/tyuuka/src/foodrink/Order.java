package foodrink;

import java.util.ArrayList;

public class Order {
	Ramen ra = new Ramen();
	Charhan ch = new Charhan();
	Syouron sy = new Syouron();
	Gyouza gy = new Gyouza();

	public static void od() {
		ArrayList<Food> orde  = new ArrayList<Food>();
		System.out.println("番号入力でよろ");
		System.out.println("1: ラーメン");
		System.out.println("2: チャーハン");
		System.out.println("3: 小籠包");
		System.out.println("4: 餃子");
		System.out.println("5: ウーロン茶");

		for(int i = 1; i < 6; i ++) {
			System.out.println(i + "つめの注文をお願いします");
			int n = new java.util.Scanner(System.in).nextInt();

			if(n == 1) {
				orde.add(new Ramen());
			}else if(n == 2) {
				orde.add(new Charhan());
			}else if(n == 3) {
				orde.add(new Syouron());
			}else if(n == 4) {
				orde.add(new Gyouza());
			}else if (n == 5) {
				System.out.println("ホットならh,コールドならｃで");
				String v = new java.util.Scanner(System.in).nextLine();
				if(v.equals("h")) {
					orde.add(new Uron("のホット"));
				}else {
					orde.add(new Uron("の冷たいやつ"));
				}
			}
			if(i != 5) {
				System.out.println("追加しますか?");
				System.out.println("y/n");
				String yn = new java.util.Scanner(System.in).nextLine();
				if(yn.equals("n")) {
					break;
				}
			}

		}
		System.out.println("ご注文は");
		for(Food foo : orde) {
			System.out.println(foo.name);
		}
		int total = 0;
		for(Food fo : orde) {
			total += fo.kakaku;
		}
		System.out.println("合計" + total + "円です");
	}

}
