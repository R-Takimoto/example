package juice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Drink[]  fukuro = vending(500);

		System.out.println("購入品は");
		for(Drink val : fukuro) {
			System.out.println(val.name);
		}
	}

	//自販機メソッド
	public static Drink[] vending(int money) {
		//商品定義
		Drink orange = new Drink("オレンジジュース", 120);
		Drink apple = new Drink("りんごジュース", 120);
		Drink wilkinson = new Drink("ウィルキンソン", 110);
		Drink iemon = new Drink("伊右衛門", 130);
		Drink brackCurrantOrange = new Drink("カシスオレンジ", 220);
		Drink beer = new Drink("ビール", 300);
		Drink wine = new Drink("ワイン", 500);
		//商品を配列に入れる
		Drink[] ar = {orange, apple, wilkinson, iemon, brackCurrantOrange, beer, wine};

		//ここから処理開始
		boolean flg; //フラッグ処理用
		ArrayList<Drink> purchasedGoods = new java.util.ArrayList<Drink>();//購入品を入れる仮の箱
		ArrayList<Drink> offerProduct = new java.util.ArrayList<Drink>(); //入金額から購入可能な商品を選別する箱
		do { //フラッグ処理
			flg = false;
			offerProduct.clear(); //リスト内を0にする
			for(int i = 0; i < ar.length; i ++) { //箱に購入可能品を入れる処理
				if(money >= ar[i].price) {
					offerProduct.add(ar[i]);
				}
			}
			Scanner sc = new Scanner(System.in); //スキャナー型でインスタンス化
			int num = -1; //商品選択用
			do {
				if(num == -1) {
					System.out.println("商品を番号でお選び下さい");
				}else {
					System.out.println("商品左記の番号で入力してください");
				}

				for(int i = 0; i < offerProduct.size(); i ++) { //購入可能品の表示
					System.out.println(i + "： " + offerProduct.get(i).name + " " + offerProduct.get(i).price + "円");
				}

				num = sc.nextInt(); //商品を選んでもらう
				sc.nextLine(); // 改行文字の回収

			}while(num > offerProduct.size()); //入力値が不正の場合繰り返す

			System.out.println(offerProduct.get(num).name + "を購入"); //購入品を決定
			money -= offerProduct.get(num).price; //投入金額から購入金額を引く
			purchasedGoods.add(offerProduct.get(num));//購入品を仮の箱へ入れる
			System.out.println("残金" + money + "円");

			String yn; //yes,no判定用
			if(money >= 110) { //連続購入処理
				do {
					System.out.println("引き続き購入しますか？");
					System.out.println("y/n");
					yn = sc.nextLine(); //yかnか
				}while(!(yn.equals("y") || yn.equals("n")));
			}else {
				yn = "n";
			}

			if(yn.equals("y")) { //最終フラッグ判定
				flg = true;
			}else {
				sc.close();//よくわからん
			}
		}while(flg);
		int total = purchasedGoods.size();
		Drink[] rt = new Drink[total];
		for(int i = 0; i < rt.length; i ++) {
			rt[i] = purchasedGoods.get(i);
		}
		System.out.println("ありがとうございました。");

		return rt;
	}

}
