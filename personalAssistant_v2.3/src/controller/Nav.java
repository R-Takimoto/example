package controller;

import java.util.Date;

import model.CommonLogic;
import model.Delete;
import model.Display;
import model.Edit;
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

	public void setName(String name) {
		this.name = name;
	}

	public TodoFolder getMyFolder() {
		return myFolder;
	}

	//  メソッド  //////////////////////////////////////////


	//main制御ナビ ---------------------------------------------------------------------------
	public void nav() {

		//ファイル確認処理
//		boolean flg = myFolder.readFolder();
//
//		if(flg == true || myFolder.getTodos().size() == 0) {//ファイル無しもしくはファイル内が空
//			while(true) {
//				System.out.println(this.name + "： コマンドを数字で選んでくれる？");
//				System.out.println("1:登録 2:終了");
//
//				//コマンド選択処理
//				int num = 0; //コマンド選択用
//				while(true) {
//					try {
//						Scanner sc = new Scanner(System.in);
//						num = sc.nextInt();
//						if(num < 1 || num > 2) {
//							System.out.println("1～2で入力して");
//							System.out.println("1:登録 2:終了");
//							continue;
//						}
//						break;
//					}catch(Exception e) {
//						System.out.println("1 or 2！ ok!?");
//						continue;
//					}
//				}
//
//				//各種処理
//				if(num == 1) {
//					resistration();//登録
//					if(myFolder.getTodos().size() == 0) {
//						continue;
//					}else {
//						break;
//					}
//				}else if(num == 2) {
//					System.out.println(this.name + "： Bye");
//					System.exit(0);// 終了
//				}else {
//					System.out.println("????");
//					System.exit(0);
//				}
//			}
//		}else {
//			System.out.println(this.name + "：今日は何の用？");
//		}
//////////////////////////////////////////////////////////////////////////////

		//ファイル存在時処理
		while(true) {
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
//				myFolder.saveFolder(myFolder);/////////////////////////////////////////////////////
				System.out.println(this.name + "： Bye");
				System.exit(0);// 終了
			default:
				System.out.println("予期せぬ");
				System.exit(0);// 終了
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
//			this.myFolder.saveFolder(myFolder);
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
		//削除するタスクを選択
		int editNum = 0;
		String command = "削除";
		editNum = CommonLogic.choiceTodo(myFolder, command);
		//タスク削除の確認
		boolean judge = delete.confirmTodo(myFolder, editNum);
		//削除
		if(judge) {
			delete.deleteTodo(myFolder, editNum);
			System.out.println("削除しました");
			delete.redoFolderNum(myFolder);//No.の振り直し
		}else {
			System.out.println("削除処理を破棄します");
		}
	}




}
