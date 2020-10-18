package model;

import java.util.Comparator;

public class Comparator_PriorityeTodo implements Comparator<Todo> {

	@Override
	public int compare(Todo o1, Todo o2) {

		return o1.getPrioritye() < o2.getPrioritye() ? -1 : 1;
	}

}
