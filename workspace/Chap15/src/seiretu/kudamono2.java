package seiretu;

import java.nio.charset.Charset;

public class kudamono2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Fruits f1 = new Fruits("peaches",100,1000);
		Fruits f2 = new Fruits("Twentieth century pear",10,1500);
		Fruits f3 = new Fruits("Shine muscat",20,900);


		System.out.printf("品名：%-30s 在庫数：%5d 単価：%,10d円\n", f1.getName(),f1.getZaiko(),f1.getTanka());
		System.out.printf("品名：%-30s 在庫数：%5d 単価：%,10d円\n", f2.getName(),f2.getZaiko(),f2.getTanka());
		System.out.printf("品名：%-30s 在庫数：%5d 単価：%,10d円\n", f3.getName(),f3.getZaiko(),f3.getTanka());


		Fruits f4 = new Fruits("柿",4,1100);

		//ずれないformat文
        System.out.print("品名：");
        System.out.print(forma(f4.getName(), 30));
        System.out.print(" 在庫数：");
        System.out.print(forma(String.format("%5d",f4.getZaiko()), 5));
        System.out.print(" 単価：");
        System.out.println(forma(String.format("%,10d円",f4.getTanka()), 10));


		Fruits f5 = new Fruits("さくらんぼ",40,11000);

        System.out.print("品名：");
        System.out.print(forma(f5.getName(), 30));
        System.out.print(" 在庫数：");
        System.out.print(forma(String.format("%5d",f5.getZaiko()), 5));
        System.out.print(" 単価：");
        System.out.println(forma(String.format("%,10d円",f5.getTanka()), 10));

	}


    private static String forma(String target, int length){
        int byteDiff = (getByteLength(target, Charset.forName("UTF-8"))-target.length())/2;
        return String.format("%-"+(length-byteDiff)+"s", target);
    }

    private static int getByteLength(String string, Charset charset) {
        return string.getBytes(charset).length;
    }

}
