package com.yjy.idw.image;

import java.util.List;

public interface ImageService {
	int insertImage(ImageVO vo);
	public List<ImageVO> getImageList(ImageVO vo);
	public void addWinCnt(int id);
}
