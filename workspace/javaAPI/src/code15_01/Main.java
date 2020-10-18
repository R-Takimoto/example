package code15_01;

public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
//		for(int i = 1; i < 101; i ++) {
//			sb.append(i + ",");
//		}
//		String s =  sb.toString();
//
//		System.out.println(s);
//
//		String[] ar = s.split("[,]");
//		for(String ss : ar) {
//			System.out.println(ss);
//		}

		String fol = "java";
		String fil = "readme.txt";
		sb.append(fol + fil);
		String s = sb.toString();
		System.out.println(s);
	}
	//メソッド
	public static String st() {
		String sss = "^[c]:\\[.*]\\[.*]";
		return sss;
	}


}
