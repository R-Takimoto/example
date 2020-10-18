package Reg15_5;

public class Reg15_5 {

	  public static boolean isValidPlayerName(String name) {
		    if (name.length() != 8) {
		      return false;
		    }
		    char first = name.charAt(0);
		    if (!(first >= 'A' && first <= 'Z')) {
		      return false;
		    }
		    for (int i = 1; i < 8; i++) {
		      char c = name.charAt(i);
		      if (!((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
		        return false;
		      }
		    }
		    return true;
		 }

	  public static boolean isValidPlayerName2(String name) {
		    return name.matches("[A-Z][A-Z0-9]{7}");
		  }

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		String p1="A2345678";

		if( isValidPlayerName(p1) ) {
			System.out.println(p1+" OK");
		}else {
			System.out.println(p1+" OUT");
		}

		if( isValidPlayerName2(p1) ) {
			System.out.println(p1+" OK");
		}else {
			System.out.println(p1+" OUT");
		}

		String p2="a2345678";

		if( isValidPlayerName(p2) ) {
			System.out.println(p2+" OK");
		}else {
			System.out.println(p2+" OUT");
		}

		if( isValidPlayerName2(p2) ) {
			System.out.println(p2+" OK");
		}else {
			System.out.println(p2+" OUT");
		}


	}




}
