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
	
	/**
	 * 두 개의 이미지에 대한 게임 결과를 추가함 
	 * @param vo ResultVO
	 * @return int
	 */
	@RequestMapping(method = RequestMethod.POST) 
	public int insertResult(ResultVO vo) {
		return resultService.insertResult(vo);
	}
	
	/**
	 * 두 개의 이미지에 대한 게임 결과를 업데이트함 
	 * @param vo ResultVO
	 */
	@RequestMapping(method = RequestMethod.PUT) 
	public void updateResult(ResultVO vo) {
		resultService.updateResult(vo);
	}
	
	/**
	 * 두 개의 이미지에 대한 게임 결과를 가져옴 
	 * @param vo ResultVO
	 * @return ResultVO
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResultVO getResult(ResultVO vo) {
		return resultService.getResult(vo);
	}

}
