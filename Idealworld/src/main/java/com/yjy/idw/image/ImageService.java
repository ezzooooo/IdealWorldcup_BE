package com.yjy.idw.image;

import java.util.List;

public interface ImageService {
	
	/*
	 * Image를 삽입하는 함수
	 */
	int insertImage(ImageVO vo);
	
	/*
	 * Image를 삭제하는 함수
	 */
	int deleteImage(int id);
	
	/*
	 * 토너먼트 id가 일치하는 이미지 목록을 가져오는 함수
	 * round가 존재할 경우 랜덤으로 round만큼의 이미지만 반환.
	 */
	List<ImageVO> getImageList(ImageVO vo);
	
	/*
	 * 우승한 이미지 Win_Cnt + 1 해주는 함수
	 */
	void addWinCnt(int id);
	
	/*
	 * Win_Cnt 1, 2위 이미지 가져오는 함수 
	 */
	List<ImageVO> getWinnerList(int tournament_id); 
}
