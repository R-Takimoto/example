package sugorokun;

//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String rslt = "";
//		Scanner sc = new Scanner(System.in);
//		System.out.println("遊ぶ人数");
//		int numPeople;
//		try {
//			numPeople = sc.nextInt();
//		}catch(Exception e) {
//			System.out.println("era");
//		}
//		if(numPeople > 2) {
//			if(numPeople == 3) {
//		}

		Prayer p1 = new Prayer("えもち", 6, 50);
		Prayer p2 = new Prayer("comタニガワ", 6, 50);
		do {
			//第1プレイヤー
			p1.action(p1.getName(), p1.getDice(), p1.getMap());
			if(p1.getMap().getIti() >= p1.getMap().getGoal()) {
				rslt = p1.getName();
				break;
			}else if(p1.getMap().getIti() % 5 == 0) {
				p1.getMap().ibento(p1.getMap().getIti());
			}
			//第2プレイヤー
			p2.action(p2.getName(), p2.getDice(), p2.getMap());
			if(p2.getMap().getIti() >= p2.getMap().getGoal()) {
				rslt = p2.getName();
				break;
			}else if(p2.getMap().getIti() % 5 == 0) {
				p2.getMap().ibento(p2.getMap().getIti());
			}
		}while(true);

		System.out.println(rslt + "がゴール");
	}

}