package com.yjy.idw.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yjy.idw.aws.S3;
import com.yjy.idw.image.ImageService;
import com.yjy.idw.image.ImageVO;

@Controller
//@RequestMapping("/images")
public class ImageController {
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/",  method={RequestMethod.GET, RequestMethod.POST})
	public String getMainpage() {
		return "mainpage.html";
	}
	
	@RequestMapping(value="/fileupload.do",  method=RequestMethod.POST)
	@ResponseBody
	public String insertImage(ImageVO vo, @RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
		imageService.insertImage(vo);
		S3.ImageUpload(uploadFile);
		return "/";
	}
	
	@RequestMapping(value="/image", method=RequestMethod.GET)
	@ResponseBody
	public List<ImageVO> getListImage(int tournament_id) {
		return imageService.getImageList(tournament_id);
	}
}
