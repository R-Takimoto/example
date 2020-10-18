package DBexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class db_select {

	public static void main(String[] args) {

		// TODO 自動生成されたメソッド・スタブ

		//変数定義
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//DB接続情報を設定する
		final String PATH = "jdbc:mysql://localhost:3306/jdbctest?characterEncoding=UTF-8&serverTimezone=JST";
		final String USER = "root"; //ログインID
		final String PASS = "root"; //ログインパスワード

		//SQL文を定義する
		String sql = "SELECT * FROM user_master WHERE no = ?";

		try {

			//JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//DBへのコネクションを作成する
			conn = DriverManager.getConnection(PATH, USER, PASS);

			//実行するSQL文とパラメータを指定する
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 2);

			//SELECTを実行する
			rs = ps.executeQuery();

			//こんなふうにカラム数なども取得できちゃう
			/*
			 * java.sql.PreparedStatement.executeQuery()
			 * でSQL文を実行したりすると返ってくる
			 * java.sql.ResultSet には行数をgetする関数は用意されてないので、
			 * 以下のように最後の行に移ってgetRow()するといった処理で行数を得ます。
			 *
			 */
			rs.last();
			int colCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("取得したカラム数:" + colCount);

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				System.out.println(
						"no:" + no + " name:" + name + " address:" + address + " tel:" + tel);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ドライバーを読み込めません。");
		} catch (SQLException e) {
			System.out.println("データベース接続エラー。");
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

	}

}
