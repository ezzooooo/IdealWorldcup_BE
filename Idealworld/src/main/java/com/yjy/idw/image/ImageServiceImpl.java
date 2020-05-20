package com.yjy.idw.image;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;


@Service("imageService")
public class ImageServiceImpl implements ImageService {
	
	String resource = "src/main/resources/config/mybatis-config.xml";
	
	private SqlSession sqlSession;
	
	@Override
	public void insertImage(ImageVO vo) {
		sqlSession.insert("com.yjy.idw.imageMapper.insertImage", vo);
	}
}
