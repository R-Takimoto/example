package sortTest;

import java.util.Comparator;

public class Student implements Comparator<Student> {
	//フィールド
	private String name;
	private int age;


	//メソッド
	public int compare(Student s1, Student s2) {
		return s1.getAge() < s2.getAge() ? -1 : 1;
	}

	//ゲッター
	public String getName() {
		return this.name;
	}


	public int getAge() {
		return this.age;
	}


	//コンストラクタ
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}



}
