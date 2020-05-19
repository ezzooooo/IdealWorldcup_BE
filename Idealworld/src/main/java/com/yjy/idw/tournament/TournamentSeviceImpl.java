package com.yjy.idw.tournament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tournamentService")
public class TournamentSeviceImpl implements TournamentService {
	
	@Autowired 
	TournamentDAO tournamentDAO;
	
	@Override
	public void insertTournament(TournamentVO vo) {
		tournamentDAO.insertTournament(vo);
	}

	@Override
	public void deleteTournament(int id) {
		tournamentDAO.deleteTournament(id);
	}

	@Override
	public List<TournamentVO> getTournamentList(String title, String category, String sortBy) {
		// TODO Auto-generated method stub
		return tournamentDAO.getTournamentList(title, category, sortBy);
	}

	@Override
	public TournamentVO getTournament(int id) {
		// TODO Auto-generated method stub
		return tournamentDAO.getTournament(id);
	}

	@Override
	public void addPlayCnt(int id) {
		tournamentDAO.addPlayCnt(id);
	}

	@Override
	public void addLikeCnt(int id) {
		tournamentDAO.addLikeCnt(id);
	}

	@Override
	public void removeLikeCnt(int id) {
		tournamentDAO.removeLikeCnt(id);
	}

}
