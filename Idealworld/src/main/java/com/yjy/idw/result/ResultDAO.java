package com.yjy.idw.result;

import org.springframework.stereotype.Repository;

@Repository("resultDAO")
interface ResultDAO { 
	//게임 결과 Insert 
	int insertResult(ResultVO vo);
}
