package com.yjy.idw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjy.idw.UserService;
import com.yjy.idw.UserVO;

@RestController
public class TestController {

	@Autowired(required=true)
	private UserService userService;
	
	@RequestMapping("getUserList.do")
	public List<UserVO> getUserList() {
		return userService.getUserList();
	}
	
	@RequestMapping("insertUser.do") 
	public String insertUser() {
	   	userService.insertUser();
		return "추가완료";
	}
	
}
