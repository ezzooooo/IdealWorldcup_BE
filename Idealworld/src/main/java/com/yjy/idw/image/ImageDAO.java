package com.yjy.idw.image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.yjy.idw.common.JDBCUtil;

@Repository("imageDAO")
public class ImageDAO {
		// JDBC 관련 변수 
		private Connection conn = null; 
		private PreparedStatement stmt = null; 
		private ResultSet rs = null;
		
		//SQL 명령어 
		private final String IMAGE_INSERT = 
				"insert into IMAGE(id, tournament_id, name, URL, win_cnt) "
				+ "values((select ifnull(max(id),0)+1 from IMAGE a), ?, ?, ?, ?)";
		
		public void insertImage(ImageVO vo) {
			System.out.println("=> 이미지 업로드");
			
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(IMAGE_INSERT);
				stmt.setInt(1, 1);
				stmt.setString(2, vo.getName());
				stmt.setString(3, vo.getURL());
				stmt.setInt(4, 0);
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
}
