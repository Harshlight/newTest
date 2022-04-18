package com.personal.project.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ImgpathVO {
	private int num; 					// 상품 번호
	private String name;				// 상품 이름
	private String imgpath;				// 사진 경로
	
	public ImgpathVO() {}

	public ImgpathVO(int num, String name, String imgpath) {
		super();
		setNum(num);
		setName(name);
		setImgpath(imgpath);
	}
	
	public List<ImgpathVO> list = new ArrayList<>();
	
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	

}
