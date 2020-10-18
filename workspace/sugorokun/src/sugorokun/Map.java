package sugorokun;

public class Map {
	//フィールド
	private int iti;
	private int goal;

	//メソッド
	public int ibento(int iti) {
		String rslt = "何もおきない";
		System.out.print("イベント発生: ");
		int r = new java.util.Random().nextInt(2);
		if(r == 0) {
			iti += 5;
			rslt = "5進む";
		}else if(r == 1) {
			iti -= 5;
			rslt = "5戻る";
		}else {

		}
		System.out.println(rslt + "現在" + iti);
		return iti;
	}

	public void inNum(int iti) {
		this.iti += iti;
	}

	//セッター・ゲッター
	public int getIti() {
		return this.iti;
	}

	public void setIti(int iti) {
		this.iti = iti;
	}

	public int getGoal() {
		return this.goal;
	}

	//コンストラクタ
	public Map(int goal) {
		this.iti = 0;
		this.goal = goal;
	}

}
