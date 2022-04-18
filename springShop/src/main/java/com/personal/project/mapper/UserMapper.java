package com.personal.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.personal.project.vo.UserVO;

@Mapper
public interface UserMapper {
	
//	@Insert("INSERT INTO shopuser VALUES(NULL, #{uid},#{pwd},#{uadr},#{uemail},#{pfimg})")
//	boolean insertUser(UserVO vo);
	
	@Insert("INSERT INTO shopuser VALUES(#{num},#{uid},#{pwd},#{uadr},#{uemail})")
	boolean insertUser(UserVO vo);
	
	@Select("SELECT * FROM shopuser")
	List<UserVO> getUserList();
	
	@Select("SELECT * FROM shopuser WHERE uid =#{uid} AND pwd=#{pwd}")
	UserVO getUser(UserVO vo);
	
	@Select("SELECT * FROM shopuser WHERE uid=#{uid}")
	UserVO getDetail(String uid);
	
//	@Update("UPDATE shopuser SET pwd=#{pwd}, uadr=#{uadr}, uemail=#{uemail}, pfimg=#{pfimg} WHERE num=#{num}")
//	boolean getupdate(UserVO vo);
	
	@Update("UPDATE shopuser SET pwd=#{pwd}, uadr=#{uadr}, uemail=#{uemail} WHERE num=#{num}")
	boolean getupdate(UserVO vo);


	@Delete("DELETE FROM shopuser WHERE num=#{num}")
	boolean deleteuser(int num);
}
