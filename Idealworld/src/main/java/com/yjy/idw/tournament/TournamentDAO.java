package com.yjy.idw.tournament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public void insertTournament(TournamentVO vo) {
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
	
	//토너먼트 목록 조회 
	//만약 title이 null이면 category로 검색된 상태
	//만약 category가 null이면 title로 검색된 상태
	//만약 그 외의 상황이면 모든 tournament가 검색된 상태
	public List<TournamentVO> getTournamentList(String title, String category, String sortBy) {
		System.out.println("===> JDBC로 getTournamentList() 기능 처리"); 
		List<TournamentVO> tournamentList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			if(title == null) {
				stmt = conn.prepareStatement(TOURNAMENT_LIST_GET_C);
				stmt.setString(1, category);
			}
			else if(category == null) {
				stmt = conn.prepareStatement(TOURNAMENT_LIST_GET_T + " " + sortBy);
				stmt.setString(1, title);
			}
			else {
				stmt = conn.prepareStatement(TOURNAMENT_LIST_GET_A);
			}
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				TournamentVO tournament = new TournamentVO(); 
				tournament.setId(rs.getInt("ID"));
				tournament.setUser_id(rs.getInt("user_id"));
				tournament.setTitle(rs.getString("title"));
				tournament.setIntro(rs.getString("intro"));
				tournament.setCategory(rs.getString("category"));
				tournament.setLike_cnt(rs.getInt("like_cnt"));
				tournament.setPlay_cnt(rs.getInt("play_cnt"));
				tournamentList.add(tournament);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn); 
		}
		
		return tournamentList; 
	}
	
	//토너먼트 상세 조회
	public TournamentVO getTournament(int id) {
		System.out.println("===> JDBC로 getTournament() 기능 처리");
		TournamentVO tournament = new TournamentVO();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TOURNAMENT_GET);
			stmt.setInt(1, id); 
			rs = stmt.executeQuery();
			if(rs.next()) {
				tournament.setId(rs.getInt("ID"));
				tournament.setUser_id(rs.getInt("user_id"));
				tournament.setTitle(rs.getString("title"));
				tournament.setIntro(rs.getString("intro"));
				tournament.setCategory(rs.getString("category"));
				tournament.setLike_cnt(rs.getInt("like_cnt"));
				tournament.setPlay_cnt(rs.getInt("play_cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	
		return tournament;
	}
	
	//토너먼트 플레이 횟수 증가
	public void addPlayCnt(int id) {
		System.out.println("===> JDBC로 addPlayCnt() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TOURNAMENT_LIKECNT_ADD);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//토너먼트 좋아요 횟수 추가 
	public void addLikeCnt(int id) {
		System.out.println("===> JDBC로 addPlayCnt() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TOURNAMENT_LIKECNT_REMOVE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//토너먼트 좋아요 횟수 감소 
	public void removeLikeCnt(int id) {
		System.out.println("===> JDBC로 addPlayCnt() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TOURNAMENT_PLAYCNT_ADD);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
