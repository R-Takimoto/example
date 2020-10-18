package read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\S1-06\\Desktop\\fruit.txt");

			if(checkBeforeReadfile(file)) {
				BufferedReader br = new BufferedReader(new FileReader(file));

				String str;
				ArrayList<Fruit> f = new ArrayList<Fruit>();
				int counter = 0;
				while((str = br.readLine()) != null) {


					String[] fwk = str.split(",", 0);
					Fruit f1 = new Fruit(fwk[0], Integer.parseInt(fwk[1].trim()), Integer.parseInt(fwk[2].trim()));

					f.add(f1);
//					System.out.println(f.get(counter).getName());
					counter ++;
				}
				br.close();

//				display(f);


//				FileWriter fw = new FileWriter("C:\\Users\\S1-06\\Desktop\\kakidasi.txt");
//				PrintWriter pw = new PrintWriter(fw);
//
//				out(f, pw);

//				pw.close();
				int c = 0;
				boolean flg = true;
				do {
					for(int i = 0; i < 2; i ++) {
						try {
							if(c == 2) {
								flg = true;
								continue;
							}
							Scanner sc = new Scanner(System.in);
							String name = "";
							do {
								System.out.println("果物名称");
								name = sc.nextLine();
							}while(name.length() < 2 || name.length() >= 10);
							System.out.println("在庫");
							int zaiko = sc.nextInt();
							System.out.println("価格");
							int price = sc.nextInt();
							f.add(new Fruit(name, zaiko, price));
							c ++;
						}catch(Exception e) {
							System.out.println("とめます");
							continue;
//							System.exit(0);
						}
					}
				}while(flg);



				display(f);

			}else {
				System.out.println("ファイルが見つかりません");
			}
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}

	}

	public static void display(ArrayList<Fruit> f) {
		for(Fruit ff : f) {
			System.out.println("名称：" + ff.getName());
			System.out.println("在庫数：" + ff.getZaiko());
			System.out.println("価格：" + ff.getPrice());
			System.out.println();
		}
	}

	public static void out(ArrayList<Fruit> ff, PrintWriter pw) {
		for(Fruit f : ff) {
			String format = String.format("%s,%d,%d", f.getName(), f.getZaiko(), f.getPrice());
			pw.println(format);
		}
		System.out.println("完了");

	}

	private static boolean checkBeforeReadfile(File file) {
		if(file.exists()) {
			if(file.isFile() && file.canRead()) {
				return true;
			}
		}

		return false;
	}

}
