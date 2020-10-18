package rps;

public class Main {

	public static void main(String[] args) {
		//コンピューターとじゃんけんゲーム

		//ゲーム開始を画面に出力します。
		System.out.println("じゃんけんゲームを行います。");
		System.out.println("何を出しますか？");

		//ルールを説明します。
		System.out.println("グー：0 チョキ：1 パー：2");
		System.out.println("数字を入力してください");

		NaviC c = new NaviC("コンピュータ");
		NaviP p = new NaviP("プレイやー");


		p.out(p.num);
		c.out(c.num);
		//じゃんけんの要素を配列型データに格納
		String[] rps = {"グー","チョキ","パー"};

		//入力を求めます。入力値を変数に格納。
		int personal = 0;
		boolean flg = false;
		do {
			flg = true;
			try {
				personal = new java.util.Scanner(System.in).nextInt();
			}catch(Exception e) {
				System.out.println("えらーーーーーーー");
				flg = true;
			}
		}while(flg);

		//入力された内容を画面に出力します。
		String personalHand = null;
		try {
			personalHand = rps[personal];
			System.out.println("あなたは"+personalHand+"を選びました。");
		}catch(Exception e) {
			System.out.println("えら");
		}


		//コンピューターの手を乱数で決めます。生成した乱数を変数に格納。
		int computer = new java.util.Random().nextInt(3);
		String computerHand = rps[computer];
		System.out.println("コンピューターは"+computerHand+"を選びました");

		//判定を行います
		RpsJudge rj = new RpsJudge(c.num,p.num);
		rj.judge();


	}
}
