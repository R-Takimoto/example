package model;

import java.util.Scanner;

public class Nav {
	//	フィールド //////////////////////////////////////////
	private String name;
	private Folder myFolder;

	//  メソッド  //////////////////////////////////////////


	//ナビ---------------------------------------------------------------------------
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
			System.out.println(this.name + "：コマンドを数字で選んでくれる？");
			System.out.println("1:登録 2:表示 3:編集 4:削除 5:終了");

			//コマンド選択処理
			int num = 0; //コマンド選択用
			while(true) {
				try {
					Scanner sc = new Scanner(System.in);
					num = sc.nextInt();
					if(num < 1 || num > 5) {
						System.out.println("1～5で入力して");
						System.out.println("1:登録 2:表示 3:編集 4:削除 5:終了");
						continue;
					}
					break;
				}catch(Exception e) {
					System.out.println("1 or 2 or 3 or 4 or 5！ ok!?");
					continue;
				}
			}

			//各種処理
			if(num < 3) {
				if(num == 1) {
					resistration(); //登録
				}else if(num == 2) {
					display(); //表示
				}
			}else if(num < 5) {
				if(num == 3) {
					edit();  //編集
				}else if(num == 4) {
					System.out.println("未実装");
					delete(); //削除
				}
			}else {
//				myFolder.saveFolder(myFolder);/////////////////////////////////////////////////////
				System.out.println(this.name + "： Bye");
				System.exit(0);// 終了
			}
		}


	}

	//ここから各種処理///////////////////////////////////////////////////////////////////

	//登録処理------------------------------------------------------------------
		public void resistration() {
			this.myFolder.resistration();
//			this.myFolder.saveFolder(myFolder);
		}

	//表示処理----------------------------------------------------------------------
	public void display() {
		System.out.println("表示方法を下記より");
		System.out.println("1:優先度高い順 2:期限近い順 3:登録した順");


		//コマンド選択処理
		int num = 0; //コマンド選択用
		int pattern = 3;//表示方法
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				num = sc.nextInt();
				if(num < 1 || num > pattern) {
					System.out.println("1～" + pattern +"で入力して");
					System.out.println("1:優先度高い順 2:期限近い順 3:登録した順");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("1 or 2 or 3！ ok!?");
				continue;
			}
		}

		if(num == 1) {
			this.myFolder.sortPrioritye(); //優先度順に並べかえ
			this.myFolder.display();
		}else if(num == 2) {
			this.myFolder.sortLimit();//期限順に並べかえ
			this.myFolder.display();
		}else if(num == 3) {
			this.myFolder.sortResistration();//登録順に並べかえ
			this.myFolder.display();
		}
	}


	//編集処理------------------------------------------------------------------
	public void edit() {
		//編集したいタスクを選ぶ
		String hensyu = "編集";
		int editNum = todoChoice(hensyu);

		//編集項目を選ぶ
		int editItem = 0;
		System.out.println("編集項目を下記より");
		System.out.println("1:タスクの完了 2:期限の変更 3:優先度の変更");
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				editItem = sc.nextInt();
				if(editItem > 3 || editItem < 1) {
					System.out.println("そんな選択肢はない");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("むむむ");
				continue;
			}
		}

		//処理
		switch(editItem) {
			case 1:
				this.myFolder.editFinished(editNum);
				break;
			case 2:
				break;
			case 3:
				break;
		}
	}


	//削除処理--------------------------------------------------------------------
	public void delete() {

	}


	//汎用処理////////////////////////////////////////////////////////////
	public int todoChoice(String item) {
		int editNum = 0;//タスクの選択用
		while(true) {
			this.myFolder.sortResistration();//登録順に並べかえ
			this.myFolder.display();
			System.out.println(item + "したいタスクNo.を入力してください");
			try {
				Scanner sc = new Scanner(System.in);
				editNum = sc.nextInt();
				if(editNum > this.myFolder.getTodos().size() || editNum < 1) {
					System.out.println("そんなNo.なくない？？");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("むむ");
				continue;
			}
		}
		return editNum;
	}


	//	ゲッター・セッター ///////////////////////////////////////

	public String getName() {
		return name;
	}


	public Folder getMyFolder() {
		return myFolder;
	}


	public void setName(String name) {
		this.name = name;
	}

	//  コンストラクタ  ///////////////////////////////////
	public Nav() {
		this.name = "ティンク";
		this.myFolder = new Folder();
//		 myFolder.readFolder(); //インスタンス化時に保存されているファイルがあれば読みこむ
	}
}