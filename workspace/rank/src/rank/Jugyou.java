package rank;

public class Jugyou {

	//メソッド
	public static void java(Teachar t, Student[] st) {
		System.out.println(t.name + "： 起立");
		System.out.println(t.name + "： 礼");
		System.out.println("生徒" + "： よろしくお願い致します");
		String kamoku = "Java";
		t.teach(kamoku);

	}

}
