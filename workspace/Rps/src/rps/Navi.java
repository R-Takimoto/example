package rps;

public class Navi {
	String name;
	String[] rps = {"グー","チョキ","パー"};
	int num;

	public Navi(String name) {
		this.name  =  name;
	}

	public void out(int n) {
		try {
			String personalHand = rps[n];
			System.out.println(this.name + "は、" +personalHand+"を選びました。");
		}catch(Exception e) {
			System.out.println("え－－－－－－－－");
			System.exit(0);
		}
	}

}
