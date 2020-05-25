package com.yjy.idw.image;

import java.util.List;

public interface ImageService {
	int insertImage(ImageVO vo);
	List<ImageVO> getImageList(int tournament_id);
	void addWinCnt(int id);
}
