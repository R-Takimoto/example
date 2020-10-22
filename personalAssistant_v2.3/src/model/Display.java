package model;

import java.util.ArrayList;
import java.util.Date;

public class Display {
	//表示方法確認処理---------------------------------------------------------------------------------
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
	//Todo一覧表示メソッド------------------------------------------------------------------------------
	public void displayTodos(TodoFolder todoFolder, int[]...todoNums) {
		if(todoNums.length != 0) {
			ArrayList<Todo> todos = todoFolder.getTodos();
			for(int i = 0; i < todos.size(); i ++) {
				for(int j = 0; j < todoNums[0].length; j ++) {
					if(todos.get(i).getNo()  == todoNums[0][j]) {
						displayTodo(todos.get(i));
					}
				}
			}
		}else {
			ArrayList<Todo> todos = todoFolder.getTodos();
			for(int i = 0; i < todos.size(); i ++) {
				displayTodo(todos.get(i));
			}
		}
	}
	//Todo表示メソッド-----------------------------------------------------------------------------------
	public void displayTodo(Todo todo) {
//		CommonLogic cl = new CommonLogic();
		Date resistrationDate = todo.getResistrationDate();
		Date limitDate = todo.getLimit();
		boolean checkFinished = todo.isFinished();

		String no = String.valueOf(todo.getNo());
		String header = todo.getHeader();
		String body = addNewLine(todo.getBody());
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

	//文字列に改行を追加して返す----------------------------------------------------------------------------
	public String addNewLine(String body) {
		String line = body;//retrun
		int bodyLength = body.length();//渡された文字列の数
		int lineNum = 15;//改行したい文字数

		String newLine = "\n";
		StringBuilder bodyBuilder = new StringBuilder();
		bodyBuilder.append(body);//ビルダーに内容を渡す

		int rotation = 1;//whileの周回数
		int NewLineNum = lineNum;//改行する箇所
		int NewLineLength = 0;//追加した改行コード分、改行箇所を調整


		while(bodyLength > NewLineNum) {
			bodyBuilder.insert(NewLineNum, newLine);
			line = bodyBuilder.toString();
			rotation ++;
			NewLineLength ++;
			NewLineNum = lineNum * rotation + NewLineLength;//改行箇所 * 周回数 + 追加した改行コードの数
		}
		return line;
	}

//	//改行追加表示//やりたいことはaddNewLineと同じ
//	public void addNewLineDisplay(String body) {
//		int bodyLength = body.length();
//		ArrayList<String> listBody = new ArrayList<String>();
//
//		String letter = "";
//		int j = 1;
//		for(int i = 0; i <= bodyLength; i ++) {
//			if(i == bodyLength) {
//				letter = body.substring(i);
//			}else {
//				letter = body.substring(i,  j);
//			}
//
//			listBody.add(letter);
//			j ++;
//		}
//
//		String out = "";
//		for(int i = 0; i <= listBody.size(); i ++) {
//			if(i == listBody.size()) {
//				out = listBody.get(i - 1);
//			}else {
//				out = listBody.get(i);
//			}
//			if(i % 15 == 0 && i != 0) {
//				System.out.print("\n");
//			}
//			System.out.print(out);
//		}
//	}

}
