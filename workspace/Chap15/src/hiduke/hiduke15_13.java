package hiduke;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class hiduke15_13 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		SimpleDateFormat f =
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Date now = new Date();
		String s = f.format(now);

		System.out.println("現在は：" + s );

		f = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		s = f.format(now);
		System.out.println("現在は：" + s );


		 //現在日時の取得
		  Date d = new Date();


		//日本のロケールを作成
		  Locale japan = new Locale("ja","JP","JP");

		  //書式の作成
		  SimpleDateFormat sdf = new SimpleDateFormat("GGGGy年 MM月 dd日 EEEE a hh時 mm分 ss秒",japan);

		  //指定書式に変換して表示
		  System.out.println(sdf.format(d));

	}

}
