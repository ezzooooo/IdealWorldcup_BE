package com.yjy.idw.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjy.idw.image.ImageService;
import com.yjy.idw.image.ImageVO;

@Controller
public class MainController {
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/",  method={RequestMethod.GET, RequestMethod.POST})
	public String getMainpage() {
		return "mainpage.html";
	}
	
	@RequestMapping(value="/fileupload.do",  method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String uploadImage(ImageVO vo) throws IOException {
		System.out.println("여기1");
		imageService.insertImage(vo);
		System.out.println("여기2");
		return "/";
	}
}
