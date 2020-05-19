package com.yjy.idw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjy.idw.user.UserService;
import com.yjy.idw.user.UserVO;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired(required=true)
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public UserVO getUser(@PathVariable(value="id") String id) {
		return userService.getUser(Integer.parseInt(id.replaceAll("id=", "")));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "")
	public List<UserVO> getUserList() {
		return userService.getUserList();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}") 
	public void deleteUser(String id) {
		userService.deleteUser(Integer.parseInt(id));
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public String insertUser(UserVO vo) {
	   	userService.insertUser(vo);
		return "추가완료";
	}
}
