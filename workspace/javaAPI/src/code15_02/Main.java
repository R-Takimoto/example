package code15_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  throws Exception {
		ArrayList<String> li = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("何か話しかけてください");
			String in = sc.nextLine();

			if(in.equals("さよなら")) {
				break;
			}else if(li.contains(in)){
				System.out.println("聞いた");
			}else {
				System.out.println(in);
				li.add(in);
			}

		}while(true);
		sc.close();

		System.out.println("ＢＹＥ！");


	}

}
