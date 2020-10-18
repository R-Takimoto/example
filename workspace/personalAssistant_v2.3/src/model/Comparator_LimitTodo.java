package model;

import java.util.Comparator;

public class Comparator_LimitTodo implements Comparator<Todo> {
	@Override
	public int compare(Todo o1, Todo o2) {

		return o1.getLimit().before(o2.getLimit()) ? -1 : 1;
	}

}
