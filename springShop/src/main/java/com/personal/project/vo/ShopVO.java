package com.personal.project.vo;

import org.springframework.stereotype.Component;

@Component
public class ShopVO {
	private int num;			// 상품번호
	private String name;		// 상품이름
	private String com;			// 제조회사
	private String sum;			// 상품소개
	private int price;			// 상품가격
	private String pdate;		// 제조날짜
	private int qty;			// 수량
		
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public ShopVO() {}
	
	public ShopVO(int num, String name, String com, String sum, int price, String pdate) {
		super();
		setNum(num);
		setName(name);
		setCom(com);
		setSum(sum);
		setPrice(price);
		setPdate(pdate);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	
	
	

	
	
}
