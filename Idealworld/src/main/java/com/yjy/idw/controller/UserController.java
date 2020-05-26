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
	
	/**
	 * id값에 알맞은 유저 상세 정보를 가져옴 
	 * @param id int
	 * @return UserVO
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public UserVO getUser(@PathVariable(value="id")int id) {
		return userService.getUser(id);
	}
	
	/**
	 * 모든 유저 정보를 가져옴
	 * @return List
	 */
	@RequestMapping(method = RequestMethod.GET, value = "")
	public List<UserVO> getUserList() {
		return userService.getUserList();
	}
	
	/**
	 * id값에 알맞은 유저를 제거함
	 * @param id int 
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}") 
	public void deleteUser(@PathVariable(value="id")int id) {
		userService.deleteUser(id);
	}
	
	/**
	 * 유저 정보를 추가함
	 * @param vo UserVO
	 */
	@RequestMapping(method = RequestMethod.POST) 
	public void insertUser(UserVO vo) {
	   	userService.insertUser(vo);
	}
}
