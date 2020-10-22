package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persistence {
	//保存---------------------------------------------------------------------------------------------------------------
		public static void saveFolder(TodoFolder todoFolder) {
			String comma = ",";
			String nextL = "\n";
			SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");

			try {
				FileWriter fw = new FileWriter("C:\\Users\\S1-06\\Desktop\\java\\中間制作\\todo\\todo2.txt");
				for(Todo todo : todoFolder.getTodos()) {
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
		public static boolean readFolder(TodoFolder todoFolder) {
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

						  todoFolder.getTodos().add(new Todo(no, header, body, resistrationD, limit, prioritye, finished)); //入力内容をリストにインスタンス化し追加
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
}
