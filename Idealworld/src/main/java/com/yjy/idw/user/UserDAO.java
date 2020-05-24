package com.yjy.idw.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yjy.idw.common.JDBCUtil;

@Repository("userDAO")
public interface UserDAO {
	
	
	//private final String USER_LIST_GET = "select * from USER" ;
	//private final String USER_GET = "select * from USER where id=?";
	//private final String USER_DELETE = "delete USER where id=?";
	//private final String USER_INSERT = "insert into USER(id, nickname) values((select ifnull(max(id),0)+1 from USER a),?)";
	

	public List<UserVO> getUserList(); 
	public void insertUser(UserVO vo);
	public UserVO getUser(int id); 
	public void deleteUser(int id);
}
