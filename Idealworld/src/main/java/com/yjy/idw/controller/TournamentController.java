package com.yjy.idw.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjy.idw.tournament.TournamentService;
import com.yjy.idw.tournament.TournamentVO;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
	@Autowired
	TournamentService service;

	@RequestMapping(method = RequestMethod.POST)
	public void insertTournament(TournamentVO vo) {
		service.insertTournament(vo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
	public void deleteTournament(String id) {
		service.deleteTournament(Integer.parseInt(id.replaceAll("id=", "")));
	}

	// 잠시 김보류 
	@RequestMapping(method = RequestMethod.GET, value = "/{title}/{category}/{sortby}")
	public List<TournamentVO> getTournamentList(String title, String category, String sortBy) {
		return service.getTournamentList(title, category, sortBy);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public TournamentVO getTournament(String id) {
		return service.getTournament(Integer.parseInt(id.replaceAll("id=", "")));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/playcnt", value = "/{id}")
	public void addPlayCnt(String id) {
		service.addPlayCnt(Integer.parseInt(id.replaceAll("id=", "")));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/likecnt", value = "/{id}")
	public void addLikeCnt(String id) {
		service.addLikeCnt(Integer.parseInt(id.replaceAll("id=", "")));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/unlikecnt", value = "/{id}")
	public void removeLikeCnt(String id) {
		service.removeLikeCnt(Integer.parseInt(id.replaceAll("id=", "")));
	}
	
}
