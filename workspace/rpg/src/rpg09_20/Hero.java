package rpg09_20;

public class Hero {
	String name;
	char sex;
	int hp;  //HPの宣言


	public Hero(String namae, char se) {
		this.hp = 100;
		this.sex = se;
		this.name = namae;
	}

	public Hero() {
//		this.hp = 100;
//		this.name = "ななし";
		this("ななし", '男');
	}

	public void attack() {
		System.out.println(this.name  + "で攻撃した");
		System.out.println("敵に" + "のダメージをあたえた");
	}

	public void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した");
	}
	public void sit(int sec) {
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒座った！");
		System.out.println("HPが" + sec + "ポイント回復した");
	}
	public void slip() {
		this.hp -= 5;
		System.out.println(this.name + "は、転んだ！");
		System.out.println("5のダメージ");
	}
	public void run() {
		System.out.println(this.name + "は、逃げ出した！");
		System.out.println("GAMEOVER");
		System.out.println("最終HPは" + this.hp + "でした");
	}

}
