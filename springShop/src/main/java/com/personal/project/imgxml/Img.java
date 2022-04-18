package com.personal.project.imgxml;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.personal.project.vo.ImgpathVO;

@Mapper
public interface Img {
	int insertproductimg(String imgpath);
	ImgpathVO select(int num);
	List<ImgpathVO> selectimgpath(int num);
	int insert(ImgpathVO imgpathVO);
	boolean delete(int num);
}
