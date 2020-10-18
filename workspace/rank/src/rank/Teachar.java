package rank;

public class Teachar extends Human {
	//ここからフィールド

	//ここからメソッド
	//眠る
	public void sleep() {
		System.out.println(this.name + "先生は眠っている");
	}
	//教える
	public void teach(String kamoku) {
		if(this.name.equals("尾崎")) {
			if(!(kamoku.equals("Java"))) {
				System.out.println(this.name + "： えー、何かの手違いで本日の" + kamoku + "は私が担当いたします");
			}
		}else if(this.name.equals("紺田")) {
			if(!(kamoku.equals("HTML&CSS"))) {
				System.out.println(this.name + "： えー、何かの手違いで本日の" + kamoku + "は私が担当いたします");
			}
		}else if(this.name.equals("田淵")) {
			if(!(kamoku.equals("SQL"))) {
				System.out.println(this.name + "： えー、何かの手違いで本日の" + kamoku + "は私が担当いたします");
			}
		}
	}

	//ここからコンストラクタ
	public Teachar(String n, char s) {
		super(n, s);
	}
}
