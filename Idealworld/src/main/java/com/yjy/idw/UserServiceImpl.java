package com.yjy.idw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return userDAO.getUserList();
	}

	@Override
	public void insertUser() {
		userDAO.insertUser();
	}
}
