package mojiretu;

public class StringTest02 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		String s1 = "Java and JavaScript";

		if( s1.contains("Java") ) {
			System.out.println("文字列s1は、Javaを含んでいます。");
		}

		if( s1.endsWith("Java") ) {
			System.out.println("文字列s1は、Javaが末尾にあります。");
		}

		System.out.println("文字列s1で最初にJavaが登場するのは、" +
			s1.indexOf("Java") );

		System.out.println("文字列s1で最後にJavaが登場するのは、" +
			s1.lastIndexOf("Java") );



	}

}
