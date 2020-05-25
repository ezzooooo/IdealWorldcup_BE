package com.yjy.idw.image;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ImageService")
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertImage(ImageVO vo) {	
		return sqlSessionTemplate.insert("insertImage");
	}
}
