package sugorokun;

import java.util.Scanner;

public class Prayer {
	//フィールド
	private String name;
	private Dice dice;
	private Map map;

	//メソッド
	public void action(String name, Dice dice, Map map) {
		int num = 0;
		int deme = this.dice.getNum();
		if(!(name.contains("com"))) {
			System.out.println("エンター");
			Scanner sc = new java.util.Scanner(System.in);
			String input;
			try {
				input = sc.nextLine();
			}catch(Exception e) {
				System.out.println("エラー");
				System.exit(0);
			}
		}

		num = new java.util.Random().nextInt(deme) + 1;
		this.map.inNum(num);
		System.out.println(this.name + "は" + num + "進んだ。現在"+ this.map.getIti());

	}




	//セッター・ゲッター
	public String getName() {
		return this.name;
	}

	public Dice getDice() {
		return this.dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public Map getMap() {
		return this.map;
	}

	public void setMap(Map map) {
		this.map = map;
	}



	//コンストラクタ
	public Prayer(String name, int dice, int goal) {
		this.name = name;
		this.dice = new Dice(dice);
		this.map = new Map(goal);
	}

}
