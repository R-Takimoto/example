package examle;

public class Cleric {
	String name;
	int hp;
	int mp;
	final int maxHp;
	final int maxMp;


	public Cleric() {
		this.maxHp = 50;
		this.maxMp = 10;
		this.mp = 10;
	}

	public void selfAid() {
		this.mp -= 5;
		System.out.println(this.name + "は、セルフエイドを唱えた");
		this.hp = 50;
		System.out.println("現在のHPは" + this.hp);
		System.out.println("現在のMPは" + this.mp);
	}

	public int pray(int sec) {
		int kaifuku = 0;
		int kaifukusitai = 0;
		kaifuku += sec + new java.util.Random().nextInt(3);
		kaifukusitai = this.maxMp - this.mp;
		int rt = Math.min(kaifuku, kaifukusitai);

		return rt;
	}
}
