package com.yjy.idw.image;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ImageService")
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertImage(ImageVO vo) {	
		System.out.println("----------[이미지 Insert 함수 호출]----------");
		return sqlSessionTemplate.insert("insertImage", vo);
	}
	
	@Override
	public List<ImageVO> getImageList(int tournament_id) {
		System.out.println("----------[토너먼트 ID로 이미지리스트를 가져오는 함수 호출]----------");
		List<ImageVO> imageList = sqlSessionTemplate.selectList("getImageList", tournament_id);
		return imageList;
	}

	@Override
	public void addWinCnt(int id) {
		System.out.println("----------[우승한 이미지 win_cnt++ 함수 호출]----------");
		sqlSessionTemplate.update("addWinCnt", id);
	}
	
	
}
