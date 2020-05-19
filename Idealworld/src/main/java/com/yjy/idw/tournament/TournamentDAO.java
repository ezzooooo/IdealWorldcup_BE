package com.yjy.idw.tournament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.yjy.idw.common.JDBCUtil;

@Repository("tournamentDAO")
public class TournamentDAO {
	// JDBC 관련 변수 
	private Connection conn = null; 
	private PreparedStatement stmt = null; 
	private ResultSet rs = null;
	
	//SQL 명령어
	private final String TOURNAMENT_GET = 
			"select * from TOURNAMENT where id=?";
	private final String TOURNAMENT_LIST_GET_A =
			"select * from TOURNAMENT";
	private final String TOURNAMENT_LIST_GET_T =
			"select * from TOURNAMENT where title like '%'||?||'%' order by"; 
	private final String TOURNAMENT_LIST_GET_C =
			"select * from TOURNAMENT where category like ? order by play_cnt"; 
	private final String TOURNAMENT_INSERT =
			"insert into TOURNAMENT(id, user_id, title, intro, category, isprivate, like_cnt, play_cnt) values((select nvl(max(id),0)+1 from TOURNAMENT),?,?,?,?,?,?,?)";
	private final String TOURNAMENT_DELETE =
			"delete TOURNAMENT where id=?";
	private final String TOURNAMENT_LIKECNT_ADD =
			"update TOURNAMENT set like_cnt=like_cnt+1";
	private final String TOURNAMENT_LIKECNT_REMOVE =
			"update TOURNAMENT set like_cnt=like_cnt-1";
	private final String TOURNAMENT_PLAYCNT_ADD =
			"update TOURNAMENT set play_cnt=play_cnt+1";
	
	//토너먼트 등록
	public void insetTournament(TournamentVO vo) {
		System.out.println("===> JDBC로 insertTournament() 기능 처리");
		try {
			conn = JDBCUtil.getConnection(); 
			stmt = conn.prepareStatement(TOURNAMENT_INSERT);
			stmt.setInt(1, vo.getUser_id());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getIntro());
			stmt.setString(4, vo.getCategory());
			stmt.setBoolean(5, vo.getIsPrivate());
			// DB 테이블 default 0 으로 수정해야함 
			stmt.setInt(6, 0);
			stmt.setInt(7, 0);
			stmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//토너먼트 제거 
	public void deleteTournament(int id) {
		System.out.println("===> JDBC로 deleteTournament() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TOURNAMENT_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
