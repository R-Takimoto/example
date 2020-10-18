package rps;

public class Player {

	String[] rps = {"グー","チョキ","パー"};
	String name; //player名
	int hand; //自分の手を表す0 1 2

	public Player(String name) {
		this.name = name;
	}

	public void showhand() {
		System.out.println(this.name+"の選んだ手は"+this.rps[this.hand]+"です。");
	}

}
