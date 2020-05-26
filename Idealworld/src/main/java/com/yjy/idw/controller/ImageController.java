package com.yjy.idw.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yjy.idw.aws.S3;
import com.yjy.idw.image.ImageService;
import com.yjy.idw.image.ImageVO;

@RestController
@RequestMapping("/images")
public class ImageController {
	@Autowired
	private ImageService imageService;
	
	/**
	 * 이미지 정보 추가 
	 * S3에 이미지 업로드
	 * @param vo ImageVO
	 * @param uploadFile MultipartFile
	 * @throws IOException
	 */
	@RequestMapping(value="/fileupload.do",  method=RequestMethod.POST)
	public void insertImage(ImageVO vo, @RequestParam("uploadFile")MultipartFile uploadFile) throws IOException {
		imageService.insertImage(vo);
		S3.ImageUpload(uploadFile);
	}
	
	/**
	 * 정보에 알맞은 이미지 리스트를 받아옴 
	 * @param vo ImageVO
	 * @return List
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<ImageVO> getImageList(ImageVO vo) {
		return imageService.getImageList(vo);
	}
	
	/**
	 * 이미지의 우승 횟수를 증가시킴
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/wincnt/{id}")
	public void addWinCnt(@PathVariable(value="id")int id) {
		imageService.addWinCnt(id);
	}
	
	/**
	 * tournament_id에 알맞은 이미지 중에서 우승 횟수가 가장 많은 2개의 이미지 리스트를 받아옴 
	 * @param tournament_id int
	 * @return List
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/winners/{tournament_id}")
	public List<ImageVO> getWinnerList(@PathVariable(value="tournament_id")int tournament_id) {
		return imageService.getWinnerList(tournament_id);
	}
}
