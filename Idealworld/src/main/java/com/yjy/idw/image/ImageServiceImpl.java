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
	public int deleteImage(int id) {
		System.out.println("----------[이미지 Delete 함수 호출]----------");
		return sqlSessionTemplate.delete("deleteImage", id);
	}
	
	@Override
	public List<ImageVO> getImageList(ImageVO vo) {
		System.out.println("----------[토너먼트 ID로 이미지리스트를 가져오는 함수 호출]----------");
		List<ImageVO> imageList = sqlSessionTemplate.selectList("getImageList", vo);
		return imageList;
	}

	@Override
	public void addWinCnt(int id) {
		System.out.println("----------[우승한 이미지 win_cnt++ 함수 호출]----------");
		sqlSessionTemplate.update("addWinCnt", id);
	}

	@Override
	public List<ImageVO> getWinnerList(int tournament_id) {
		System.out.println("----------[win_cnt 횟수 1, 2번째로 많은 이미지 가져오는 함수 호출]----------");
		List<ImageVO> winnerList = sqlSessionTemplate.selectList("getWinnerList", tournament_id);
		return winnerList;
	}
}
