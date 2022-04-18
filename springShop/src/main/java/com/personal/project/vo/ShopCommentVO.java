package com.personal.project.vo;

import org.springframework.stereotype.Component;

@Component
public class ShopCommentVO {

	int num;			// 상품 번호
	String uid;			// 유저 아이디
	String date;		// 댓글 입력날짜
	String comment;		// 댓글
	 
	public ShopCommentVO() {}
	 
	public ShopCommentVO(int num, String uid, String date, String comment) {
		super();
		setNum(num);
		setUid(uid);
		setDate(date);
		setComment(comment);
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	 
	 
}
