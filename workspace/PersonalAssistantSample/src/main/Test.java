package main;

import java.util.Calendar;
import java.util.Date;

import model.Todo;
import model.Todos;

public class Test {

	public static void main(String[] args) {
		Todos list = createNewTodo();
		showTodos(list);
	}

	public static Todos createNewTodo() {
		//新しいtodoを作成(1)
		//優先順位
		int priority = 3;
		//期日2020/12/01
		Calendar c = Calendar.getInstance();
		c.set(2020,12,1,0,0,0);
		Date dueDate = c.getTime();
		//タイトル
		String header = "タイトル";
		//内容
		String body = "内容を入力";
		Todo td1 = new Todo(priority,dueDate,header,body);


		//新しいtodoを作成(2)
		//優先順位
		priority = 2;
		//期日2020/11/01
		c = Calendar.getInstance();
		c.set(2020,11,1,0,0,0);
		dueDate = c.getTime();
		//タイトル
		header = "タイトル2";
		//内容
		body = "内容2を入力";
		Todo td2 = new Todo(priority,dueDate,header,body);

		//新しいtodoを作成(3)
		//優先順位
		priority = 1;
		//期日2020/10/01
		c = Calendar.getInstance();
		c.set(2020,10,1,0,0,0);
		dueDate = c.getTime();
		//タイトル
		header = "タイトル3";
		//内容
		body = "内容3を入力";
		Todo td3 = new Todo(priority,dueDate,header,body);

		Todos tds = new Todos();
		tds.add(td1);
		tds.add(td2);
		tds.add(td3);

		return tds;
	}

	public static void showTodos(Todos todos) {
		System.out.println("todosの要素数は"+todos.getTodosSize()+"です");
		for(Todo todo : todos.getTodos()) {
			System.out.println("---------------");
			System.out.println("登録日:"+todo.getRegisterDate());
			System.out.println("優先順位:"+ todo.getPriority());
			System.out.println("期日:"+ todo.getDueDate());
			System.out.println("見出し:"+ todo.getHeader());
			System.out.println("内容:"+ todo.getBody());
			System.out.println("状態:"+ todo.getDone());
		}
	}

}
