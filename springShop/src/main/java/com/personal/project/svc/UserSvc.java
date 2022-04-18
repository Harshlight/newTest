package com.personal.project.svc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.project.dao.UserDAO;
import com.personal.project.vo.UserVO;

@Service
public class UserSvc {
	@Autowired
	private HttpSession session;
	@Autowired
	private UserDAO dao;
	
	public boolean insert(UserVO vo) {
		return dao.insert(vo);
	}
	
	public List<UserVO> getlist(){
		return dao.getUserList();
	}
	
	public boolean login (UserVO vo) {
		UserVO u = dao.login(vo);
		if(u!=null) {
			session.setAttribute("uid", u.getUid());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isLogin() {
		return(session.getAttribute("uid")!=null);
	}
	
	public UserVO detail() {
		String uid = (String)session.getAttribute("uid");
		return dao.detail(uid);
	}
	
	public String getUid() {
		String uid = (String)session.getAttribute("uid");
		return uid;
	}
	
	public boolean adminlogincheck() {
		String admin = (String) session.getAttribute("uid");
		if (admin.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}
	

	public boolean update(UserVO vo) {
		return dao.update(vo);
	}

	public boolean delete(int num) {
		return dao.delete(num);
	}
	
	public boolean logout() {
		session.invalidate();
		return true;
	}
	
}
