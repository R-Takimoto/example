package hiduke;

import java.util.Date;

public class hiduke15_11 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Date now = new Date();

		System.out.println("now:"+now);
		System.out.println("now.getTime():"+now.getTime());
		System.out.println("now.getYear():"+now.getYear());
		System.out.println("now.getMonth():"+now.getMonth());
		System.out.println("now.getDay():"+now.getDay());

		System.out.println("now.getHours():"+now.getHours());
		System.out.println("now.getMinutes():"+now.getMinutes());
		System.out.println("now.getSeconds():"+now.getSeconds());

		/*
		 * Dateオブジェクトは、標準出力によって日付表記となります。
		 * 上記の出力だけみても、getYear()の返戻値が1900からの経過年数
		 * として出力される
		 * getMonth()の返戻値が表す月数は0開始
		 * という粗悪な特徴を持つことが見て取れます。
		 *
		 * これらのget関数は今では非推奨となっていますが、
		 * getMonthに関してはDateのWrapperクラスであるCalendarですら同じ挙動
		 * を示します。
		 *
		 */


	}

}
