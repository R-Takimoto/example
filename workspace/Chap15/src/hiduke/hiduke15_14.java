package hiduke;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class hiduke15_14 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	    // Instantの生成
	    Instant i1 = Instant.now();
	    System.out.println("i1=" + i1) ;

	    // Instantとlong値との相互変換
	    Instant i2 = Instant.ofEpochMilli(1600705425827L);
	    System.out.println("i2=" + i2) ;

	    long l = i2.toEpochMilli();



	    ZonedDateTime z2 = ZonedDateTime.of(2020, 1, 2, 3, 4, 5, 6, ZoneId.of("Asia/Tokyo"));

	    // InstantとZoneDateTimeの相互変換
	    Instant i3 = z2.toInstant();
	    ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

	    // ZonedDateTimeの利用方法
	    System.out.println("東京:" + z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
	    System.out.println("ロンドン:" + z3.getYear() + z3.getMonth() + z3.getDayOfMonth());
	    if(z2.isEqual(z3)) {
	      System.out.println("これらは同じ瞬間を指しています");
	    }


	    // ZonedDateTimeの生成方法
	    ZonedDateTime z1 = ZonedDateTime.now();
	    System.out.println("z1=" + z1) ;

	    // InstantとZoneDateTimeの相互変換
	    Instant i4 = z1.toInstant();
	    ZonedDateTime z4 = i4.atZone(ZoneId.of("Europe/London"));

	    // ZonedDateTimeの利用方法
	    System.out.println("東京:" + z1.getYear() + z1.getMonth() + z1.getDayOfMonth());
	    System.out.println("ロンドン:" + z4.getYear() + z4.getMonth() + z4.getDayOfMonth());
	    if(z1.isEqual(z4)) {
	      System.out.println("これらは同じ瞬間を指しています");
	    }

	}

}
