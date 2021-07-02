package com.brEnt.brFamily.elecApproval.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brEnt.brFamily.elecApproval.model.dao.ElecApprovalDao;
import com.brEnt.brFamily.elecApproval.model.vo.ElecApproval;
import com.brEnt.brFamily.member.model.vo.Dept;
import com.brEnt.brFamily.member.model.vo.Member;

@Service
public class ElecApprovalServiceImpl implements ElecApprovalService {
   
   @Autowired 
   private SqlSessionTemplate sqlSession;
   @Autowired
   private ElecApprovalDao eaDao; 
   
   
   // 작성자 : 최선희 -- 전자결재 전체 리스트 조회 
   @Override
   public ArrayList<ElecApproval> selectApprovalTotalList() {
      return eaDao.selectApprovalTotalList(sqlSession); 
   }

   // 작성자 : 안소은 -- 결재선 부서 리스트 조회
   @Override
   public ArrayList<Dept> selectDept() {
	  return eaDao.selectDept(sqlSession);
   }

   // 작성자 : 안소은 -- 결재선 사원 리스트 조회
   @Override
   public ArrayList<Member> selectMember() {
	   return eaDao.selectMember(sqlSession);
   }

   @Override	
   public ArrayList<Member> selectMemberList(int memNo) {
	   return eaDao.selectMemberList(sqlSession, memNo);
   }


   

}