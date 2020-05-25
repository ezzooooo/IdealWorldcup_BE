package com.yjy.idw.image;

import java.util.List;

public interface ImageDAO {
	
	/*
	 * Image를 삽입하는 함수
	 */
	public int insertImage(ImageVO vo);
	
	/*
	 * 토너먼트 id가 일치하는 이미지 목록을 가져오는 함수
	 */
	public List<ImageVO> getImageList(int tournament_id);
	
	/*
	 * 우승한 이미지 Win_Cnt + 1 해주는 함수
	 */
	public void addWinCnt(int id);
}
