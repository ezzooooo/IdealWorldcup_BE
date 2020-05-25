package com.yjy.idw.result;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("resultService")
public class ResultServiceImpl implements ResultService {
	@Autowired 
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertResult(ResultVO vo) {
		int id = sqlSessionTemplate.insert("insertResult", vo);
		return id;
	}

	@Override
	public int updateResult(ResultVO vo) {
		return sqlSessionTemplate.update("updateResult", vo);
	} 
	
	
	
}
