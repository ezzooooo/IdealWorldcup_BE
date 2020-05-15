package com.yjy.idw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {
	
	// JDBC 관련 변수 
	private Connection conn = null; 
	private PreparedStatement stmt = null; 
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users" ;
	private final String USER_INSERT = 	"insert into board(id, nickname) values((select ifnull(max(seq),0)+1 from board),?)";

	public List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			conn = JDBCUtil.getConnection();
			conn.prepareStatement(USER_GET); 
			rs = stmt.executeQuery(); 
			while(rs.next()) {
				UserVO user = new UserVO(); 
				user.setId(rs.getInt("ID"));
				user.setNickname(rs.getString("NICKNAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return userList;
	}
	
	public void insertUser() {
		try {
			conn = JDBCUtil.getConnection(); 
			stmt = conn.prepareStatement(USER_INSERT); 
			stmt.setString(1, "LEEYUNBOK");
			stmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn); 
		}
	}
}
