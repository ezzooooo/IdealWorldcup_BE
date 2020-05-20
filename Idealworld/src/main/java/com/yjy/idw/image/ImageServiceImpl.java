package com.yjy.idw.image;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjy.idw.mybatis.MyBatisConnectionFactory;


@Service("ImageService")
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	ImageDAO image = sqlSession.getMapper(ImageDAO.class);
	
	@Override
	public int insertImage(ImageVO vo) {
		System.out.println("여기1");
		int id = image.insertImage(vo); 
		System.out.println("여기2");
		
		return id;
	}
}
