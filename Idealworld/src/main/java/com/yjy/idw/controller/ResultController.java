package com.yjy.idw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjy.idw.result.ResultService;
import com.yjy.idw.result.ResultVO;

@RestController
@RequestMapping("/results")
public class ResultController {
	@Autowired 
	ResultService resultService;
	
	@RequestMapping(method = RequestMethod.POST) 
	public int insertResult(ResultVO vo) {
		return resultService.insertResult(vo);
	}
	
	@RequestMapping(method = RequestMethod.PUT) 
	public int updateResult(ResultVO vo) {
		return resultService.updateResult(vo);
	}

}
