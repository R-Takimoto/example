package mojiretu;

public class StringTest03 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		String s1 = "Java programming";

		System.out.println("文字列s1の４文字目以降は、++" +
				s1.substring(4) + "++") ;

		System.out.println("文字列s1の４～７文字は、++" +
				s1.substring(4,8) + "++") ;

		System.out.println("文字列s1を小文字では、++" +
				s1.toLowerCase() + "++") ;

		System.out.println("文字列s1を大文字は、++" +
				s1.toUpperCase() + "++") ;

		System.out.println("文字列s1のprogrammingをstudyに変更すると、++" +
				s1.replace("programming","study") + "++") ;


		String s2 = "      Java programming      ";

		System.out.println("文字列s2の空白を除くと、++" + s2.trim() + "++") ;
		/*
		System.out.println("文字列s2の左空白を除くと、++" + s2.ltrim() + "++") ;
		System.out.println("文字列s2の右空白を除くと、++" + s2.rtrim() + "++" ) ;
		*/

		String s3 = "　　　Java programming　　　";

		System.out.println("文字列s3の全角空白を除くと、++" + s3.trim() + "++") ;
		/* java11
		System.out.println("文字列s3の全角空白を除くと、++" + s3.strip() + "++") ;
		*/

	}

}
