package model;

import java.util.Scanner;

public class Nav {
	//	フィールド //////////////////////////////////////////
	private String name;
	private Folder myFolder;

	//  メソッド  //////////////////////////////////////////


	//ナビ---------------------------------------------------------------------------
	public void nav() {
		while(true) {
			System.out.println(this.name + "： コマンドを数字で選んでくれる？");
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
					System.out.println("未実装");
					edit();  //編集
				}else if(num == 4) {
					System.out.println("未実装");
					delete(); //削除
				}
			}else {
//				myFolder.saveFolder(myFolder);
				System.out.println(this.name + "： Bye");
				System.exit(0);// 終了
			}
		}
	}


	//表示処理----------------------------------------------------------------------
	public void display() {
		System.out.println("表示方法を下記より");
		System.out.println("1:優先度順 2:期限順 3:");


		//コマンド選択処理
		int num = 0; //コマンド選択用
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				num = sc.nextInt();
				if(num < 1 || num > 2) {
					System.out.println("1～2で入力して");
					System.out.println("1:優先度順に並べかえ 2:期限順に並べかえ 3:");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("1 or 2！ ok!?");
				continue;
			}
		}

		if(num < 3) {
			if(num == 1) {
				this.myFolder.sortPrioritye(); //優先度順に並べかえ
				this.myFolder.display();
//				this.myFolder.saveFolder(myFolder);
			}else if(num == 2) {
				this.myFolder.sortLimit();
				this.myFolder.display();
			}
		}
//		this.myFolder.display();
	}


	//登録処理------------------------------------------------------------------
	public void resistration() {
		this.myFolder.resistration();
		this.myFolder.saveFolder(myFolder);
	}


	//編集処理------------------------------------------------------------------
	public void edit() {

	}


	//削除処理--------------------------------------------------------------------
	public void delete() {

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
		 myFolder.readFolder(); //インスタンス化時に保存されているファイルがあれば読みこむ
	}
}
