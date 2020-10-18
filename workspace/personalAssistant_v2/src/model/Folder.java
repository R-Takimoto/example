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

//  ゲッター・セッター  //////////////////////////////////////////////////////////////////////
	public ArrayList<Todo> getTodos() {
		return todos;
	}
	//  コンストラクタ  /////////////////////////////////////////////////////////////////////////
	public Folder() {
		this.todos = new ArrayList<Todo>();
	}



	//  メソッド  //////////////////////////////////////////////////////////////////////////////
	//登録-------------------------------------------------------------------------------------------------
	public void resistration() {
		Nav think = new Nav();
		Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
		//TodoNo.処理
		int no = 0;//No.格納用
		int toLength = todos.size();
		no = toLength + 1;

		//見出し処理
		String header = standardInputHeader();

		//内容処理
		String body = standardInputBody();

		//期限処理
		Date limit = standardInputLimit();

		//優先度処理
		int prioritye = standardInputPrioritye();

		//登録内容確認処理
		boolean done = confirmContentsIsDone(header, body, limit, prioritye);

		//登録もしくはキャンセル処理
		if(done) {
			this.todos.add(new Todo( no, header, body, limit, prioritye)); //入力内容をリストにインスタンス化し追加
		}else {
			System.out.println("次なる処理をえらびたまえ");
		}

	}
	//登録に関する見出し処理
		public String standardInputHeader() {
			Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
			String header = "";//見出し格納用
			int headerMozisu = 30;//見出し文字数の上限
			while(true) {
				try{
					System.out.println(headerMozisu + "文字以内で見出しの入力をお願い");
					header = sc.nextLine();
					if(header.length() == 0) {
						System.out.println("なんか書けや");
						continue;
					}else if(header.length() > headerMozisu) {
						System.out.println("長い。やりなおし");
						continue;
					}
					break;
				}catch(Exception e) {
					System.out.println("受付不可");
					continue;
//					System.exit(0);
				}
			}
			return header;
		}
		//登録に関する内容処理
		public String standardInputBody() {
			Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
			String body = "";//内容格納用
			int bodyMozisu = 150;
			while(true) {
				try {
					System.out.println("内容入力");
					System.out.println(bodyMozisu + "文字以内で");
					body = sc.nextLine();
					if(body.length() == 0) {
						System.out.println("なんか書け");
						continue;
					}else if(body.length() > bodyMozisu) {
						System.out.println("長いわい");
						continue;
					}
					break;
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("不正ですぅ");
					continue;
//					System.exit(0);
				}
			}
			return body;
		}
		//登録に関する期限処理
		public Date standardInputLimit() {
			Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
			String limit = "";//期限格納用
			SimpleDateFormat std = new SimpleDateFormat("yyyy/MM/dd-HH:mm");
			Date limitD;
			while(true) {
				try {
					System.out.println("期限入力");
					System.out.println("例 2020/01/01-12:34");
					limit = sc.nextLine();	 //日付の入力(文字列)
					if(!(limit.matches("[0-9]{4}/[0-9]{2}/[0-9]{2}-[0-9]{2}:[0-9]{2}"))) {
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
				}
			}
			return limitD;
		}
		//登録に関する優先度処理
		public int standardInputPrioritye() {
			Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
			int prioritye = 1;//優先度格納用
			while(true) {
				try {
					System.out.println("優先度入力ください");
					System.out.println("低 1～3 高");
					prioritye = sc.nextInt();
					if(prioritye < 1 || prioritye > 3) {
						System.out.println("不正なり");
						continue;
					}
					break;
				}catch(Exception e) {
					System.out.println("不正す");
					continue;
				}
			}
			return prioritye;
		}
		//登録に関する内容確認処理
		public boolean confirmContentsIsDone(String header, String body, Date limit, int prioritye) {
			Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
			boolean done;
			String check;//最終確認格納用
			String limitF = conversionDateToString(limit);
			while(true) {
				System.out.println("下記内容で登録します");
				System.out.println("-----------------------------------------------");
				System.out.println("見出し：" + header);
				System.out.println("内容：" + body);
				System.out.println("期限：" + limitF);
				System.out.println("優先度：" + prioritye);
				System.out.println("-----------------------------------------------");
				System.out.println("よろし？");
				System.out.println("y/n");
				try {
					check = sc.nextLine();
					if(check.equals("y")) {
						done = true;
						break;
					}else if(check.equals("n")) {
						System.out.println("n!?ここまで来て!?");
						done = false;
						break;
					}else {
						System.out.println("y or n");
						continue;
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			return done;
		}
	//編集-------------------------------------------------------------------------------------------------
	//処理状態の変更
	public void editFinished(int editNo) {
		int num = editNo - 1;
		this.todos.get(num).setFinished(true);
		System.out.println("こんぐらちゅれーしょん！！！");
	}
	//期限の変更
	public void editLimit() {
	}
	//優先度の変更
	public void editPrioritye() {

	}
	//削除---------------------------------------------------------------------------------------------------
	public void delete() {

	}
	//表示----------------------------------------------------------------------------------------------------
	public void display() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");
		for(int i = 0; i < this.todos.size(); i ++) {
			//各項目を取得する
			Date resistrationDate = this.todos.get(i).getResistrationDate();
			Date limit = this.todos.get(i).getLimit();
			boolean checkFinished = this.todos.get(i).isFinished();
			//項目セット
			int no = this.todos.get(i).getNo();
			String header = this.todos.get(i).getHeader();
			String body = this.todos.get(i).getBody();
			String resistrationDateFormat = conversionDateToString(resistrationDate);
			String limitFormat = conversionDateToString(limit);
			int prioritye = this.todos.get(i).getPrioritye();
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
			System.out.println("登録日時：" + resistrationDateFormat);
			System.out.println("期限：" + limitFormat);
			System.out.println("優先度：" + prioritye);
			System.out.println("処理：" + finished);
			System.out.println("-----------------------------------------------");
		}
	}
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
		//登録順に並び替え
		public void sortResistration() {
			Collections.sort(this.todos, new TodoComparatorResistration());
		}
	//検索---------------------------------------------------------------------------------------------------------------------------
//	public Todo search() {
//
//	}
	//保存---------------------------------------------------------------------------------------------------------------
	public void saveFolder(Folder to) {
		String comma = ",";
		String nextL = "\n";
		SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");

		try {
			FileWriter fw = new FileWriter("C:\\Users\\S1-06\\Desktop\\java\\中間制作\\todo\\todo2.txt");
			for(Todo todo : to.todos) {
				String no = String.valueOf(todo.getNo());
				fw.append(no);
				fw.append(comma);
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
	//読み込み処理------------------------------------------------------------------------------------------------------------------
	public boolean readFolder() {
		boolean re = false;
		SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		try {
			File file = new File("C:\\Users\\S1-06\\Desktop\\java\\中間制作\\todo\\todo2.txt");
			if (file.exists()){

				  FileReader fr = new FileReader(file); // 読み込み
				  BufferedReader br = new BufferedReader(fr); // 行読み込み

				  String str = br.readLine(); //1行読み込み
				  while(str != null) {
					  String[] st = str.split(",", 0);//カンマ区切りで配列に分ける

					  //インスタンス化用に変換する
					  int no = Integer.parseInt(st[0]);
					  String header = st[1];
					  String body = st[2];
					  Date resistrationD = s.parse(st[3]);
					  Date limit = s.parse(st[4]);
					  int prioritye = Integer.parseInt(st[5]);
					  boolean finished = Boolean.valueOf(st[6]);

					  this.todos.add(new Todo(no, header, body, resistrationD, limit, prioritye, finished)); //入力内容をリストにインスタンス化し追加
					  str = br.readLine();// 次の行を読みこむ
				  }
				  br.close();
				  re = false;
			}else{
			    System.out.println("ファイル無し新規作成します");
			    re = true;
			}
			} catch(FileNotFoundException e) {
			  System.out.println(e);
			  System.exit(0);
			} catch(IOException e) {
			  System.out.println(e);
			  System.exit(0);
			}catch(Exception e) {
				System.out.println(e);
				System.exit(0);
			}
		return re;
	}

	//Date型からフォーマット変換処理
	public String conversionDateToString(Date date) {
		String dateFormat = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		dateFormat = sdf.format(date);
		return dateFormat;
	}
}
