package com.personal.project.controller;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.personal.project.listxml.ListMapper;
import com.personal.project.svc.FileSvc;
import com.personal.project.svc.OrderSvc;
import com.personal.project.svc.ShopSvc;
import com.personal.project.svc.UserSvc;
import com.personal.project.vo.ShopCommentVO;
import com.personal.project.vo.ShopVO;
import com.personal.project.vo.UserVO;

@Controller
@RequestMapping("/onlineshop")
public class ShopController {
	
//	@Autowired
//	ListMapper rep;
	
	@Autowired
	private ShopSvc svc;
	
	@Autowired
	private UserSvc usvc;
	
	@Autowired
	private OrderSvc osvc;
	
	@Autowired
	private FileSvc fsvc;
	
	@GetMapping("/main")
	public String main() {
		return "main_home";
	}
	
	@GetMapping("/product_add")
	public String admincheck(Model m) {
		if(usvc.isLogin()) {
			if(usvc.adminlogincheck()) {
				return "product_add_form";
			} else {
				m.addAttribute("msg", "관리자만 판매등록할 수 있습니다");
				return "main_home";
			}
		} else {
			m.addAttribute("msg", "관리자만 판매등록할 수 있습니다");
			return "main_home";
		}
	}
	
	@PostMapping("/product_add")
	@ResponseBody
	public String input(ShopVO s, @RequestParam("imgpath")MultipartFile[] mfiles) {
		if(svc.insert(s)&&fsvc.insert(fsvc.insertproductimg(s, mfiles))) {
			return String.format("{\"added\":%b}", true);  
		} else {
			return null;
		}
		
	}
	
//	@GetMapping("/product_list/{pgNum}")
//	public String getListByPage(@PathVariable("pgNum")int pg, Model model) {
//		if(usvc.isLogin()) {
//			UserVO vo = usvc.detail();
//			model.addAttribute("user", vo);
//			PageInfo<ShopVO> pgInfo = svc.getProductListPage(pg, 5);
//			model.addAttribute("pageInfo", pgInfo);
//			return "product_list";
//		} else {
//			model.addAttribute("msg", "로그인 후 이용해주세요");
//		} return "user_login_form";
//	}
	
//	@GetMapping("/rep")
//	public String jpaTest(@PageableDefault(page=0, size=2) Pageable pageable, Model m) {
//		Page<ShopVO> pageInfo = rep.findAllByNum(Integer.parseInt("num"), pageable);
//		m.addAttribute("page", pageInfo);
//		List<ShopVO> list = pageInfo.getContent();
//		return list.toString();
//	}
	
	
	@GetMapping("/product_detail/{num}")
	public String detail(@PathVariable("num")int num, Model m) {
		m.addAttribute("detail", svc.find(num));
		m.addAttribute("imgpath", fsvc.selectimgpath(num));
		UserVO vo = usvc.detail();
		m.addAttribute("user", vo);
		m.addAttribute("pfimg", fsvc.selectpfimgpath(vo));
		m.addAttribute("commentlist", svc.selectcommentList(num));
		return "product_detail";
	}
	
	@PostMapping("/product_detail/comment")
	@ResponseBody
	public String detailcomment(ShopCommentVO scvo, Model m) {
		return String.format("{\"commentok\":%b}", svc.addcomment(scvo));
	}
	
	@GetMapping("/product_edit_form/{num}")
	public String edit(@PathVariable("num")int num, Model m) {
		if(usvc.adminlogincheck()) {
			m.addAttribute("find", svc.find(num));
			m.addAttribute("imgpath", fsvc.selectimgpath(num));
			return "product_edit_form";
		} else {
			m.addAttribute("msg", "관리자만 수정할 수 있습니다");
			return "main_home";
		}

	}
	
	@PostMapping("/product_update")
	@ResponseBody
	public String update(ShopVO s) {
			return String.format("{\"updated\":%b}", svc.update(s));  
	}
	
	
	@GetMapping("/product_delete")
	@ResponseBody
	public String delete(@RequestParam("num")int num) {
		return String.format("{\"deleted\":%b}", svc.delete(num));
	}
	
//==========================================================================================================================
	
	@GetMapping("/login")
	public String login(Model m) {
		if(usvc.isLogin()) {
			m.addAttribute("msg2", "이미 로그인 하셨습니다");
			return "main_home";
		} else 
		return "user_login_form";
	}
	
