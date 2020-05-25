package com.yjy.idw.result;

public interface ResultService {

	//게임 결과 Insert 
	int insertResult(ResultVO vo);
	
	//게임 결과 Update 
	int updateResult(ResultVO vo);

}