package com.yjy.idw.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yjy.idw.aws.S3;
import com.yjy.idw.image.ImageService;
import com.yjy.idw.image.ImageVO;

@Controller
@RequestMapping("/images")
public class ImageController {
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/fileupload.do",  method=RequestMethod.POST)
	public void insertImage(ImageVO vo, @RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
		imageService.insertImage(vo);
		S3.ImageUpload(uploadFile);
	}
	
	@RequestMapping(value="getImageList", method=RequestMethod.GET)
	@ResponseBody
	public List<ImageVO> getImageList(ImageVO vo) {
		return imageService.getImageList(vo);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/wincnt/{id}")
	public void addWinCnt(@PathVariable(value="id") int id) {
		imageService.addWinCnt(id);
	}
}
