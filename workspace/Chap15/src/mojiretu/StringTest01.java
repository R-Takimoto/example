package mojiretu;

public class StringTest01 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		String s1 = "スッキリJava";
		String s2 = "Java";
		String s3 = "java";



		if( s2.equals(s3) ) {
			System.out.println("s2とs3は等しい。");
		}

		if( s2.equalsIgnoreCase(s3) ) {
			System.out.println("s2とs3はケースを区別しなければ等しい。");
		}

		System.out.println("s1の長さは"+s1.length()+"です。");

		if( s1.isEmpty() ) {
			System.out.println("s1は空文字です。");
		}


		String s4 = "";
		String s5 = null ;

		if( s4.isEmpty() ) {
			System.out.println("s4は空文字です。");
		}
/*
		if( s5.isEmpty() ) {
			System.out.println("s5はnullです。");
		}
*/
		if( s5 == null ) {
			System.out.println("s5はnullです。");
		}

	}

}
