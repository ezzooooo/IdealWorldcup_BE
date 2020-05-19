package com.yjy.idw.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	void insertImage(ImageVO vo, MultipartFile f);
}
