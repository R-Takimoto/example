package hiduke;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class hiduke15_15 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	    // LocalDateTimeの生成方法
	    LocalDateTime l1 = LocalDateTime.now();
	    LocalDateTime l2 = LocalDateTime.of(2020, 9, 9, 9, 5, 0, 0);

	    System.out.println("i1=" + l1 + " i2=" + l2);

	    // LocalDateTimeとZoneDateTimeの相互変換
	    ZonedDateTime z1 = l1.atZone(ZoneId.of("Europe/London"));
	    ZonedDateTime z3 = l1.atZone(ZoneId.of("Asia/Tokyo"));
	    LocalDateTime l3 = z1.toLocalDateTime();

	    System.out.println("z1=" + z1 + " z3=" + z3);

	}

}
