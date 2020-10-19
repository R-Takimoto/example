package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class CommonLogic {
	//Todo選択メソッド------------------------------------------------------------------------------
	public static int choiceTodo(TodoFolder todoFolder, String command) {
		Display display = new Display();
		int todoNum = 0;//return
		CommonLogic.sortResistration(todoFolder, true);//登録昇順
		while(true) {
			display.displayTodos(todoFolder);
			System.out.println(command + "したいタスクNo.を入力してください");
			try {
				Scanner sc = new Scanner(System.in);
				todoNum = sc.nextInt();
				if(todoNum > todoFolder.getTodos().size() || todoNum < 1) {
					System.out.println("そんなNo.なくない？？");
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("むむ");
				continue;
			}
		}

		int todoListNum = todoNum - 1;
		Todo todo = todoFolder.getTodos().get(todoListNum);
		display.displayTodo(todo);
		System.out.println("上記Todoを" + command + "します");
		return todoNum;
	}
	//コマンド選択メソッド--------------------------------------------------------------------------------------
	public static int choiceCommandPattern(int navPattern, String navString) {
		int choiceNum = 0;//return用
		System.out.println( "コマンドを数字で選びなさい");
		System.out.println(navString);

		//コマンド選択処理
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				choiceNum = sc.nextInt();
				if(choiceNum < 1 || choiceNum > navPattern) {
					System.out.println("1～" + navPattern + "で入力して");
					System.out.println(navString);
					continue;
				}
				break;
			}catch(Exception e) {
				System.out.println("1〜" + navPattern + "！ ok!?");
				continue;
			}
		}
		return choiceNum;
	}
	//処理済TodoのNo.取得-----------------------------------------------------------------------------------
	public static int[] finishedTodoNum(ArrayList<Todo> todos) {
		ArrayList<Integer> finishedTodo = new ArrayList<Integer>();
		for(int i = 0; i < todos.size(); i ++) {
			if(todos.get(i).isFinished() == true) {
				finishedTodo.add(todos.get(i).getNo());
			}
		}
		//配列に格納
		int num = finishedTodo.size();
		int[] finishedNum = new int[num];
		for(int i = 0; i < num; i ++ ) {
			finishedNum[i] = finishedTodo.get(i);
		}
		return finishedNum;
	}
	//Date型からString変換-------------------------------------------------------------------------------
	public static String conversionDateToString(Date date) {
		String dateFormat = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");
		dateFormat = sdf.format(date);
		return dateFormat;
	}
	//優先度順に並び替え----------------------------------------------------------------------------------
	public static void sortPrioritye(TodoFolder todoFolder, boolean judge) {
		ArrayList<Todo> todoList = todoFolder.getTodos();
		Collections.sort(todoList, new Comparator_PriorityeTodo()); //優先度昇順
		if(judge == false) {
			Collections.reverse(todoList);// 降順
		}
	}
	//期限順に並べかえ---------------------------------------------------------------------------------------
	public static void sortLimit(TodoFolder todoFolder, boolean judge) {
		ArrayList<Todo> todoList = todoFolder.getTodos();
		Collections.sort(todoList, new Comparator_LimitTodo());//期限昇順
		if(judge == false) {
			Collections.reverse(todoList);// 降順
		}
	}
	//登録順に並び替え---------------------------------------------------------------------------------------s
	public static void sortResistration(TodoFolder todoFolder, boolean judge) {
		ArrayList<Todo> todoList = todoFolder.getTodos();
		Collections.sort(todoList, new Comparator_ResistrationTodo());//登録昇順
		if(judge == false) {
			Collections.reverse(todoList);// 降順
		}
	}
}
