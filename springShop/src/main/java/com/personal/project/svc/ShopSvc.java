package com.personal.project.svc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.project.commentxml.Comment;
import com.personal.project.listxml.ListMapper;
import com.personal.project.shopxml.ShopXmlMapper;
import com.personal.project.util.Cart;
import com.personal.project.vo.ShopCommentVO;
import com.personal.project.vo.ShopVO;

@Service
public class ShopSvc {
	
	@Autowired
	private ShopXmlMapper dao;
	
	@Autowired
	private Comment cdao;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ListMapper listxmlmapper;
		
	public boolean insert(ShopVO s) {
		return dao.insert(s);
	}

	public List<ShopVO> getlist(){
		return dao.getList();
	}
	
	public ShopVO find(int num) {
		return dao.select(num);
	}
	
	public boolean update(ShopVO s) {
		return dao.update(s);
	}
	
	public boolean delete(int num) {
		return dao.delete(num);
	}
	
	public boolean toCart(ShopVO s) {
		if(session.getAttribute("cart")==null) {
			session.setAttribute("cart", new Cart());
		}
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.cartadd(s);
	}
	
	public Object showCart() {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.getList();
	}
	
	public int showTotal() {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.getTotal();
	}
	
	public boolean qtychange(int num, int qty) {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.changeqty(num, qty);
	}
	
	public boolean cartdelete(int num) {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.cartdelete(num);
	}

	public Object cartempty() {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.cartempty();
	}
	
	 public boolean logout() {
		 session.invalidate();
		 return true;
	 }

//	public PageInfo<ShopVO> getProductListPage(int pageNum, int pageSize) {
//	      PageHelper.startPage(pageNum, pageSize);
//	      PageInfo<ShopVO> pageInfo = new PageInfo<>(listxmlmapper.getProductList());
////	      System.out.println(pageInfo.getList().size());
//	      return pageInfo;
//	}
	
	public boolean addcomment(ShopCommentVO scvo) {
		return cdao.inputcomment(scvo);
	}
	
	public List<ShopCommentVO> selectcommentList(int num){
		return cdao.selectcommentList(num);
	}
	
}
