package hiduke;

import java.util.Calendar;
import java.util.Date;

public class hiduke15_12 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Calendar c = Calendar.getInstance() ;

		c.set(2020,8,8,18,0,0);

		Date d = c.getTime();
		System.out.println("d=" + d );

		Date now = new Date() ;
		c.setTime(now);


		System.out.println("year=" + c.get(Calendar.YEAR) );
		System.out.println("month=" + c.get(Calendar.MONTH) );
		System.out.println("day=" + c.get(Calendar.DAY_OF_MONTH) );




	}

}
