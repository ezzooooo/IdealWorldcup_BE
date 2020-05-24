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
	
	//토너먼트 등록
	public void insertTournament(TournamentVO vo);
	
	//토너먼트 제거 
	public void deleteTournament(int id);
	//토너먼트 목록 조회 
	//만약 title이 입력되지 않았으면 category로 검색된 상태
	//만약 category가 입력되지 않았으면 title로 검색된 상태 
	//만약 그 외의 상황이면 모든 tournament가 검색된 상태
	public List<TournamentVO> getTournamentList(TournamentVO vo);
	
	//토너먼트 상세 조회
	public TournamentVO getTournament(int id);
	
	//토너먼트 플레이 횟수 증가
	public void addPlayCnt(int id);
	
	//토너먼트 좋아요 횟수 추가 
	public void addLikeCnt(int id);
	
	//토너먼트 좋아요 횟수 감소 
	public void removeLikeCnt(int id);
}
