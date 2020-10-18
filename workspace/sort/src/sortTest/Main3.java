package sortTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main3 {

	public static void main(String[] args) {
		//生徒情報
		String[] name = {"山田", "田中", "植田", "松本", "木下"};
		int[] age = {30, 22, 35, 40, 29};

//		生徒を配列に生成
//		ArrayList<Student> st = new ArrayList<Student>();
//		for(int i = 0; i < name.length; i ++) {
//			st.add(new Student(name[i], age[i]));
//		}
//		Collections.sort(st, new StudentComparator());
//
//		displayArray(st);

		//連想配列で生成
		Map<String, Student> stt = new HashMap<String, Student>();
		for(int i = 0; i < name.length; i ++) {
			stt.put(name[i], new Student(name[i], age[i]));
		}
		displayMap(stt);


	}

	//表示メソッド
	public static void displayArray(ArrayList<Student> st) {
		for(int i = 0; i < st.size(); i ++) {
			System.out.print(st.get(i).getName() + ":" + st.get(i).getAge() + "歳" + " ");
		}
		System.out.println();
	}

	//表示メソッド(連想配列)
	public static void displayMap(Map<String, Student> m) {
		for(String nKey : m.keySet()) {
			System.out.print(m.get(nKey).getName() + ":" + m.get(nKey).getAge() + "歳" + " ");
		}
		System.out.println();
//		for(int i = 0; i < m.size(); i ++) {
//			System.out.print(m.get(n[i]).getName() + ":" + m.get(n[i]).getAge() + "歳" + " ");
//		}
//		System.out.println();
	}

}
