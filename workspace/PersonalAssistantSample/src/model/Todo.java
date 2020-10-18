package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
	private Date registerDate;
	private int priority;
	private Date dueDate;
	private String header;
	private String body;
	private boolean done;

	public Todo(int priority, Date dueDate, String header, String body) {
		this.registerDate = new Date();
		this.priority = priority;
		this.dueDate = dueDate;
		this.header = header;
		this.body = body;
		this.done = false;
	}

	public String getDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String s = sdf.format(date);
		return s;
	}

	public String getRegisterDate() {
		return this.getDate(this.registerDate);
	}

	public int getPriority() {
		return priority;
	}

	public String getDueDate() {
		return this.getDate(this.dueDate);
	}

	public String getHeader() {
		return header;
	}

	public String getBody() {
		return body;
	}

	public boolean isDone() {
		return done;
	}
	
	public String getDone() {
		if(this.done) {
			return "完了";
		}else {
			return "未完了";
		}
	}

}
