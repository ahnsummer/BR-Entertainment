package com.brEnt.brFamily.elecApproval.model.service;

import java.util.ArrayList;

import com.brEnt.brFamily.boardFree.model.vo.BoardFree;
import com.brEnt.brFamily.elecApproval.model.vo.ElecApproval;
import com.brEnt.brFamily.elecApproval.model.vo.ElecApprovalFile;
import com.brEnt.brFamily.elecApproval.model.vo.Off;
import com.brEnt.brFamily.member.model.vo.Dept;
import com.brEnt.brFamily.member.model.vo.Member;

public interface ElecApprovalService {
   
	// 작성자 : 최선희 -- 전자결재 리스트 조회
    ArrayList<ElecApproval> selectApprovalTotalList(); 
    
    // 작성자 : 최선희 -- 기획안/업무연락/회람 상세 조회 
    ElecApproval documentDetail(int eano);
    
    // 작성자 : 최선희 -- 기획안/업무연락/회람 작성 
    int	insertDocument(ElecApproval ea); 
    int insertDocumentFile(ElecApprovalFile eaf);
    
    // 작성자 : 안소은 -- 전자결재 결재선 부서조회
    ArrayList<Dept> selectDept();
    
    // 작성자 : 안소은 -- 결재선 해당 부서 사원 조회용 AJAX
    ArrayList<Member> selectMemberList(int deptNo);
    
    // 작성자 : 김혜미 -- 연차 신청
    int offInsert(Off o);
    
    // 작성자 : 김혜미 -- 연차 상세조회
    ElecApproval offDetail(int eano);
}