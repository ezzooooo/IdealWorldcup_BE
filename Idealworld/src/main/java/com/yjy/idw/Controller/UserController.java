package com.yjy.idw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjy.idw.UserService;
import com.yjy.idw.UserVO;

@RestController
public class UserController {
	@Autowired(required=true)
	private UserService userService;
	
	@RequestMapping("/")
	public UserVO getUser(UserVO vo) {
		return userService.getUser(vo);
	}
	
	@RequestMapping("/users")
	public List<UserVO> getUserList() {
		return userService.getUserList();
	}
	
	@RequestMapping("/users") 
	public void deleteUser() {
		
	}
	
	@RequestMapping(value = "/users") 
	public String insertUser(UserVO vo) {
	   	userService.insertUser(vo);
		return "추가완료";
	}
}
