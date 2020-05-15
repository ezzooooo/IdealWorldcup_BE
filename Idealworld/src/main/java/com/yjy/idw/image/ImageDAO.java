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
				"insert into image(path) values(?)";
		
		public void insertImage(ImageVO vo) {
			System.out.println("=> 이미지 업로드");
			
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(IMAGE_INSERT);
				stmt.setString(1, vo.getPath());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
}
