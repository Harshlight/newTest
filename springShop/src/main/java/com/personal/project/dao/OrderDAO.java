package com.personal.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal.project.orderxml.OrderXmlMapper;
import com.personal.project.vo.OrderVO;

@Repository
public class OrderDAO {
	
	@Autowired
	private OrderXmlMapper orderxmlmapper;
	
	
//	public boolean saveorder(OrderVO ovo) {
//		return ordermapper.saveOrder(ovo);
//	}
	
	public int insert(OrderVO ovo) {
		return orderxmlmapper.insertOrder(ovo);
	}
	
	public List<OrderVO> getOrderList(String uid){
		return orderxmlmapper.getOrderList(uid);
	}
	
	public List<OrderVO> getOrderCheckList(){
		return orderxmlmapper.getOrderCheckList();
	}

//	public List<ShopVO> list(List<ShopVO> list){
//		for(int i=0; i<list.size(); i++) {
//			ShopVO svo = list.get(i);
//
//			svo.getNum();
//			svo.getName();
//			svo.getCom();
//			svo.getImgpath();
//			svo.getQty();
//		}
//		list.add(null);
//		return list;
//	}


//	public boolean saveorder(String uvo, List<ShopVO> list) {
//		return ordermapper.saveOrder(uvo, list);
//	}
	
}
