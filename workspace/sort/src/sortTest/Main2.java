package sortTest;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 {

	public static void main(String[] args) {
		ArrayList<Integer> num = createArray();

		System.out.println("配列生成");
		displayArray(num);

		System.out.println("並べ替えスタート");
		Collections.sort(num);
//		for(int i = 0; i < num.size() - 1; i ++) {
//			System.out.println((i + 1) + "周目");
//			for(int j = i + 1; j < num.size(); j ++) {
//				if(num.get(i) > num.get(j)) {
//					int n = num.get(j);
//					num.set(j, num.get(i));
//					num.set(i, n);
//				}
//				displayArray(num);
//			}
//		}

		System.out.println("並べ替え後");
		displayArray(num);


	}

	//配列生成メソッド
	public static ArrayList<Integer> createArray() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for(int i = 0; i < 10; i ++) {
			int r = new java.util.Random().nextInt(100);
			numbers.add(r);
		}

		return numbers;
	}

	//配列表示メソッド
	public static void displayArray(ArrayList<Integer> n) {
		for(int val : n) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}
