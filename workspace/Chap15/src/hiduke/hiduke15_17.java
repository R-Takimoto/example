package hiduke;

import java.time.LocalDate;
import java.time.Period;

public class hiduke15_17 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	    LocalDate d1 = LocalDate.of(2020,1,1);
	    LocalDate d2 = LocalDate.of(2020,1,4);

	    System.out.println("d1=" + d1 + " d2=" + d2);

	    // 3日間を表すPeriodを2通りの方法で生成
	    Period p1 = Period.ofDays(3);
	    Period p2 = Period.between(d1, d2);

	    System.out.println("p1=" + p1 + " p2=" + p2);

	    // d2のさらに3日後を計算する
	    LocalDate d3 = d2.plus(p2);
	    System.out.println("d2=" + d2 + " d3=" + d3);

	}

}
