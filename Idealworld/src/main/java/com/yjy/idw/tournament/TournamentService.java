package com.yjy.idw.tournament;

import java.util.List;

public interface TournamentService {

	//토너먼트 등록
	void insertTournament(TournamentVO vo);

	//토너먼트 제거 
	void deleteTournament(int id);

	//토너먼트 목록 조회 
	//만약 title이 null이면 category로 검색된 상태
	//만약 category가 null이면 title로 검색된 상태
	//만약 그 외의 상황이면 모든 tournament가 검색된 상태
	List<TournamentVO> getTournamentList(String title, String category, String sortBy);

	//토너먼트 상세 조회
	TournamentVO getTournament(int id);

	//토너먼트 플레이 횟수 증가
	void addPlayCnt(int id);

	//토너먼트 좋아요 횟수 추가 
	void addLikeCnt(int id);

	//토너먼트 좋아요 횟수 감소 
	void removeLikeCnt(int id);

}