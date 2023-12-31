package com.ys.sbbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ys.sbbs.entity.Reply;
import com.ys.sbbs.entity.User;
public class OracleSelect {

	public static void main(String[] args) throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "c##ysuser";
		String password = "yspass";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		String sql = "select * from users";
		
		ResultSet rs = stmt.executeQuery(sql);
		List<User> list = new ArrayList<>();
		while (rs.next()) {
			String uid = rs.getString(1);
			String pwd = rs.getString(2);
			String uname = rs.getString(3);
			String email = rs.getString(4);
			LocalDate regDate = LocalDate.parse(rs.getString(5).substring(0, 10));
			int isDeleted = rs.getInt(6);
			String profile = rs.getString(7);
			String addr = rs.getString(8);
			User user = new User(uid, pwd, uname, email, regDate, isDeleted, profile, addr);
			list.add(user);
			
		}
		rs.close(); stmt.close(); 
		list.forEach(x -> System.out.println(x));
		System.out.println("=================================================================");
		
		
		// Reply table
		sql = "select r.rid, r.\"comment\", r.regTime, r.isMine, r.\"uid\", r.bid, u.uname"
				+ " from reply r join users u on r.\"uid\"=u.\"uid\" where bid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,  1001);
		rs = pstmt.executeQuery();
		List<Reply> list2 = new ArrayList<>();
		while (rs.next()) {
			int rid = rs.getInt(1);
			String comment = rs.getString(2);
			LocalDateTime regTime = LocalDateTime.parse(rs.getString(3).substring(0,19).replace(" ", "T"));
			int isMine = rs.getInt(4);
			String uid = rs.getString(5);
			int bid = rs.getInt(6);
			String uname = rs.getString(7);
			Reply reply = new Reply(rid, comment, regTime, isMine, uid, bid, uname);
			list2.add(reply);
					
		}
		rs.close(); pstmt.close(); conn.close();
		list2.forEach(x -> System.out.println(x));
	}

}
