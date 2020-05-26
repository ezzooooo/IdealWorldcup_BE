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
		System.out.println("----------[Result insertResult() 함수 호출]----------");
		return sqlSessionTemplate.insert("insertResult", vo);
	}

	@Override
	public void updateResult(ResultVO vo) {
		System.out.println("----------[Result updateResult() 함수 호출]----------");
		sqlSessionTemplate.update("updateResult", vo);
	}

	@Override
	public ResultVO getResult(ResultVO vo) {
		System.out.println("----------[Result getResult() 함수 호출]----------");
		ResultVO result = sqlSessionTemplate.selectOne("getResult", vo);
		return result;
	} 
	
	
	
}
