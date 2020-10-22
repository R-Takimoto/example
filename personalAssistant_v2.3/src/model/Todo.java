package model;

import java.util.Date;

public class Todo {
	//  フィールド  /////////////////////////////////////////////////////////////////////////////////////////
	private int no;//Todoナンバー
	private String header;//見出し
	private String body;//内容
	private int prioritye;//重要度
	private Date resistrationDate;//登録日時
	private Date limit;//期限
	private boolean finished;//状態

//  コンストラクタ  /////////////////////////////////////////////////////////////////////////////////////////
	public Todo(String header, String body, Date limit, int prioritye) {
		this.header = header;
		this.body = body;
		this.limit = limit;
		this.prioritye = prioritye;
		this.resistrationDate = new Date();
		this.finished = false;
	}

	//読み込み時用
	public Todo(int no, String header, String body, Date resistrationDate, Date limit, int prioritye, boolean finished) {
		this.no = no;
		this.header = header;
		this.body = body;
		this.limit = limit;
		this.prioritye = prioritye;
		this.resistrationDate = resistrationDate;
		this.finished = finished;
	}

	//  ゲッター・セッター  //////////////////////////////////////////////////////////////////////////////////////////////////
	public int getNo() {
		return no;
	}

	public void setNO(int no) {
		this.no = no;
	}

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


}
