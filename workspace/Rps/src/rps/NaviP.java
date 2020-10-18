package rps;

public class NaviP extends Navi {
	//コンストラクタ
	public NaviP(String name) {
		super(name);
		try {
			this.num =  new java.util.Scanner(System.in).nextInt();
		}catch(Exception e) {
			System.out.println("えらー");
			System.exit(0);
		}
	}

	//メソッド
	public void shake() {
		this.num =  new java.util.Scanner(System.in).nextInt();
	}
}
