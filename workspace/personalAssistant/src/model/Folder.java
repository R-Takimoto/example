package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Folder {
	//  フィールド  /////////////////////////////////////////////////////////////////////////////
	private ArrayList<Todo> todos;

	//  メソッド  //////////////////////////////////////////////////////////////////////////////


	//登録
	public void resistration() {
		Nav think = new Nav();
		Scanner sc = new Scanner(System.in);

		//見出し処理
		String header = "";//見出し格納用
		while(true) {
			try {
				System.out.println(think.getName() + "： 10文字以内で見出しの入力をお願い");
//				System.out.println("10文字以内で");
				header = sc.nextLine();
				if(header.length() == 0) {
					System.out.println("なんか書けや");
					continue;
				}else if(header.length() > 10) {
					System.out.println("長い。やりなおし");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("受付不可");
				continue;
			}
		}


		//内容処理
		String body = "";//内容格納用
		while(true) {
			try {
				System.out.println("内容入力");
				System.out.println("15文字以内で");
				body = sc.nextLine();
				if(body.length() == 0) {
					System.out.println("なんか書け");
					continue;
				}else if(body.length() > 15) {
					System.out.println("長いわい");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("不正ですぅ");
				continue;
			}
		}


		//期限処理
		String limit = "";//期限格納用
		SimpleDateFormat std = new SimpleDateFormat("yyyyMMdd");
		Date limitD;
		while(true) {
			try {
				System.out.println("期限入力");
				System.out.println("例 20200101");
				limit = sc.nextLine();	 //日付の入力(文字列)
				if(!(limit.matches("^\\d{8}$"))) {// 0-9の8文字以外は弾く
					System.out.println("入力例を確認ねがいます");
					continue;
				}
				std.setLenient(false); //日付の厳密チェック機能をＯＮにする。不正ならExceptionを出す
				limitD = std.parse(limit); //文字列からDate型に変換
				Date now = new Date();
				if(limitD.before(now)) {
					System.out.println("期限が過去になっていますよ");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("不正です");
				continue;
			}finally {
//				sc.close();
			}
		}


		//優先度処理
		int prioritye = 1;//優先度格納用
		while(true) {
			try(Scanner scc = new Scanner(System.in);) {
				while(true) {
					System.out.println("優先度入力ください");
					System.out.println("低 1～3 高");
					prioritye = scc.nextInt();
					if(prioritye < 1 || prioritye > 3) {
						System.out.println("不正なり");
						continue;
					}
					break;
				}
			}catch(Exception e) {
				System.out.println("不正す");
				continue;
			}
			break;
		}
		this.todos.add(new Todo(header, body, limitD, prioritye)); //入力内容をリストにインスタンス化し追加

	}


	//編集
	//優先度順に並び替え
	public void sortPrioritye() {
		Collections.sort(this.todos, new TodoComparator()); //優先度順に並べかえ
		Collections.reverse(this.todos);// 優先度が高い順に並べかえ
	}
	//期限順に並べかえ
	public void sortLimit() {
		Collections.sort(this.todos, new TodoComparatorLimit());
		Collections.reverse(this.todos);// 期限が近い順に並べ替え
	}
	//状態の変更


	//削除
	public void delete() {

	}



	//表示
	public void display() {
		SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");
		for(int i = 0; i < this.todos.size(); i ++) {
			System.out.println("\n-----------------------------------------------");

			System.out.println("見出し：" + this.todos.get(i).getHeader());
			System.out.println("内容：" + this.todos.get(i).getBody());
			String sss = s.format(this.todos.get(i).getResistrationDate());
			System.out.println("登録日：" + sss);
			String ss = s.format(this.todos.get(i).getLimit());
			System.out.println("期限：" + ss);
			System.out.println("優先度：" + this.todos.get(i).getPrioritye());
			String boo;
			if(this.todos.get(i).isFinished() == false) {
				boo = "未";
			}else {
				boo = "済";
			}
			System.out.println("状態：" + boo);

			System.out.println("-----------------------------------------------");
		}
	}



	//検索
//	public Todo search() {
//
//	}



	//保存
	public void saveFolder(Folder to) {
		String comma = ",";
		String nextL = "\n";
		SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");

		try {
			FileWriter fw = new FileWriter("C:\\Users\\S1-06\\Desktop\\java\\中間制作\\todo\\todo.txt");
			for(Todo todo : to.todos) {
				fw.append(todo.getHeader());
				fw.append(comma);
				fw.append(todo.getBody());
				fw.append(comma);
				String resistrationD = s.format(todo.getResistrationDate());
				fw.append(resistrationD);
				fw.append(comma);
				String limit = s.format(todo.getLimit());
				fw.append(limit);
				fw.append(comma);
				String prioritye = String.valueOf(todo.getPrioritye());
				fw.append(prioritye);
				fw.append(comma);
				String finished = String.valueOf(todo.isFinished());
				fw.append(finished);
				fw.append(nextL);
			}

			fw.close();
			System.out.println("書き出し完了");
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}



	//読み込み処理
	public void readFolder() {
		SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");
		try {
			File file = new File("C:\\Users\\S1-06\\Desktop\\java\\中間制作\\todo\\todo.txt");
			if (file.exists()){

				  FileReader fr = new FileReader(file); // 読み込み
				  BufferedReader br = new BufferedReader(fr); // 行読み込み

				  String str = br.readLine(); //1行読み込み
				  while(str != null) {
					  String[] st = str.split(",", 0);//カンマ区切りで配列に分ける

					  //インスタンス化用に変換する
					  String header = st[0];
					  String body = st[1];
					  Date resistrationD = s.parse(st[2]);
					  Date limit = s.parse(st[3]);
					  int prioritye = Integer.parseInt(st[4]);
					  boolean finished = Boolean.valueOf(st[5]);

					  this.todos.add(new Todo(header, body, resistrationD, limit, prioritye, finished)); //入力内容をリストにインスタンス化し追加
					  str = br.readLine();// 次の行を読みこむ
				  }

				  br.close();
			}else{
			    System.out.println("ファイル無し新規作成します");
			}


			} catch(FileNotFoundException e) {
			  System.out.println(e);
			} catch(IOException e) {
			  System.out.println(e);
			}catch(Exception e) {
				System.out.println(e);
			}
	}

	//  ゲッター  /////////////////////////////////////////////
	public ArrayList<Todo> getTodos() {
		return todos;
	}
	//  コンストラクタ  /////////////////////////////////////
	public Folder() {
		this.todos = new ArrayList<Todo>();
	}
}
