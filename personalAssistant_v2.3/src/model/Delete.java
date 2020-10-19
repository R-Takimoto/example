package model;

import java.util.ArrayList;

public class Delete {
	//削除方法の確認---------------------------------------------------------------------------------------------------
	public boolean confirmHowToDelete() {
		String navString = "1:No.で選択 2:処理済の一括削除";
		int navPattern = 2;
		int choiceNum = 0;
		choiceNum = CommonLogic.choiceCommandPattern(navPattern, navString);

		boolean judge = true;
		if(choiceNum == 1) {
			judge = true;
		}else if(choiceNum == 2) {
			judge = false;
		}else {
			System.out.println("予期せぬ");
			System.exit(0);
		}
		return judge;
	}
	//最終確認：削除するTodosの確認表示------------------------------------------------------------------------------------------
	public boolean confirmDeleteTodos(TodoFolder todoFolder) {
		boolean judgeDeleteTodos = false;//return
		ArrayList<Todo> todos = todoFolder.getTodos();
		Display display = new Display();

		int[] todoNums = CommonLogic.finishedTodoNum(todos);//処理済TodoNo.の取得
		display.displayTodos(todoFolder, todoNums);//処理済Todoの表示

		System.out.println("上記Todoを全て削除します");
		System.out.println("よろしいですか？");
		String navString = "1:Yes 2:No";
		int navPattern = 2;
		int judgeNum = 0;
		judgeNum = CommonLogic.choiceCommandPattern(navPattern, navString);
		if(judgeNum == 1) {
			 judgeDeleteTodos = true;
		}else if(judgeNum == 2) {
			 judgeDeleteTodos = false;
		}else {
			System.out.println("予期せぬ");
			System.exit(0);
		}
		return judgeDeleteTodos;
	}
	//最終確認：削除するTodoの確認--------------------------------------------------------------------------------------------
	public boolean confirmTodo() {
		boolean judgeDeleteTodo = false;
		System.out.println("よろしいですか？");
		String navString = "1:Yes 2:No";
		int navPattern = 2;
		int judgeNum = 0;
		judgeNum = CommonLogic.choiceCommandPattern(navPattern, navString);
		if(judgeNum == 1) {
			 judgeDeleteTodo = true;
		}else if(judgeNum == 2) {
			 judgeDeleteTodo = false;
		}else {
			System.out.println("予期せぬ");
			System.exit(0);
		}
		return judgeDeleteTodo;

	}

	//Todo削除処理-----------------------------------------------------------------------------------------------------------------
	public void deleteTodo(TodoFolder todoFolder, int todoNum) {
//		int ListNum = todoNum -1;
		for(int i = 0; i < todoFolder.getTodos().size(); i ++) {
			if(todoNum == todoFolder.getTodos().get(i).getNo()) {
				todoFolder.getTodos().remove(i);
				break;
			}
		}
	}
	//Todo処理済一括削除処理------------------------------------------------------------------------------------------------
	public void deleteTodos(TodoFolder todoFolder) {
		ArrayList<Todo> todos = todoFolder.getTodos();
		int[] todoNums = CommonLogic.finishedTodoNum(todos);//処理済TodoNo.の取得
		for(int i = 0; i < todoNums.length; i ++) {
			deleteTodo(todoFolder, todoNums[i]);
		}
	}
	//TodoNo.の振り直し処理-----------------------------------------------------------------------------------------------------
	public void redoFolderNum(TodoFolder todoFolder) {
		CommonLogic.sortResistration(todoFolder, true);//登録昇順
		ArrayList<Todo> todos = todoFolder.getTodos();
		int todoNum = 0;
		for(int i = 0; i < todos.size(); i ++) {
			todoNum = i + 1;
			todos.get(i).setNO(todoNum);
		}
	}
}
