package model;

import java.util.Date;

public class Edit {
	//処理状態の確認------------------------------------------------------------------------------------------
	public boolean confirmFinished() {
		boolean judge = false;//return
		System.out.println("タスクは完了しましたか？");
		String navString = "1:Yes 2:No";
		int navPattern = 2;
		int judgeNum = 0;
		judgeNum = CommonLogic.choiceCommandPattern(navPattern, navString);
		if(judgeNum == 1) {
			judge = true;
		}else if(judgeNum == 2) {
			judge = false;
		}else {
			System.out.println("予期せぬ");
			System.exit(0);
		}
		return judge;
	}
	//処理状態の変更----------------------------------------------------------------------------------------
	public void editTodoFinished(TodoFolder todoFolder, int editNum, boolean finished) {
		int ListNum = editNum - 1;
		if(finished) {
			todoFolder.getTodos().get(ListNum).setFinished(finished);
			System.out.println("こんぐらちゅれーしょん！！！");
		}else {
			todoFolder.getTodos().get(ListNum).setFinished(finished);
			System.out.println("一つずつこなしていこう！");
		}
	}
	//変更期限の確認--------------------------------------------------------------------------------------
	public Date confirmLimit() {
		Resistration resistration = new Resistration();
		Date limit = resistration.standardInputLimit();
		return limit;
	}
	//期限変更の最終確認-----------------------------------------------------------------------------------
	public boolean checkEditLimit(Date limit) {
		boolean judge = false;
		String limitF = CommonLogic.conversionDateToString(limit);
		System.out.println(limitF);
		System.out.println("上記期限に変更しますか？");
		String navString = "1:Yes 2:No";
		int navPattern = 2;
		int judgeNum = 0;
		judgeNum = CommonLogic.choiceCommandPattern(navPattern, navString);
		if(judgeNum == 1) {
			judge = true;
		}else if(judgeNum == 2) {
			judge = false;
		}else {
			System.out.println("予期せぬ");
			System.exit(0);
		}
		return judge;
	}
	//期限の変更-------------------------------------------------------------------------------------------
	public void editLimit(TodoFolder todoFolder, int editNum, Date limit) {
		int ListNum = editNum - 1;
		todoFolder.getTodos().get(ListNum).setLimit(limit);
	}
	//変更優先度の確認-------------------------------------------------------------------------------------
	public int confirmPrioritye() {
		Resistration resistration = new Resistration();
		int prioritye = resistration.standardInputPrioritye();
		return prioritye;
	}
	//優先度変更の最終確認----------------------------------------------------------------------------------
	public boolean checkEditPrioritye(int prioritye) {
		boolean judge = false;
		System.out.println("優先度：" + prioritye);
		System.out.println("上記に変更しますか？");
		String navString = "1:Yes 2:No";
		int navPattern = 2;
		int judgeNum = 0;
		judgeNum = CommonLogic.choiceCommandPattern(navPattern, navString);
		if(judgeNum == 1) {
			judge = true;
		}else if(judgeNum == 2) {
			judge = false;
		}else {
			System.out.println("予期せぬ");
			System.exit(0);
		}
		return judge;
	}
	//優先度の変更--------------------------------------------------------------------------------------
	public void editPrioritye(TodoFolder todoFolder, int todoNum, int prioritye) {
//		int ListNum = todoNum - 1;
		for(int i = 0; i < todoFolder.getTodos().size(); i ++) {
			if(todoNum == todoFolder.getTodos().get(i).getNo()) {
				todoFolder.getTodos().get(i).setPrioritye(prioritye);
				break;
			}
		}
	}
}
