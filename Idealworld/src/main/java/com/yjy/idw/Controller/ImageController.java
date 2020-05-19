package com.yjy.idw.controller;
/**
 * url : localhost:8080/images
 */
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping(value="/fileupload.do",  method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String uploadImage(@RequestParam("uploadFile") MultipartFile uploadFile, ImageVO vo) throws IOException {
		System.out.println("여기1");
		imageService.insertImage(vo, uploadFile);
		System.out.println("여기2");
		return "/";
	}
}
