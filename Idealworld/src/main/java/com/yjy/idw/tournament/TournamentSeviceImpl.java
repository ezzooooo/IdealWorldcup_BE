package com.yjy.idw.tournament;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tournamentService")
public class TournamentSeviceImpl implements TournamentService {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertTournament(TournamentVO vo) {
		sqlSessionTemplate.insert("insertTournament", vo);
	}

	@Override
	public void deleteTournament(int id) {
		sqlSessionTemplate.delete("deleteTournament", id);
	}

	@Override
	public List<TournamentVO> getTournamentList(TournamentVO vo) {
		List<TournamentVO> tournamentList = sqlSessionTemplate.selectList("getTournamentList", vo);
		return tournamentList;
	}

	@Override
	public TournamentVO getTournament(int id) {
		TournamentVO tournament = sqlSessionTemplate.selectOne("getTournament", id);
		return tournament;
	}

	@Override
	public void addPlayCnt(int id) {
		sqlSessionTemplate.update("addPlayCnt");
	}

	@Override
	public void addLikeCnt(int id) {
		sqlSessionTemplate.update("addLikeCnt");
	}

	@Override
	public void removeLikeCnt(int id) {
		sqlSessionTemplate.update("removeLikeCnt");
	}

}
