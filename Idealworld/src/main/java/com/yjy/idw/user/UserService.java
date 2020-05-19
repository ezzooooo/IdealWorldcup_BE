package com.yjy.idw.user;

import java.util.List;

import org.springframework.stereotype.Service;

public interface UserService {
	List<UserVO> getUserList();
	UserVO getUser(int id);
	void deleteUser(int id);
	void insertUser(UserVO vo);
}
