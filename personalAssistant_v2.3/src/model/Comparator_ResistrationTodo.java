package model;

import java.util.Comparator;

public class Comparator_ResistrationTodo implements Comparator<Todo> {

	@Override
	public int compare(Todo o1, Todo o2) {

		return o1.getNo() < o2.getNo() ? -1 : 1;
	}

}
