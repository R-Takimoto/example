package seiretu;

public class Kudamonoya {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Fruits f1 = new Fruits("peaches",100,1000);
		Fruits f2 = new Fruits("Twentieth century pear",10,1500);
		Fruits f3 = new Fruits("Shine muscat",20,900);


		System.out.printf("品名：%s 在庫数:%d 単価：%d\n", f1.getName(),f1.getZaiko(),f1.getTanka());
		System.out.printf("品名：%s 在庫数:%d 単価：%d\n", f2.getName(),f2.getZaiko(),f2.getTanka());
		System.out.printf("品名：%s 在庫数:%d 単価：%d\n", f3.getName(),f3.getZaiko(),f3.getTanka());

		System.out.printf("品名：%30s 在庫数:%5d 単価：%10d円\n", f1.getName(),f1.getZaiko(),f1.getTanka());
		System.out.printf("品名：%30s 在庫数:%5d 単価：%10d円\n", f2.getName(),f2.getZaiko(),f2.getTanka());
		System.out.printf("品名：%30s 在庫数:%5d 単価：%10d円\n", f3.getName(),f3.getZaiko(),f3.getTanka());

		System.out.printf("品名：%-30s 在庫数:%5d 単価：%,10d円\n", f1.getName(),f1.getZaiko(),f1.getTanka());
		System.out.printf("品名：%-30s 在庫数:%5d 単価：%,10d円\n", f2.getName(),f2.getZaiko(),f2.getTanka());
		System.out.printf("品名：%-30s 在庫数:%5d 単価：%,10d円\n", f3.getName(),f3.getZaiko(),f3.getTanka());



	}

}
