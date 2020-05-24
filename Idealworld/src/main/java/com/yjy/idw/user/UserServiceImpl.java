package com.yjy.idw.user;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<UserVO> getUserList() {
		List<UserVO> userList = sqlSessionTemplate.selectList("getUserList");
		return userList;
	}

	@Override
	public void insertUser(UserVO vo) {
		sqlSessionTemplate.insert("insertUser", vo);
	}

	@Override
	public UserVO getUser(int id) {
		UserVO user = sqlSessionTemplate.selectOne("getUser",id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		sqlSessionTemplate.delete("deleteUser");
	}
}
