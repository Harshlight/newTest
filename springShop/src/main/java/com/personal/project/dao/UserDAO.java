package com.personal.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal.project.mapper.UserMapper;
import com.personal.project.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private UserMapper userMapper;
	
	public boolean insert(UserVO vo) {
		return userMapper.insertUser(vo);
	}
	
	public List<UserVO> getUserList(){
		return userMapper.getUserList();
	}
	
	public UserVO login(UserVO vo) {
		return userMapper.getUser(vo);
	}

	public boolean update(UserVO vo) {
		return userMapper.getupdate(vo);
	}

	public boolean delete(int num) {
		return userMapper.deleteuser(num);
	}
	
	public UserVO detail (String uid) {
		return userMapper.getDetail(uid);
	}

}
