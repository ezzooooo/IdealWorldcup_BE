package com.yjy.idw.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {	
	static private final String resource = "config/mybatis-config.xml";
	static private InputStream inputStream = null; 
	static private SqlSessionFactory sqlSessionFactory = null;
	
	static {
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<UserVO> getUserList() {
		List<UserVO> userList;
		
		try(SqlSession session = sqlSessionFactory.openSession()) {
			UserDAO image = session.getMapper(UserDAO.class);
			userList = image.getUserList();
			session.commit();
			session.close();
		}
		
		return userList;
	}

	@Override
	public void insertUser(UserVO vo) {
		try(SqlSession session = sqlSessionFactory.openSession()) {
			UserDAO image = session.getMapper(UserDAO.class);
			image.insertUser(vo);
			session.commit();
			session.close();
		}
	}

	@Override
	public UserVO getUser(int id) {
		UserVO user;
		try(SqlSession session = sqlSessionFactory.openSession()) {
			UserDAO image = session.getMapper(UserDAO.class);
			user = image.getUser(id);
			session.commit();
			session.close();
		}

		return user;
	}

	@Override
	public void deleteUser(int id) {
		try(SqlSession session = sqlSessionFactory.openSession()) {
			UserDAO image = session.getMapper(UserDAO.class);
			image.deleteUser(id);
			session.commit();
			session.close();
		}
	}
}
