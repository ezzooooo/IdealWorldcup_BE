package com.yjy.idw.image;

import java.util.List;

public interface ImageService {
	int insertImage(ImageVO vo);
	List<ImageVO> getImageList(ImageVO vo);
	void addWinCnt(int id);
}
