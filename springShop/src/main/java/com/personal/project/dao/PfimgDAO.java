package com.personal.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal.project.pfimgxml.Pxm;
import com.personal.project.vo.PfimgpathVO;
import com.personal.project.vo.UserVO;

@Repository
public class PfimgDAO {
	 @Autowired
	 private Pxm pfimgxml;
	 
	 public int insert(PfimgpathVO pfimg) {
		 System.out.println("vo에 저장된 파일명 : " + pfimg.getPfimg() + "," + pfimg.getNum() + "," + pfimg.getUid());
		 return pfimgxml.pfimginsert(pfimg);
	 }

	public List<PfimgpathVO> selectpfimgpath(UserVO vo) {
		return pfimgxml.selectpfimgpath(vo);
	}
}
