package model;

import java.util.Date;

public class TimeLimit {
	//  フィールド  /////////////////////////////////
	private Date now;
	//  メソッド  ///////////////////////////////////
	public void countDown() {

	}

	//  ゲッター  ///////////////////////////////////
	public Date getNow() {
		return now;
	}

	//  コンストラクタ  /////////////////////////////
	public TimeLimit() {
		this.now = new Date();
	}

}
