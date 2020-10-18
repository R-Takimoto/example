package model;

import java.util.ArrayList;

public class Delete {
	//削除するTodoの確認
	public boolean confirmTodo(TodoFolder todofolder, int todoNo) {
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

	//Todo削除処理
	public void deleteTodo(TodoFolder todoFolder, int todoNum) {
//		int ListNum = todoNum -1;
		for(int i = 0; i < todoFolder.getTodos().size(); i ++) {
			if(todoNum == todoFolder.getTodos().get(i).getNo()) {
				todoFolder.getTodos().remove(i);
				break;
			}
		}
	}
	//TodoNo.の振り直し処理
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
