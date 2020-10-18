package mojiretu;

public class StringTest04 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		StringBuilder sb = new StringBuilder() ;

		boolean sFlag = false ;
		boolean eFlag = false ;

		String sDate = "2018-02-01" ;
		String eDate = "2018-03-01" ;

		sb.append("select * from 家計簿 ");

		if( sFlag ) {
			sb.append("where 日付>='" + sDate + "'");
		}

		if( eFlag ) {
			if( sFlag ) {
				sb.append(" and 日付<='" + eDate + "'");
			}else {
				sb.append("where 日付<='" + eDate + "'");
			}
		}

		String s = sb.toString();

		System.out.println("sql=" + s );

	}

}
