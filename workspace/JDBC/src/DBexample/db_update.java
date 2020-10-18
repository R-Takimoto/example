package DBexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class db_update {

	public static void main(String[] args) {

		// TODO 自動生成されたメソッド・スタブ

		//変数定義
		Connection conn = null;
		PreparedStatement ps = null;

		//DB接続情報を設定する
		final String PATH = "jdbc:mysql://localhost:3306/jdbctest?characterEncoding=UTF-8&serverTimezone=JST";
		final String USER = "root"; //ログインID
		final String PASS = "root"; //ログインパスワード

		//SQL文を定義する
		String sql = "UPDATE user_master SET address = ?, tel = ? WHERE no = ?";

		try {

			//JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//DBへのコネクションを作成する
			conn = DriverManager.getConnection(PATH, USER, PASS);
			conn.setAutoCommit(false); //オートコミットはオフ

			//実行するSQL文とパラメータを指定する
			ps = conn.prepareStatement(sql);
			ps.setString(1, "兵庫県神戸市");
			ps.setString(2, "078-999-9999");
			ps.setInt(3, 2);

			//updateを実行する
			int num = ps.executeUpdate();

			//処理件数を表示する
			System.out.println("結果：" + num);

			//コミット
			conn.commit();

		} catch (ClassNotFoundException e) {
			//例外発生時の処理
			//conn.rollback();       //ロールバックする
			System.out.println("ドライバーを読み込めません。");
		} catch (SQLException e) {
			//例外発生時の処理
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			} //ロールバックする
			System.out.println("データベース接続エラー。");
		} catch (Exception e) {
			//例外発生時の処理
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			} //ロールバックする
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

	}

}
