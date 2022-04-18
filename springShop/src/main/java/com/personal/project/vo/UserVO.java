package com.personal.project.vo;

public class UserVO {
	
	private int num;
	private String uid;
	private String pwd;
	private String uadr;
	private String uemail;
//	private String pfimg;
	
	public UserVO() {};
	
	public UserVO(int num, String uid, String pwd, String uadr, String uemail) {
		super();
		setNum(num);
		setUid(uid);
		setPwd(pwd);
		setUadr(uadr);
		setUemail(uemail);
//		setPfimg(pfimg);
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUadr() {
		return uadr;
	}

	public void setUadr(String uadr) {
		this.uadr = uadr;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

//	public String getPfimg() {
//		return pfimg;
//	}
//
//	public void setPfimg(String pfimg) {
//		this.pfimg = pfimg;
//	}
	
}
