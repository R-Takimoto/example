package Reg;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("--- Stringクラスのmatchesメソッド Start ---");

	       // 検索する文字列を用意
        String str = "東京都千代田区 123-4567";

        System.out.println(str.matches(".*[0-9]{3}-[0-9]{4}.*"));
        System.out.println(str.matches("[0-9]{3}-[0-9]{4}"));

        System.out.println(str.matches(".*123-4567.*"));
        System.out.println(str.matches("123-4567"));

		System.out.println("--- Stringクラスのmatchesメソッド End ---");


		System.out.println("--- 正規表現のパターン Start ---");

        // 正規表現のパターンを作成
        Pattern p = Pattern.compile("[0-9]{3}-[0-9]{4}");
        Matcher m = p.matcher(str);

        System.out.println(m.find());

		System.out.println("--- 正規表現のパターン End ---");


		System.out.println("--- 正規表現のパターン 一致文字抽出 Start ---");
        // 正規表現のパターンを作成
        //p = Pattern.compile("[0-9]{3}-[0-9]{4}");
        m = p.matcher(str);
        while (m.find()) {
            System.out.println("一致した部分は : " + m.group());
        }

		System.out.println("--- 正規表現のパターン 一致文字抽出 End ---");


		System.out.println("--- 数値チェック Start ---");
        // 検索する文字列を用意
        str = "123";
        System.out.println(str.matches("^[0-9]+$"));
		System.out.println("--- 数値チェック End ---");



    }

}
