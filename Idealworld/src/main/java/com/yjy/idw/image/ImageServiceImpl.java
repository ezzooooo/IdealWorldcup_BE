package com.yjy.idw.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
	@Autowired
	private ImageDAO imageDAO;
	
	@Override
	public void insertImage(ImageVO vo) {
		imageDAO.insertImage(vo);
		
	}

}
