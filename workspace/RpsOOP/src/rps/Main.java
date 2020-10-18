package rps;

public class Main {

	public static void main(String[] args) {
		//コンピューターとじゃんけんゲーム

		//ゲーム開始を画面に出力します。
		System.out.println("じゃんけんゲームを行います。");
		System.out.println("何を出しますか？");

		//Player1(自分自身)
		HumanPlayer hp = new HumanPlayer("私");
		//自分の手を表示
		hp.showhand();

		//Player2(コンピューター)
		ComputerPlayer cp = new ComputerPlayer("コンピューター");
		//コンピューターの手を表示
		cp.showhand();

		//判定を行います
		RpsJudge rj = new RpsJudge(hp.hand, cp.hand);
		rj.judge();


	}
}
