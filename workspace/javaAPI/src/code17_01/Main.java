package code17_01;

import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter("data.txt");
//			fw.write("テスト");
//		}catch(IOException e) {
//			System.out.println("エラー" + e.getMessage());
//			e.printStackTrace();
//		}finally {
//			if(fw != null) {
//				try {
//					fw.close();
//				}catch(IOException e) {
//					;
//				}
//			}
//		}
		try(FileWriter fw = new FileWriter("data.txt");) {
			fw.write("hello");
		}catch(Exception e) {
			System.out.println("なんかしらのエラー");
		}

		Sample sm = new Sample();
		try {
			sm.subsub();
		}catch(Exception e) {
			;
		}


	}

}
