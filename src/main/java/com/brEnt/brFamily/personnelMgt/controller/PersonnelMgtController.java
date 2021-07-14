package com.brEnt.brFamily.personnelMgt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brEnt.brFamily.personnelMgt.model.service.PersonnelMgtService;
import com.brEnt.brFamily.personnelMgt.model.vo.PersonnelMgt;
import com.brEnt.brFamily.personnelMgt.model.vo.SalaryDto;

@Controller
public class PersonnelMgtController {
	
	@Autowired
	private PersonnelMgtService pService;

	// 작성자 : 김혜미 -- 급여내역 리스트
	@RequestMapping("salaryList.pm")
	public ModelAndView slaryList(ModelAndView mv) {
		
		ArrayList<SalaryDto> list = pService.slaryList();
		
		mv.addObject("list", list)
        .setViewName("personnelMgt/slaryList");
		return mv;
	}
	
	// 작성자 : 김혜미 -- 연차 조회
	@RequestMapping("offList.pm")
	public String offList() {
		return "personnelMgt/offList";
	}
	
	// 작성자 : 안소은 -- 근태관리 조회
//	@RequestMapping("attendeanceMgt.pm")
//	public ModelAndView attendanceManagement(int memNo, ModelAndView mv) {
//		
//		ArrayList<PersonnelMgt> pList = pService.selectAttend(memNo);
//		mv.addObject("pList", pList)
//		  .setViewName("personnelMgt/attendanceManagement");
//			
//		return mv;
//	
//	}
	
	// 작성자 : 안소은 -- 근무일수 조회
	@RequestMapping("attendeanceMgt.pm")
	public String selectTotalWorkDay(int memNo, Model model) {
		
		PersonnelMgt p = pService.selectTotalWorkDay(memNo);
		model.addAttribute("p", p);
		//System.out.println(p);
		
		PersonnelMgt pp = pService.selectAttend(memNo);
		model.addAttribute("pp", pp);
		
		PersonnelMgt d = pService.selectToday(memNo);
		model.addAttribute("d", d);
		System.out.println(d.getAtCount());
		
//		if(d.getAtCount() > 0) {
//			
//			return "personnelMgt/attendanceManagement";
//			
//		}else {
//			
//		}
		
		return "personnelMgt/attendanceManagement";
		
	}
	
	
	
	// 작성자 : 안소은 -- 출근시간 INSERT AJAX
	@ResponseBody
	@RequestMapping("insertCheckIn.pm")
	public String ajaxInsertCheckIn(PersonnelMgt p) {
		
		int result = pService.insertCheckIn(p);
		
		if(result > 0) {
			return "Check-In have been successfully registered";
		}else {
			return "fail";
		}
		
	}
	
	// 작성자 : 안소은 -- 퇴근시간 INSERT AJAX
	@ResponseBody
	@RequestMapping("insertCheckOut.pm")
	public String ajaxInsertCheckOut(PersonnelMgt p) {
		
		int result = pService.insertCheckOut(p);
		
		if(result > 0) {
			return "Check-Out have been successfully registered";
		}else {
			return "fail";
		}
		
	}
	
	
	
	
	
}









