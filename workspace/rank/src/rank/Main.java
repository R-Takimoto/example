package rank;

public class Main {

	public static void main(String[] args) {
		//1組
		Student n01 = new Student("川崎 康史", '男');
		Student n02 = new Student("國森 ななほ", '女');
		Student n03 = new Student("城野 敦士", '男');
		Student n04 = new Student("谷川 拓馬", '男');
		Student n05 = new Student("坂口 瑠衣", '女');
		//2組
		Student n06 = new Student("浜田 明彦", '男');
		Student n07 = new Student("滝本 亮", '男');
		Student n08 = new Student("神 福幸子", '女');
		Student n09 = new Student("江本 愛美", '女');
		Student n10 = new Student("川嵜 瞳", '女');


		Student[] s1 = resultRank(n01, n02, n03, n04, n05);
		Student[] s2 = resultRank(n06, n07, n08, n09, n10);

		rankPrint(s1, s2);
	}

	//ここからメソッド
	//生徒の3科目を合計する
	public static void totalSubject(Student[] st) {
		for(int i = 0; i < st.length; i ++) {
			int total = 0;
			total += st[i].java;
			total += st[i].sql;
			total += st[i].html;
			st[i].total = total;
		}
	}

	//渡した生徒の合計得点で降順にする
	public static Student[] resultRank(Student... st) {
		totalSubject(st); //受け取った生徒の科目を合計する
		for(int i = 0; i < st.length - 1; i ++) { //選択ソート(降順)
			int num = st[i].total; //仮の最大数を定義
			int index = i; //仮の最大数が入ってるindexを定義
			for(int j = i + 1; j < st.length; j ++) {
				if(num < st[j].total) { //仮の最大数より大きい数があるか確認
					num = st[j].total; //trueなら仮の中を入れ替える
					index = j;
				}
			}
			Student n = st[i]; //確認処理後0番目から順に入れ替えていく
			st[i] = st[index];
			st[index] = n;
		}

		return st;
	}

	//渡した配列内の生徒を順次出力
	public static void rankPrint(Student[]... st) {
		for(int i = 0; i < st.length; i ++) {
			for(int j = 0; j < st[i].length; j ++) {
				System.out.println((j + 1) + ". " + st[i][j].name + " / " + st[i][j].total + "点");
			}
		}
	}



}




