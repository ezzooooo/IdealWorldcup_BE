package com.yjy.idw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yjy.idw.common.JDBCUtil;

@Repository("userDAO")
public class UserDAO {
	
	// JDBC 관련 변수 
	private Connection conn = null; 
	private PreparedStatement stmt = null; 
	private ResultSet rs = null;
	
	private final String USER_LIST_GET = "select * from USER" ;
	private final String USER_GET = "select * from USER where id=?";
	private final String USER_DELETE = "delete USER where id=?";
	private final String USER_INSERT = "insert into USER(id, nickname) values((select ifnull(max(id),0)+1 from USER a),?)";

	public List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST_GET); 
			rs = stmt.executeQuery(); 
			while(rs.next()) {
				UserVO user = new UserVO(); 
				user.setId(rs.getInt("ID"));
				user.setNickname(rs.getString("NICKNAME"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return userList;
	}
	
	public void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection(); 
			stmt = conn.prepareStatement(USER_INSERT); 
			stmt.setString(1, vo.getNickname());
			stmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn); 
		}
	}
	
	public UserVO getUser(int id) {
		UserVO user = new UserVO();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET); 
			stmt.setInt(1, id);
			rs = stmt.executeQuery(); 
			if(rs.next()) {
				user.setId(rs.getInt("ID")); 
				user.setNickname(rs.getString("NICKNAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;
	}
	
	public void deleteUser(int id) {
		try {
			conn = JDBCUtil.getConnection(); 
			stmt = conn.prepareStatement(USER_DELETE); 
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
