package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jp.co.aforce.bean.Bean;

public class MemberDAO extends DAO{

	//検索を行うsearchメソッド
	public int search(Bean bean)
			throws Exception{

			//DBに接続
			Connection con = getConnection();
			//SQL文の実行
			PreparedStatement st = con.prepareStatement( "select count(*) as record_count from member_info "
					+ "where last_name = ? and first_name = ? and sex = ? and birth_year =? and birth_month =? and birth_day =? and job =? and phone_number =? and mail_address =?");
			//変数sqlの〇番目に引数をセットする
			st.setString(1, bean.getLast_name());
			st.setString(2, bean.getFirst_name());
			st.setString(3, bean.getSex());
			st.setInt(4, bean.getBirth_year());
			st.setInt(5, bean.getBirth_month());
			st.setInt(6, bean.getBirth_day());
			st.setString(7, bean.getJob());
			st.setString(8, bean.getPhone_number());
			st.setString(9, bean.getMail_address());

			//sqlを実行し該当するデータ格納
			ResultSet rs = st.executeQuery();
			int count =0;

			while(rs.next()) {
				count=rs.getInt("record_count");
			}

			//DBからの切断
			st.close();
			con.close();

		return count;
	}

	//追加を行うinsertメソッド
	public int insert(Bean bean) throws Exception {
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"insert into member_info (member_id,last_name,first_name,sex,birth_year,birth_month,birth_day,job,phone_number,mail_address)"
					+ "values(?,?,?,?,?,?,?,?,?,?)");
			// 現在日時を取得
			LocalDateTime date = LocalDateTime.now();
			// 表示形式を指定
			DateTimeFormatter dtformat =
					DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

			String fdate = dtformat.format(date);

			//変数sqlの〇番目に引数をセットする
			st.setString(1,"A"+ fdate);
			st.setString(2, bean.getLast_name());
			st.setString(3, bean.getFirst_name());
			st.setString(4, bean.getSex());
			st.setInt(5, bean.getBirth_year());
			st.setInt(6, bean.getBirth_month());
			st.setInt(7, bean.getBirth_day());
			st.setString(8, bean.getJob());
			st.setString(9, bean.getPhone_number());
			st.setString(10, bean.getMail_address());

			int new_member=st.executeUpdate();

			st.close();
			con.close();
			return new_member;
	}

	//入力された会員番号に一致する会員情報のデータを検索する
	public Bean findByMemberId(String member_id) throws Exception{

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select last_name,first_name,sex,birth_year,birth_month,birth_day,job,phone_number,mail_address"
			  + " from member_info where member_id = ?");

			//変数sqlの一番目の?に引数のmember_idをセットする
			st.setString(1, member_id);
			//sqlを実行し該当するデータ格納
			ResultSet rs = st.executeQuery();

			Bean  memberBean = new Bean();

			while(rs.next()) {
				memberBean.setLast_name(rs.getString("last_name"));
				memberBean.setFirst_name(rs.getString("first_name"));
				memberBean.setSex(rs.getString("sex"));
				memberBean.setBirth_year(rs.getInt("birth_year"));
				memberBean.setBirth_month(rs.getInt("birth_month"));
				memberBean.setBirth_day(rs.getInt("birth_day"));
				memberBean.setJob(rs.getString("job"));
				memberBean.setPhone_number(rs.getString("phone_number"));
				memberBean.setMail_address(rs.getString("mail_address"));
			}

			st.close();
			con.close();

		return memberBean;
	}

	//更新を行うupdateメソッド
	public void update(Bean bean, String member_id) throws Exception {
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"update member_info set"
					+ "last_name = ? and first_name = ? and sex = ? and birth_year =? and birth_month =? and birth_day =? and job =? and phone_number =? and mail_address =? "
					+ "where member_id = ?");

			//変数sqlの〇番目に引数をセット
			st.setString(1, bean.getLast_name());
			st.setString(2, bean.getFirst_name());
			st.setString(3, bean.getSex());
			st.setInt(4, bean.getBirth_year());
			st.setInt(5, bean.getBirth_month());
			st.setInt(6, bean.getBirth_day());
			st.setString(7, bean.getJob());
			st.setString(8, bean.getPhone_number());
			st.setString(9, bean.getMail_address());

			st.executeUpdate();

			st.close();
			con.close();
	}

	//削除を行うdeleteメソッド
	public int delete(String member_id) throws Exception {
		Connection con = getConnection();

		PreparedStatement st=con.prepareStatement(
				"delete from member_info where member_id =?");

		st.setString(1, member_id);

		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}
