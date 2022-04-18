package com.personal.project.vo;

import java.util.ArrayList;
import java.util.List;

public class OrderVO {
	private int no;				// 주문 번호
	private String uid;			// 주문자
	private int num;				// 상품 번호
	private String name;			// 상품 이름
	private String com;			// 제조 회사
	private String imgpath;		// 상품 사진
	private int qty;				// 상품 수량
	private int	price;				// 상품금액
	private String date;
	
	public OrderVO() {};
	
	public OrderVO(int no, String uid, int num, String name, String com,
			String imgpath, int qty, int price,	String date) {
		super();
		setNo(no);
		setUid(uid);
		setNum(num);
		setName(name);
		setCom(com);
		setImgpath(imgpath);
		setQty(qty);
		setPrice(price);
		setDate(date);
	}

	public List<OrderVO> list = new ArrayList<>();
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

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

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
