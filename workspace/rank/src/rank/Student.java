package rank;

import  java.util.Random;

public  class Student extends Human {
	//ここからフィールド
	int java;
	int sql;
	int html;
	int total;

	//ここからメソッド
	//居眠り
	public void sleep() {
		System.out.println(this.name + "は居眠りしている");
		int n = new java.util.Random().nextInt(2);
		int m = new java.util.Random().nextInt(3) + 1;
		if(n == 0) {
			this.java -= m;
			System.out.println("");
		}else if(n == 1) {
			this.sql -= m;
		}else if(n == 2) {
			this.html -= m;
		}
	}

	//ここからコンストラクタ
	public Student(String n,char s) {
		super(n,s);
		Random ra = new Random();
		this.java = ra.nextInt(100);
		this.sql = ra.nextInt(100);
		this.html = ra.nextInt(100);
	}
}
