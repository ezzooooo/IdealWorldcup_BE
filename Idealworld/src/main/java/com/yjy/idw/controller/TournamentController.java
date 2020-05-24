package com.yjy.idw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteTournament(@PathVariable(value="id") String id) {
		service.deleteTournament(Integer.parseInt(id.replaceAll("id=", "")));
	}

	@RequestMapping(method = RequestMethod.GET, value = "")
	public List<TournamentVO> getTournamentListByTitle(TournamentVO vo) {
		return service.getTournamentList(vo);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public TournamentVO getTournament(@PathVariable(value="id") String id) {
		return service.getTournament(Integer.parseInt(id));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/playcnt/{id}")
	public void addPlayCnt(@PathVariable(value="id") String id) {
		service.addPlayCnt(Integer.parseInt(id));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/likecnt/{id}")
	public void addLikeCnt(@PathVariable(value="id") String id) {
		service.addLikeCnt(Integer.parseInt(id));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/unlikecnt/{id}")
	public void removeLikeCnt(@PathVariable(value="id") String id) {
		service.removeLikeCnt(Integer.parseInt(id));
	}
}	

