package com.yjy.idw.result;

import org.springframework.stereotype.Repository;

@Repository("resultDAO")
interface ResultDAO { 
	//게임 결과 Insert 
	int insertResult(ResultVO vo);
	
	//게임 결과 Update 
	int updateResult(ResultVO vo); 
	
	//게임 결과 get 
	ResultVO getResult(ResultVO vo);
}
