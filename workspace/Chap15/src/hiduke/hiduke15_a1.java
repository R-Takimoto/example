package hiduke;

import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.function.Function;

public class hiduke15_a1 {

    public static String dateTimeFormat(String format) {
        return dateTimeFormat(format, Function.identity());
    }

    public static String dateTimeFormat(String format, Function<ChronoLocalDateTime<JapaneseDate>, ChronoLocalDateTime<JapaneseDate>> modify) {
        return modify.apply(JapaneseDate.now().atTime(LocalTime.now())).format(DateTimeFormatter.ofPattern(format, Locale.JAPAN));
    }

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

        // 現在日時
        System.out.println(dateTimeFormat("uuuu/MM/dd(E) HH:mm:ss"));
        System.out.println(dateTimeFormat("Gy年M月d日(EEEE)H時m分s秒"));
        System.out.println(dateTimeFormat("GGGGGy.M.d"));
        // 今月の末日
        System.out.println(dateTimeFormat("uuuu/MM/dd(E)", d -> d.with(ChronoField.DAY_OF_MONTH, d.toLocalDate().lengthOfMonth())));
        // 一週間後
        System.out.println(dateTimeFormat("Gy年M月d日(E)", d -> d.plus(7, ChronoUnit.DAYS)));
        // 来月1日
        System.out.println(dateTimeFormat("GGGGGy.M.d", d -> d.with(ChronoField.DAY_OF_MONTH, 1).plus(1, ChronoUnit.MONTHS)));

	}

}
