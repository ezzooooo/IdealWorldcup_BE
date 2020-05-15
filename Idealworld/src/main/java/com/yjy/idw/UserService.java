package com.yjy.idw;

import java.util.List;

import org.springframework.stereotype.Service;

public interface UserService {
	List<UserVO> getUserList();
	void insertUser();
}
