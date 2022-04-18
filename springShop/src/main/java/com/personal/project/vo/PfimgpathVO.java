package com.personal.project.vo;

import org.springframework.stereotype.Component;

@Component
public class PfimgpathVO {
	private int num;				// 회원 번호
	private String uid;				// 회원 이름
	private String pfimg;			// 프로필 사진경로
	
	public PfimgpathVO() {}
	
	public PfimgpathVO(int num, String uid, String pfimg) {
		super();
		setNum(num);
		setUid(uid);
		setPfimg(pfimg);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPfimg() {
		return pfimg;
	}

	public void setPfimg(String pfimg) {
		this.pfimg = pfimg;
	}
	
	
}
