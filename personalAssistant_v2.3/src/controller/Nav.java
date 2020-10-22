package controller;

import java.util.ArrayList;
import java.util.Date;

import model.CommonLogic;
import model.Delete;
import model.Display;
import model.Edit;
import model.Persistence;
import model.Resistration;
import model.Todo;
import model.TodoFolder;

public class Nav {
	//	フィールド //////////////////////////////////////////
	private String name;
	private TodoFolder myFolder;

//  コンストラクタ  ///////////////////////////////////
	public Nav() {
		this.name = "ティンク";
		this.myFolder = new TodoFolder();
	}

//	ゲッター・セッター ///////////////////////////////////////
	public String getName() {
		return name;
	}

	public TodoFolder getMyFolder() {
		return myFolder;
	}

	//  メソッド  //////////////////////////////////////////


	//main制御ナビ ---------------------------------------------------------------------------
	public void nav() {
		Persistence.readFolder(myFolder);//ファイル確認
//		myFolder.readFolder();//ファイル確認処理
		System.out.println(this.name + "：Hello");
		while(true) {

			//フォルダ確認
			checkFolderNav();//Todoが0なら実行

			//Todoが1件以上の処理
			String navString = "1:登録 2:表示 3:編集 4:削除 5:終了";
			int navPattern = 5;
			int choiceNum = 0;
			choiceNum = CommonLogic.choiceCommandPattern(navPattern, navString);
			//各種処理
			switch(choiceNum) {
			case 1:
				resistration();
				break;
			case 2:
				display();
				break;
			case 3:
				edit();
				break;
			case 4:
				delete();
				break;
			case 5:
				Persistence.saveFolder(myFolder);
				System.out.println(this.name + "： Bye");
				System.exit(0);// 終了
			default:
				System.out.println("予期せぬ");
				System.exit(0);// 終了
			}
		}
	}

	//Todo確認-----------------------------------------------------------
	private void checkFolderNav() {
		if(myFolder.getTodos().size() == 0) {
			while(true) {
				System.out.println(this.name + "：抱えてるタスクが登録されて無いわ。");
				//コマンド選択処理
				String navString = "1:登録 2:終了";
				int navPattern = 2;
				int choiceNum = 0;
				choiceNum = CommonLogic.choiceCommandPattern(navPattern, navString);

				//各種処理
				if(choiceNum == 1) {
					resistration();//登録
					if(myFolder.getTodos().size() == 0) {
						continue;
					}else {
						break;
					}
				}else if(choiceNum == 2) {
					System.out.println(this.name + "： Bye");
					Persistence.saveFolder(myFolder);
					System.exit(0);// 終了
				}else {
					System.out.println("????");
					System.exit(0);
				}
			}
		}else {
			ArrayList<Todo> todos = myFolder.getTodos();
			int[] finishedTodoNum = CommonLogic.finishedTodoNum(myFolder.getTodos());//処理済TodoNo.の取得

			int noFinishedTodoLength = todos.size() - finishedTodoNum.length;//未処理Todoの数

			if(noFinishedTodoLength > 0) {
				System.out.println(this.name + "：現在" + noFinishedTodoLength + "件の未処理タスクが残っているわ");
				System.out.println(this.name + "：早く片付けてくれる？");
			}else {
				System.out.println("現在未処理のタスクは残ってないわね");
			}
		}
	}

	//ここから各種メソッド///////////////////////////////////////////////////////////////////

	//登録------------------------------------------------------------------
		public void resistration() {
			Resistration resistration = new Resistration();//登録処理クラスの呼び出し
			Todo todo =  resistration.temporaryResistrationTodo();//仮登録
			boolean done = resistration.confirmContentsIsDone(todo);//登録内容確認
			if(done) {
				resistration.addTodo(myFolder, todo);// Todoをフォルダへ追加登録
				System.out.println("登録完了しました");
			}else {
				System.out.println("入力内容を破棄します。");
			}
		}

	//表示----------------------------------------------------------------------
	public void display() {
		Display display = new Display();//表示処理クラスの呼び出し
		display.confirmSort(myFolder);
		display.displayTodos(myFolder);
	}


	//編集------------------------------------------------------------------
	public void edit() {
		Edit edit = new Edit();
		int todoNum = 0;

		//編集したいタスクを選ぶ
		String command = "編集";
		todoNum = CommonLogic.choiceTodo(myFolder, command);

		//編集項目を選ぶ
		String navString = "1:タスクの処理 2:期限の変更 3:優先度の変更";
		int navPattern = 3;
		int choiceNum = 0;
		choiceNum = CommonLogic.choiceCommandPattern(navPattern, navString);
		//処理
		switch(choiceNum) {
			case 1:
				boolean judgeEditFinished = edit.confirmFinished();
				edit.editTodoFinished(this.myFolder, todoNum, judgeEditFinished);
				break;
			case 2:
				Date limit =edit.confirmLimit();
				boolean judgeEditLimit = edit.checkEditLimit(limit);
				if(judgeEditLimit) {
					edit.editLimit(myFolder, todoNum, limit);
					System.out.println("変更しました");
				}else {
					System.out.println("入力内容を破棄します");
				}
				break;
			case 3:
				int prioritye = edit.confirmPrioritye();
				boolean judgeEditPrioritye = edit.checkEditPrioritye(prioritye);
				if(judgeEditPrioritye) {
					edit.editPrioritye(myFolder, todoNum, prioritye);
					System.out.println("変更しました");
				}else {
					System.out.println("入力内容を破棄します");
				}
				break;
		}
	}


	//削除--------------------------------------------------------------------
	public void delete() {
		Delete delete = new Delete();
		boolean judge = true;//最終判定

		//削除方法の確認
		boolean confirmJudge = true;
		confirmJudge = delete.confirmHowToDelete();

		if(confirmJudge == true) {
			//削除するTodoを選択表示
			String command = "削除";
			int editNum = CommonLogic.choiceTodo(myFolder, command);
			//タスク削除の確認
			judge = delete.confirmTodo();;
			//削除
			if(judge) {
				delete.deleteTodo(myFolder, editNum);
				System.out.println("削除しました");
				delete.redoFolderNum(myFolder);//No.の振り直し
			}else {
				System.out.println("削除処理を破棄します");
			}
		}else {
			//削除するTodosを表示・確認
			judge = delete.confirmDeleteTodos(myFolder);
			//削除
			if(judge == true) {
				delete.deleteTodos(myFolder);
				System.out.println("削除しました");
				delete.redoFolderNum(myFolder);//No.の振り直し
			}else {
				System.out.println("削除処理を破棄します");
			}
		}

	}




}
