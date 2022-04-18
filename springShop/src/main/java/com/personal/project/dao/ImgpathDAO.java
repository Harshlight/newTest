package com.personal.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal.project.imgxml.Img;
import com.personal.project.vo.ImgpathVO;

@Repository
public class ImgpathDAO {
	
	@Autowired
	private Img imgxml;
	
	public int insertproductimg(String imgpath) {
		return imgxml.insertproductimg(imgpath);
	}

	public int insert(ImgpathVO imgpathVO) {
		return imgxml.insert(imgpathVO);
	}

	public ImgpathVO select(int num) {
		return imgxml.select(num);
	}
	
	public List<ImgpathVO> selectimgpath(int num) {
		return imgxml.selectimgpath(num);
	}

	public boolean delete(int num) {
		return imgxml.delete(num);
	}
	
}
