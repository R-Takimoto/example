package model;

import java.util.Date;

public class Todo {
	//  フィールド  ///////////////////////////////////////////////
	private String header;//見出し
	private String body;//内容
	private int prioritye;//重要度
	private Date resistrationDate;//登録日
	private Date limit;//期限
	private boolean finished;//状態

	//  メソッド  ////////////////////////////////////////////////
	//優先度編集
	public void editPrioritye() {

	}
	//期限編集
	public void editLimit() {

	}

	//  ゲッター・セッター  /////////////////////////////////////
	public String getHeader() {
		return header;
	}

	public String getBody() {
		return body;
	}

	public int getPrioritye() {
		return prioritye;
	}
	public void setPrioritye(int prioritye) {
		this.prioritye = prioritye;
	}
	public Date getResistrationDate() {
		return resistrationDate;
	}

	public Date getLimit() {
		return limit;
	}
	public void setLimit(Date limit) {
		this.limit = limit;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	//  コンストラクタ  ////////////////////////////////////////////////
	public Todo(String header, String body, Date limit, int prioritye) {
		this.header = header;
		this.body = body;
		this.limit = limit;
		this.prioritye = prioritye;
		this.resistrationDate = new Date();
		this.finished = false;
	}

	//読み込み時用
	public Todo(String header, String body, Date resistrationDate, Date limit, int prioritye, boolean finished) {
		this.header = header;
		this.body = body;
		this.limit = limit;
		this.prioritye = prioritye;
		this.resistrationDate = resistrationDate;
		this.finished = finished;
	}
}