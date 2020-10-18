package model;

import java.util.ArrayList;
import java.util.List;

public class Todos {
	private List<Todo> todos;

	public Todos() {
		this.todos = new ArrayList<>();
	}

	public void add(Todo todo) {
		this.todos.add(todo);
	}

	public int getTodosSize() {
		return this.todos.size();
	}

	public List<Todo> getTodos() {
		return todos;
	}
	
	
}
