package practice;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//スタジオ情報
		String[] studioName = {"studio1", "studio2", "studio3", "studio4"};
		int[] studioCapacity = {20, 20, 20, 20};
		String[] studioCouse = {"java", "webクリエーター", "動画", "グラフィック"};

		//ArrayListでスタジオ生成
		ArrayList<Studio> studios = new ArrayList<Studio>();
		for(int i = 0; i < studioName.length; i ++) {
			studios.add(new Studio(studioName[i], studioCapacity[i], studioCouse[i]));
		}
		displayStudio(studios);

		//ドリンク情報
		String[] drinkName = {// 名前
				"ウィルキンソン", "爽健美茶", "いろはす", "お～いお茶", "FIRE", "紅茶花伝", "おしるこ"
		};
		String[] drinkAffiliation = {// メーカー
				"アサヒ", "コカ・コーラ", "コカ・コーラ", "伊藤園", "キリン", "コカ・コーラ", "伊藤園"
		};
		int[] drinkCapacity = {// 内容量
				500, 525, 500, 1000, 185, 280, 185
		};
		int[] drinkPrice = {// 価格
				100, 160, 100, 140, 110, 120, 110
		};
		String[] drinkTemperatur = {// 温度
				"cold", "cold", "cold", "cold", "hot", "hot", "hot"
		};
		//ArrayListでドリンク生成
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		for(int i = 0; i < drinkName.length; i ++) {
			drinks.add(new Drink(drinkName[i], drinkAffiliation[i], drinkCapacity[i], drinkPrice[i], drinkTemperatur[i]));
		}
		displayDrink(drinks);


	}

	//表示メソッド
	public static void displayStudio(ArrayList<Studio> st) {
		for(int i = 0; i < st.size(); i ++) {
			System.out.println(st.get(i).getName() + ": " + st.get(i).getCouse() + ": " + st.get(i).getCapacity() + "名");
		}
	}

	//表示メソッド
	public static void displayDrink(ArrayList<Drink> dr) {
		for(Drink d : dr) {
			System.out.println("商品名：" + d.getName());
			System.out.println("メーカー：" + d.getAffiliation());
			System.out.println("内容量：" + d.getCapacity());
			System.out.println("価格：" + d.getPrice());
			System.out.println("温度：" + d.getTemperature());
		}
	}
}
