package game;

public abstract class Game {
	//フィールド
	private String gName; //GAME名

/////////////////////////////////////////////////////////////////////////////////////////
	//メソッド
	public int rslt(int haitou, int stake) { //リザルト処理
		int rslt = haitou - stake;
		if(rslt >= 1) {
			System.out.println("おめでとうございます！");
			System.out.println(rslt + "円！の勝利です！");
		}else {
			System.out.println("残念！また来て欲しいカモ！");
			rslt = 0;
		}

		return rslt;
	}

	abstract public int inStake(int pm); //賭け金の選定

	abstract public int game(int stake); //GAME内容

	abstract public int start(int pm); //トリガー

//////////////////////////////////////////////////////////////////////////////////////
	//セッター・ゲッター
	public String getGName() {
		return this.gName;
	}
////////////////////////////////////////////////////////////////////////////////////////////
	//コンストラクタ
	public Game() {

	}
}
