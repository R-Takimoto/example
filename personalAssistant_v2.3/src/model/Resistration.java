package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Resistration {

	//Todo入力処理-------------------------------------------------------------------------------------------------
	public Todo temporaryResistrationTodo() {
		//見出し処理
		String header = standardInputHeader();
		//内容処理
		String body = standardInputBody();
		//期限処理
		Date limit = standardInputLimit();
		//優先度処理
		int prioritye = standardInputPrioritye();

		Todo todo = new Todo(header, body, limit, prioritye);
		return todo;
	}

	//Todo入力：見出し処理
	private String standardInputHeader() {
		Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
		String header = "";//見出し格納用
		int headerMozisu = 30;//見出し文字数の上限
		while(true) {
			try{
				System.out.println(headerMozisu + "文字以内で見出しの入力をお願い");
				System.out.println("改行はできませんので悪しからず");
				header = sc.nextLine();
				header = deleteNewLine(header);//改行コードチェック：除去
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
//				System.exit(0);
			}
		}
		return header;
	}
	//Todo入力：内容処理
	private String standardInputBody() {
		Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
		String body = "";//内容格納用
		int bodyMozisu = 150;
		while(true) {
			try {
				System.out.println("内容入力");
				System.out.println(bodyMozisu + "文字以内で");
				body = sc.nextLine();
				body = deleteNewLine(body);//改行コードチェック：除去
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
//				System.exit(0);
			}
		}
		return body;
	}
	//Todo入力：期限処理
	protected Date standardInputLimit() {
		Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
		String limit = "";//期限入力用
		Date limitD;//return用

		SimpleDateFormat std = new SimpleDateFormat("yyyy/MM/dd-HH:mm");//入力法の指定
		while(true) {
			try {
				System.out.println("期限入力");
				System.out.println("例 2020/01/01-12:34");
				limit = sc.nextLine();	 //日付の標準入力
				boolean judge = limit.matches("[0-9]{4}/[0-9]{2}/[0-9]{2}-[0-9]{2}:[0-9]{2}");
				if(judge == false) {
					System.out.println("入力例を確認ねがいます");
					continue;
				}
				std.setLenient(false); //日付の厳密チェック機能をＯＮにする。不正ならException
				limitD = std.parse(limit); //文字列からDate型に変換//parseException
				//現在時刻 < 期限 の判定処理
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
	//Todo入力：優先度処理
	protected int standardInputPrioritye() {
		int prioritye = 1;//優先度格納用
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
				System.out.println("優先度入力ください");
				System.out.println("低 1～3 高");
				prioritye = sc.nextInt();
				if(prioritye < 1 || prioritye > 3) {
					System.out.println("不正なり");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("不正す");					continue;
			}
		}
		return prioritye;
	}

	//Todo最終内容確認処理---------------------------------------------------------------------------
	public boolean confirmContentsIsDone(Todo todo) {
		Scanner sc = new Scanner(System.in);//標準入力はcloseしなくてok??
		boolean done;// return用
		String check;//最終確認用

		Date limit = todo.getLimit();
		String limitFormat = CommonLogic.conversionDateToString(limit);
//		String limitFormat = conversionDateToStringFormat(limit);
		while(true) {
			System.out.println("下記内容で登録します");
			System.out.println("-----------------------------------------------");
			System.out.println("見出し：" + todo.getHeader());
			System.out.println("内容：" + todo.getBody());
			System.out.println("期限：" + limitFormat);
			System.out.println("優先度：" + todo.getPrioritye());
			System.out.println("-----------------------------------------------");
			System.out.println("よろし？");
			System.out.println("y/n");
			try {
				check = sc.nextLine();
				if(check.equals("y")) {
					done = true;
					break;
				}else if(check.equals("n")) {
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

	//Todoをフォルダに追加登録処理------------------------------------------------------------------------------
	public void addTodo(TodoFolder todoFolder, Todo todo) {
		int todoLength = todoFolder.getTodos().size();//現在のTodo数を確認
		int no = todoLength + 1;//ListナンバーとTodoナンバーのズレを処理
		todo.setNO(no);//TodoにNo.を付け加える
		todoFolder.getTodos().add(todo);//フォルダに追加
	}

	//入力内容から改行コードを取り除く-----------------------------------------------------------------------------
	public String deleteNewLine(String input) {
		String shaveInput = input;
		String newLine = "\r\n";//改行コードパターン
		String newLine2 = "\r";//改行コードパターン
		String newLine3 = "\n";//改行コードパターン

		if(shaveInput.matches(".*\r\n.*")) {
			shaveInput = shaveInput.replace(newLine, "");

		}else if(shaveInput.matches(".*\r.*")) {
			shaveInput = shaveInput.replace(newLine2, "");

		}else if(shaveInput.matches(".*\n.*")) {
			shaveInput = shaveInput.replace(newLine3, "");

		}
		return shaveInput;
	}

	//未使用関数
	//入力内容から改行コードを除く文字数を返す処理-----------------------------------------------------------------------------
	public int inputLengthToRemoveNewLine(String input) {
		String shaveInput = input;
		int shaveLength = shaveInput.length();//return
		String newLine = "\r\n";//改行コードパターン
		String newLine2 = "\r";//改行コードパターン
		String newLine3 = "\n";//改行コードパターン

		if(shaveInput.matches(".*\r\n.*")) {
			shaveInput = shaveInput.replace(newLine, "");

		}else if(shaveInput.matches(".*\r.*")) {
			shaveInput = shaveInput.replace(newLine2, "");

		}else if(shaveInput.matches(".*\n.*")) {
			shaveInput = shaveInput.replace(newLine3, "");

		}
		shaveLength = shaveInput.length();
		return shaveLength;
	}

}
