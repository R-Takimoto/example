import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 17);
		Date d = new Date();
		System.out.println(d);
	}
}
