package rps;

public class RpsJudge {

	private int personal;//人間の手
	private int computer;//コンピューターの手

	public RpsJudge(int personal,int computer){
		this.personal = personal;
		this.computer = computer;
	}

	public void judge(){

		//じゃんけんの勝ち負けは「(自分の手 - 相手の手 + 3) % 3」の余り値で判断可能
		//0 = 引き分け、1 = 負け、2 = 勝ち

		int judgement = (personal - computer +3) % 3;
		String strJudgement;
		if(judgement == 0){
			strJudgement = "引き分けです。";
		} else if(judgement == 1){
			strJudgement = "コンピューターの勝ちです。";
		} else {
			strJudgement = "あなたの勝ちです";
		}

		System.out.println(strJudgement);
	}
}
