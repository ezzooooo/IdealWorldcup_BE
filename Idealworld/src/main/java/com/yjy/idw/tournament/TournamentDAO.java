package com.yjy.idw.tournament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yjy.idw.common.JDBCUtil;

@Repository("tournamentDAO")
public interface TournamentDAO {

	
	/*	
	private final String TOURNAMENT_GET = 
			"select * from TOURNAMENT where id=?";
	private final String TOURNAMENT_LIST_GET_A =
			"select * from TOURNAMENT";
	private final String TOURNAMENT_LIST_GET_T =
			"select * from TOURNAMENT where title like '%'||?||'%' order by"; 
	private final String TOURNAMENT_LIST_GET_C =
			"select * from TOURNAMENT where category like ? order by play_cnt"; 
	private final String TOURNAMENT_INSERT =
			"insert into TOURNAMENT(id, user_id, title, intro, category, isprivate) values((select ifnull(max(id),0)+1 from TOURNAMENT a),?,?,?,?,?)";
	private final String TOURNAMENT_DELETE =
			"delete TOURNAMENT where id=?";
	private final String TOURNAMENT_LIKECNT_ADD =
			"update TOURNAMENT set like_cnt=like_cnt+1 where id=?";
	private final String TOURNAMENT_LIKECNT_REMOVE =
			"update TOURNAMENT set like_cnt=like_cnt-1 where id=?";
	private final String TOURNAMENT_PLAYCNT_ADD =
			"update TOURNAMENT set play_cnt=play_cnt+1 where id=?";
			*/
	
	//토너먼트 등록
	public void insertTournament(TournamentVO vo);
	
	//토너먼트 제거 
	public void deleteTournament(int id);
	//토너먼트 목록 조회 
	//만약 title이 입력되지 않았으면 category로 검색된 상태
	//만약 category가 입력되지 않았으면 title로 검색된 상태 
	//만약 그 외의 상황이면 모든 tournament가 검색된 상태
	public List<TournamentVO> getTournamentList(String title, String category, String sortBy);
/*
		
		try {
			conn = JDBCUtil.getConnection();
			if(title.length() > 0 && category.length() <= 0) {
				stmt = conn.prepareStatement(TOURNAMENT_LIST_GET_T + " " + sortBy+ " DESC");
				stmt.setString(1, title);
			}
			else if(category.length() > 0  && title.length() <= 0) {
				stmt = conn.prepareStatement(TOURNAMENT_LIST_GET_C); 
				stmt.setString(1, category);
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
	}*/
	
	//토너먼트 상세 조회
	public TournamentVO getTournament(int id);
	
	//토너먼트 플레이 횟수 증가
	public void addPlayCnt(int id);
	
	//토너먼트 좋아요 횟수 추가 
	public void addLikeCnt(int id);
	
	//토너먼트 좋아요 횟수 감소 
	public void removeLikeCnt(int id);
}
