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

	
	/**
	 * 토너먼트를 추가함
	 * @param vo TournamentVO
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void insertTournament(TournamentVO vo) {
		service.insertTournament(vo);
	}

	/**
	 * id값에 알맞은 토너먼트를 제거함 
	 * @param id int
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteTournament(@PathVariable(value="id")int id) {
		service.deleteTournament(id);
	}
	
	/**
	 * 인자에 알맞은 토너먼트 리스트를 받아옴 
	 * @param vo TournamentVO
	 * @return List 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<TournamentVO> getTournamentList(TournamentVO vo) {
		return service.getTournamentList(vo);
	}

	/**
	 * id값에 알맞은 토너먼트 정보를 받아옴 
	 * @param id int
	 * @return TournamentVO
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public TournamentVO getTournament(@PathVariable(value="id")int id) {
		return service.getTournament(id);
	}
	
	/**
	 * id값에 알맞은 토너먼트의 플레이 카운트를 증가함
	 * @param id int 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/playcnt/{id}")
	public void addPlayCnt(@PathVariable(value="id")int id) {
		service.addPlayCnt(id);
	}
	
	
	/**
	 * id값에 알맞은 토너먼트의 좋아요 카운트를 증가함
	 * @param id int 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/likecnt/{id}")
	public void addLikeCnt(@PathVariable(value="id")int id) {
		service.addLikeCnt(id);
	}

	
	/**
	 * id값에 알맞은 토너먼트의 좋아요 카운트를 감소시킴
	 * @param id int 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/unlikecnt/{id}")
	public void removeLikeCnt(@PathVariable(value="id")int id) {
		service.removeLikeCnt(id);
	}
}	

