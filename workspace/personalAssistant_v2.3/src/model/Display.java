package model;

import java.util.ArrayList;
import java.util.Date;

public class Display {
	//表示方法確認処理
	public void confirmSort(TodoFolder todoFolder) {
		String navString = "1:登録順 2:期限順 3:優先度順";
		int navPattern = 3;
		int choiceNum = 0;
		choiceNum = CommonLogic.choiceCommandPattern(navPattern, navString);

		boolean judge = true;
		int judgeNum = 0;
		navString = "1:昇順 2:降順";
		navPattern = 2;
		judgeNum = CommonLogic.choiceCommandPattern(navPattern, navString);
		if(judgeNum == 1) {
			judge = true;
		}else if(judgeNum == 2) {
			judge = false;
		}else {
			System.out.println("予期せぬ");
			System.exit(0);
		}

		if(choiceNum == 1) {
			CommonLogic.sortResistration(todoFolder, judge);//登録順に並べかえ
		}else if(choiceNum == 2) {
			CommonLogic.sortLimit(todoFolder, judge);//期限順に並べかえ
		}else if(choiceNum == 3) {
			CommonLogic.sortPrioritye(todoFolder, judge);//優先度順に並べかえ
		}
	}
	//Todo一覧表示メソッド
	public void displayTodos(TodoFolder todoFolder) {
		ArrayList<Todo> todoList = todoFolder.getTodos();
		for(int i = 0; i < todoList.size(); i ++) {
			Todo todo = todoList.get(i);
			displayTodo(todo);
		}
	}
	//Todo表示メソッド
	public void displayTodo(Todo todo) {
//		CommonLogic cl = new CommonLogic();
		Date resistrationDate = todo.getResistrationDate();
		Date limitDate = todo.getLimit();
		boolean checkFinished = todo.isFinished();

		String no = String.valueOf(todo.getNo());
		String header = todo.getHeader();
		String body = todo.getBody();
		String limitDateF = CommonLogic.conversionDateToString(limitDate);
		String resistrationDateF = CommonLogic.conversionDateToString(resistrationDate);
		String prioritye = String.valueOf(todo.getPrioritye());
		String finished;
		if(checkFinished) {
			finished = "済";
		}else {
			finished = "未";
		}
		//出力
		System.out.println("\n-----------------------------------------------");
		System.out.println("No." + no);
		System.out.println("見出し：" + header);
		System.out.println("内容：" + body);
		System.out.println("登録日時：" + resistrationDateF);
		System.out.println("期限：" + limitDateF);
		System.out.println("優先度：" + prioritye);
		System.out.println("処理：" + finished);
		System.out.println("-----------------------------------------------");
		}
}