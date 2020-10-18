package example;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\S1-06\\Desktop\\sample");


		File[] st = file.listFiles();

		System.out.println(st[1].list());
	}

}
