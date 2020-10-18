package model;

import java.util.Comparator;

public class TodoComparatorLimit implements Comparator<Todo> {
	@Override
	public int compare(Todo o1, Todo o2) {

		return o1.getLimit().after(o2.getLimit()) ? -1 : 1;
	}

}
