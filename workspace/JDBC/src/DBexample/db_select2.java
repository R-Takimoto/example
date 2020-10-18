package DBexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class db_select2 {

	public static void main(String[] args) {

		// TODO 自動生成されたメソッド・スタブ

		//変数定義
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//DB接続情報を設定する
		final String PATH = "jdbc:mysql://localhost:3306/lesson3?characterEncoding=UTF-8&serverTimezone=JST";
		final String USER = "root"; //ログインID
		final String PASS = "root"; //ログインパスワード

		//SQL文を定義する
		String sql = "SELECT 日付, 名前 AS 費目, 備考, 入金額, 出金額 FROM  家計簿 JOIN 費目 ON 家計簿.費目ID = 費目.ID WHERE 日付 > '2018/02/04'";

		try {

			//JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//DBへのコネクションを作成する
			conn = DriverManager.getConnection(PATH, USER, PASS);

			//実行するSQL文とパラメータを指定する
			ps = conn.prepareStatement(sql);
//			ps.setInt(1, 2);

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
			NumberFormat money = NumberFormat.getNumberInstance();

			int allN = 0;
			int allS = 0;
			while (rs.next()) {
				String hiduke = rs.getString("日付");
				String hidukeR = hiduke.replace("-", "/");
//				int himoku = rs.getInt("費目ID");
				String name = rs.getString("費目");
				String bikou = rs.getString("備考");
				int nyukin = rs.getInt("入金額");
				String nyu = "";
				if(nyukin != 0) {
					nyu = String.valueOf(money.format(nyukin));
				}
				int syukin = rs.getInt("出金額");

				allN += nyukin;
				allS += syukin;
				System.out.println(
						"日付:" + hidukeR + " 費目:" + name + " 備考:" + bikou + " 入金額:" + nyu + "出金額:" + syukin);
			}
			System.out.println("入金計：" + allN + "出金計:" + allS);

		} catch (ClassNotFoundException e) {
			System.out.println("ドライバーを読み込めません。");
		} catch (SQLException e) {
			System.out.println(e);
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