	@PostMapping("/user_login")
	@ResponseBody
	public String login(UserVO vo) {
		return String.format("{\"login\":%b}", usvc.login(vo));
	}
	
	@GetMapping("/user/add")
	public String useraddform() {
		return "user_add_form";
	}

	@PostMapping("/user/add")
	@ResponseBody
	public String useradd(UserVO vo, @RequestParam("pfiles")MultipartFile[] mfiles) {
		if(usvc.insert(vo)&&fsvc.pfimg(fsvc.insertpfimg(vo, mfiles))) {
			return String.format("{\"added\":%b}", true);
		}else {
			return null;
		}
		
	}

	@GetMapping("/user/list")
	public String getUserList(Model m) {
		m.addAttribute("list", usvc.getlist());
		return "user_list";
	   }
	
	@GetMapping("/user_detail")
	public String showuserdetail(Model m) {
		if(usvc.isLogin()) {
			UserVO vo = usvc.detail();
			m.addAttribute("user", vo);
			m.addAttribute("pfimg", fsvc.selectpfimgpath(vo));
			return "user_detail";
		} else {
			m.addAttribute("msg", "로그인 후 이용해주세요");
			return "user_login_form";
		}
	}
	
	@GetMapping("/user_edit")
	public String useredit(Model m, UserVO vo) {
		m.addAttribute("user", usvc.detail());
		m.addAttribute("pfimg", fsvc.selectpfimgpath(vo));
		return "user_update_form";
	}

	@PostMapping("/user_update")
	@ResponseBody
	public String userupdate(UserVO vo) {
		return String.format("{\"updated\":%b}", usvc.update(vo));
	}
	
	@GetMapping("/user_delete")
	@ResponseBody
	public String userdelete(@RequestParam("num")int num) {
		usvc.logout();
		svc.logout();
		return String.format("{\"deleted\":%b}", usvc.delete(num));
	}
	
//==========================================================================================================================

	@PostMapping("/tocart")
	@ResponseBody
	public String toCart(ShopVO s) {		
		return String.format("{\"incart\":%b}", svc.toCart(s));
	}

	@GetMapping("/showcart")
	public String showCart(Model m) {
		m.addAttribute("user", usvc.detail());
		m.addAttribute("list", svc.showCart());
		m.addAttribute("total", svc.showTotal());
		return "shop_showcart";
	}
	
	@PostMapping("/qtychange")
	@ResponseBody
	public Map<String, Object> qtychange(@RequestParam("num")int num, @RequestParam("qty")int qty) {
		boolean change = svc.qtychange(num,qty);
		int total = svc.showTotal();
		
		String sTotal = NumberFormat.getInstance().format(total);
		
		Map<String, Object> map = new HashMap<>();
		map.put("change", change);
		map.put("total", sTotal);
		return map;
	}
	
	@GetMapping("/cartdel/{num}")
	public String del(@PathVariable("num")int num, Model m) {
		svc.cartdelete(num);
		return "redirect:/onlineshop/showcart";
	}

	@GetMapping("/cartempty")
	public String delteCart(Model m) {
		svc.cartempty();
		return "redirect:/onlineshop/showcart";
	}
	
//==========================================================================================================================
	
	@GetMapping("/order")
	public String showorder(Model m) {
		m.addAttribute("list", svc.showCart());
		m.addAttribute("total", svc.showTotal());
		m.addAttribute("user", usvc.detail());
		return "order_pay";
	}
	
	@GetMapping("/pay")
	@ResponseBody
	public String pay() {
		boolean ok = osvc.insertOrderList(osvc.pay());
		return String.format("{\"ok\":%b}", ok);
	}
	
	@GetMapping("/ordercheck/{uid}")
	public String ordercheckshow(Model m, @PathVariable("uid")String uid) {
		if(usvc.adminlogincheck()) {
			m.addAttribute("orderchecklist", osvc.getOrderCheckList());
			return "orderchecklist";
		} else {
			m.addAttribute("orderlist", osvc.getOrderList(uid));
			return "ordercheck";
		}
	}
	
//==========================================================================================================================
	@GetMapping("/logout")
	public String logout() {
		usvc.logout();
		svc.logout();
		return "redirect:/onlineshop/main";
	}
//==========================================================================================================================

	
	
	
	
	
	
	
	
}
