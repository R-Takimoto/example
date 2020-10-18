package rps;

public class HumanPlayer extends Player{

	public HumanPlayer(String name) {
		super(name);
		this.showRule();
		this.hand =  new java.util.Scanner(System.in).nextInt();
	}

	public void showRule() {
		System.out.println("グー：0 チョキ：1 パー：2");
		System.out.println("数字を入力してください");
	}

}
