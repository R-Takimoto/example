package game;

import java.util.Scanner;

public class Slot extends Game{
	//フィールド
	String gName = "スロットゲーム";

/////////////////////////////////////////////////////////////////////////////////////////
	//メソッド
	public  int start(int pm) {//トリガー
		// ゲームナビ
		System.out.println("1ゲームで3回まわして遊ぶよ。");
		System.out.println("1回転でランダムな数字が3つ出ます。");
		System.out.println("数字が3つ共そろえばアタリ！掛金の2倍が配当されます。");
		System.out.println("もし、3揃いなら3倍です！");
		for(int i = 1; i < 4; i ++) {
			System.out.println("~" + i + "ゲーム目~");
			System.out.println("あなたの所持金: " + pm + "円");

			//賭金処理 START
			int stake = inStake(pm);
			pm -= stake;

			// スロット回転処理 START
			int haitou = game(stake);

			//リザルト処理 START
			int rsl = super.rslt(haitou, stake);
			pm += rsl;
		}

		return pm;
	}
/////////////////////////////////////////////////////////////////////////////////////////
	//回転処理メソッド
	public  int game(int stake) {
		int[] drm = new int[3]; // スロットリールを作る
		String rsl = "ハズレ"; // 結果出力用の変数
		int haitou = 0; //配当金を合算する変数
		for(int i = 0; i < 3; i ++) {
			drm[i] = new java.util.Random().nextInt(3) + 1; //リール回転
		}
		if(drm[0] == drm[1] && drm[0] == drm[2]) {
			if(drm[0] == 3) {
				rsl = "大当たり";
				haitou = stake * 3;
			}else {
				rsl = "当たり";
				haitou = stake * 2;
			}
		}else {
			rsl = "ハズレ";
			haitou = stake * 0;
		}

		for(int val : drm) {
			System.out.print(val);
		}
		System.out.print("\n");//改行
		System.out.println(rsl  + "!"); //結果出力

		return haitou;
	}
///////////////////////////////////////////////////////////////////////////////////
	//賭け金処理
	public  int inStake(int pm) {
//		Scanner sc = new Scanner(System.in);
		int money = 0;
		boolean flg = true;

		while(flg) {
			try {
				while(flg) {
					System.out.println("BETは100円からでお願いします。");
					money =  new Scanner(System.in).nextInt();
					if(100 > money) {
						System.out.println("最低BETは100円からです");
					}else if(money >= pm){
						System.out.println("所持金が足りません。");
						System.out.println("再入力をお願いします。");
					}else {
						flg = false;
					}
				}
			}catch(Exception e) {
				System.out.println("なんかしらのエラー");
				flg = false;
			}
		}
		return money;
	}
	////////////////////////////////////////////////////////////////////////
	//コンストラクタ
	public Slot() {

	}

}
