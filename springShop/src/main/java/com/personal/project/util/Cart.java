package com.personal.project.util;

import java.util.ArrayList;
import java.util.List;

import com.personal.project.vo.ShopVO;

public class Cart {
	
	private List<ShopVO> list = new ArrayList<>();
	
	public boolean cartadd(ShopVO product) {
		for(int i=0; i<list.size(); i++) {
			ShopVO _product = list.get(i);
			if(_product.getNum()==product.getNum() && _product.getName().equals(product.getName())) {
				_product.setQty(_product.getQty()+product.getQty());
				return true;
			}
		}
		list.add(product);
		return true;
	}
	
	public List<ShopVO> getList(){
		return list;
	}
	
	public int getTotal() {
		int total = 0;
		for(int i=0; i<list.size();i++) {
			ShopVO product = list.get(i);
			total += product.getPrice()*product.getQty();
		}
		return total;
	}
	
	public boolean changeqty(int num, int qty) {
		for(int i=0; i<list.size();i++) {
			ShopVO product= list.get(i);
			if(product.getNum()==num) {
				product.setQty(qty);
				return true;
			}
		}
		return true;
	}

	public boolean cartdelete(int num) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNum()==num) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	public List<ShopVO> cartempty() {
		list.clear();
		return list; 
	}
}
