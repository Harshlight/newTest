package com.personal.project.svc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.project.dao.OrderDAO;
import com.personal.project.util.Cart;
import com.personal.project.vo.OrderVO;
import com.personal.project.vo.ShopVO;

@Service
public class OrderSvc {
	
	
	@Autowired
	private OrderDAO dao;
	
	@Autowired
	private HttpSession session;
	
	public int insertOrder(OrderVO ovo) {
		return dao.insert(ovo);
	}
	
	public boolean insertOrderList(List<OrderVO> list) {
		int rows =0;
		for(int i=0; i<list.size(); i++) {
			rows += dao.insert(list.get(i));
		}
		if (rows==list.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<OrderVO> pay() {
		String uid = (String)session.getAttribute("uid");
		Cart cart = (Cart) session.getAttribute("cart");
		List<ShopVO> list = cart.getList();
		List<OrderVO> olist = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			OrderVO ovo = new OrderVO();
			ovo.setUid(uid);
			ovo.setNum(list.get(i).getNum());
			ovo.setName(list.get(i).getName());
			ovo.setCom(list.get(i).getCom());
//			ovo.setImgpath(list.get(i).getImgpath());
			ovo.setQty(list.get(i).getQty());
			ovo.setPrice(list.get(i).getPrice());
			olist.add(ovo);
		}
		return olist;
	}
	
	public List<OrderVO> getOrderList(String uid){
		return dao.getOrderList(uid);
	}
	
	public List<OrderVO> getOrderCheckList(){
		return dao.getOrderCheckList();
	}
}
