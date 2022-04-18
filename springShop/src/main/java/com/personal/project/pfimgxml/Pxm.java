package com.personal.project.pfimgxml;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.personal.project.vo.PfimgpathVO;
import com.personal.project.vo.UserVO;

@Mapper
public interface Pxm {
//	int pfimginsert(PfimgpathVO pfimg);
//	List<PfimgpathVO> selectpfimgpath(UserVO vo);
	
	@Insert("INSERT INTO pfimg VALUES(#{num}, #{uid}, #{pfimg})")
	int pfimginsert(PfimgpathVO pfimg);
	
	@Select("SELECT num, uid, pfimg FROM pfimg WHERE uid=#{uid}")
	List<PfimgpathVO> selectpfimgpath(UserVO vo);

}
