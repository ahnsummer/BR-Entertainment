package com.brEnt.brFamily.store.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brEnt.brFamily.member.model.vo.Member;
import com.brEnt.brFamily.store.model.service.CartService;
import com.brEnt.brFamily.store.model.vo.Cart;

@Controller
public class CartController {
	
	// 작성자 : 박지은 - 장바구니 조회
	@Autowired
	private CartService cService;
	
	@RequestMapping("cartList.pro")
	public ModelAndView cartList(HttpSession session, ModelAndView mv) throws Exception {
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		int memNo = loginUser.getMemNo();
		
		ArrayList<Cart> cartList = cService.cartList(memNo);
		
		mv.addObject("cartList", cartList)
		  .setViewName("store/cartList");
		return mv;
		
	}
	

}
