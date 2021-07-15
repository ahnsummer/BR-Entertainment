package com.brEnt.brFamily.elecApproval.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.brEnt.brFamily.elecApproval.model.service.ElecApprovalService;
import com.brEnt.brFamily.elecApproval.model.vo.Approval_path;
import com.brEnt.brFamily.elecApproval.model.vo.ElecApproval;
import com.brEnt.brFamily.elecApproval.model.vo.ExpenseForm;
import com.brEnt.brFamily.elecApproval.model.vo.Off;
import com.brEnt.brFamily.member.model.vo.Dept;
import com.brEnt.brFamily.member.model.vo.Position;
import com.google.gson.Gson;

@Controller
public class ElecApprovalController {
   
   @Autowired
   private ElecApprovalService eaService;
   
   
   // 작성자 : 김혜미 -- 연차 신청폼
   @RequestMapping("offEnrollForm.ea")
   public ModelAndView offEnrollForm(ModelAndView mv) {
      
      ArrayList<Dept> list = eaService.selectDept();
      //System.out.println(list);
      mv.addObject("list", list)
          .setViewName("elecApproval/offEnrollForm");
      
      return mv;
   }
   

   // 작성자 : 김혜미 -- 연차 조회
   @RequestMapping("offDetail.ea")
   public String offDetail(int eano, Model model) {
	   
	   ElecApproval ea = eaService.offDetail(eano);
	   System.out.println(ea);
	   model.addAttribute("ea", ea);
	   return "elecApproval/offCheckForm";
   }
   
   
   // 작성자 : 김혜미 -- 연차 신청
   @RequestMapping("offInsert.ea")
   public String offInsert(Off o, Model model) {
	   System.out.println(o);
	   
	   int result = eaService.offInsert(o); 
	
	   return "redirect:approvalTotalList.ea";
   }

 
   // 작성자 : 최선희 -- 전자결재 기안함 리스트 
   @RequestMapping("approvalTotalList.ea")
   public ModelAndView approvalTotalList(ModelAndView mv) {
      	 
      ArrayList<ElecApproval> list = eaService.selectApprovalTotalList();
      
      mv.addObject("list", list)
        .setViewName("elecApproval/approvalTotalList"); 
      
      return mv;            
   }
   
   
   // 작성자 : 최선희 -- 전자결재 결재대기 리스트 
   @RequestMapping("approvalStandbyList.ea")
   public ModelAndView approvalStandbyList(ModelAndView mv) {
	   
	  ArrayList<ElecApproval> list = eaService.selectApprovalTotalList(); 
	  
	  mv.addObject("list", list)
      	.setViewName("elecApproval/approvalStandbyList"); 
	  
	  return mv;
   }
      
     
   // 작성자 : 최선희 -- 기획안/업무연락/회람 상세 조회 
   @RequestMapping("documentDetail.ea")
   public String documentDetail(int eano, Model model) {
	   
	   ElecApproval ea = eaService.documentDetail(eano);
	   //System.out.println(ea);
	   model.addAttribute("ea", ea); 
	   return "elecApproval/documentDetail";
   }
   
   
   // 작성자 : 최선희 —- 기획안/업무연락/회람 작성폼  
   @RequestMapping("documentEnrollForm.ea")
   public ModelAndView documentEnrollForm(String code, ModelAndView mv) {   
	   ArrayList<Dept> list = eaService.selectDept();
	   //System.out.println(list);
	   mv.addObject("list", list)
	     .addObject("code", code)
	     .setViewName("elecApproval/documentEnrollForm");
	   
	   return mv;
   }
   
      
   // 작성자 : 최선희 -- 기획안/업무연락/회람 작성 
   @RequestMapping("insertDocument.ea")
   public String insertDocument(ElecApproval ea, MultipartFile upfile, HttpSession session, Model model) {
	   
	   // 전달된 파일이 있을 경우 => 파일명 수정 작업 후 서버에 업로드 => 파일 원본명, 실제 서버에 업로드된 경로를 ea에 추가로 담기 
	   if(!upfile.getOriginalFilename().equals("")) { 
		   
			String changeName = saveFile(session, upfile); 		
			
			ea.setEcFileOrigin(upfile.getOriginalFilename()); 
			ea.setEcFileUpdate("resources/elecApprovalUpfiles/" + changeName); // 업로드된파일명 + 파일명
			
		}
			
		int result = eaService.insertDocument(ea); 
			
		// 성공했을 경우 
		if(result > 0) { 
			session.setAttribute("alertMsg", "성공적으로 문서가 작성되었습니다.");
			return "redirect:approvalTotalList.ea";
		// 실패했을 경우 
		}else { 
			model.addAttribute("errorMsg", "게시글 작성 실패"); 
			return "common/errorPage"; 
		}
		
   }
   
   
   // 작성자 : 최선희 -- 전달받은 첨부파일 수정명 작업해서 서버에 업로드시킨 후 해당 수정된 파일명(서버에 업로드된 파일명)을 반환하는 메소드 
   public String saveFile(HttpSession session, MultipartFile upfile) {
				
	   String savePath = session.getServletContext().getRealPath("/resources/elecApprovalUpfiles/");
				
	   String originName = upfile.getOriginalFilename(); // 원본명 ("aaa.jpg") 
				
	   String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	   int ranNum = (int)(Math.random() * 900000 + 10000); 
	   String ext = originName.substring(originName.lastIndexOf(".")); 
				
	   String changeName = currentTime + ranNum + ext;
				
	   try {
		   upfile.transferTo(new File(savePath + changeName));
	   } catch (IllegalStateException | IOException e) {
		   e.printStackTrace();
	   }
				
	   return changeName;
				
   }	
   
   
   // 작성자 : 최선희 -- 기획안/업무연락/회람 삭제 
   @RequestMapping("deleteDocument.ea")
   public String deleteDocument(int eano, String filePath, 
				  				HttpSession session, Model model) {
			// filePath : 첨부파일 존재했다면 	  "resources/elecApprovalUpfiles/xxxxxx.pdf" 
			// filePath : 첨부파일 존재하지 않았다면 "" 
	
		int result = eaService.deleteDocument(eano); 
		//System.out.println(eano);
		if(result > 0) {
	
			// 첨부파일이 있을 경우 => 서버에 업로드된 파일 찾아서 삭제 
			if(!filePath.equals("")) {
				new File(session.getServletContext().getRealPath(filePath)).delete(); 
			}
			
			session.setAttribute("alertMsg", "성공적으로 게시글이 삭제되었습니다.");
			return "redirect:approvalTotalList.ea"; 
	
		}else { 
		
			model.addAttribute("errorMsg", "전자결재 기안문서 삭제 실패"); 
			return "common/errorPage";

		}
	
   }
   
    
   // 작성자 : 안소은 — 지출결의서 폼
   @RequestMapping("expenseForm.ea")
   public ModelAndView expenseForm(ModelAndView mv) {
	   
	   // 결재선 부서 리스트 조회
	   ArrayList<Dept> list = eaService.selectDept();
	   mv.addObject("list", list)
	   	 .setViewName("elecApproval/expenseForm");
	   
	   return mv;
   }

   
   // 작성자 : 안소은 — 지출결의서 상세페이지
   @RequestMapping("expenseDetail.ea")
   public String expenseDetail(int eano, Model model) {
	   
	   // 통합문서 조회
	   ElecApproval ea = eaService.expenseDetail(eano);
	   model.addAttribute("ea", ea); 
	   
	   // 지출결의서 조회
	   ExpenseForm ex = eaService.expenseDetailTwo(eano);
	   model.addAttribute("ex", ex);
	   
	   // 부서조회
	   ArrayList<Dept> dept = eaService.selectDeptName(eano);
	   model.addAttribute("dept", dept);
	   System.out.println(dept);
	   
	   // 직급조회
	   ArrayList<Position> posi = eaService.selectPosiName(eano);
	   model.addAttribute("posi", posi);
	   System.out.println(posi);
	   
	   // 결재선 조회
//	   ArrayList<Approval_path> apList = eaService.selectApPath(eano);
//	   model.addAttribute("apList", apList);
//	   System.out.println(apList);
//	   
	   return "elecApproval/expenseDetail";
	   
   }
   
   
   // 작성자 : 안소은 — 결재선 해당 부서 사원 조회용 AJAX
   @ResponseBody
   @RequestMapping(value="memberList.ea", produces="application/json; charset=utf-8")
   public String ajaxSelectMember(int deptNo) {
	   
	   return new Gson().toJson(eaService.selectMemberList(deptNo));
	   
   }
  
   
   
}