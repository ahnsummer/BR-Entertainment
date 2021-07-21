package com.brEnt.brFamily.member.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brEnt.brFamily.elecApproval.model.vo.ElecApproval;
import com.brEnt.brFamily.member.model.dao.MemberDao;
import com.brEnt.brFamily.member.model.vo.Member;

//@Component (전체적으로 두루 쓰이는 어노테이션) 
@Service // Service의 역할을 가진 클래스 빈 등록
public class MemberServiceImpl implements MemberService {
	
	@Autowired		
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDao mDao; 
	
	
	@Override // 작성자 : 정예빈 - 로그인
	public Member loginMember(Member m) {
		Member loginUser =mDao.loginMember(sqlSession,m);
		return loginUser;
	}

	@Override // 작성자 : 김혜미 -- 신규사원 리스트 조회
	public ArrayList<Member> newMemberList() {
		return mDao.newMemberList(sqlSession);
	}
	
	@Override // 작성자 : 김혜미 -- 신규사원 상세조회
	public Member newMemberDetail(int mno) {
		return mDao.newMemberDetail(sqlSession, mno);
	}

	@Override // 작성자 : 김혜미 -- 신규사원 등록
	public int enrollNewMember(Member m) {
		return mDao.enrollNewMember(sqlSession, m); 
	}
	
	@Override // 작성자 : 김혜미 -- 신규사원 반려
	public int returnMember(int mno) {
		return mDao.returnMember(sqlSession, mno);
	}

	@Override // 작성자 : 김혜미 -- 사원 리스트 조회
	public ArrayList<Member> memberList() {
		return mDao.memberList(sqlSession);
	}

	@Override // 작성자 : 김혜미 -- 사원 상세조회
	public Member memberDetail(int mno) {
		return mDao.memberDetail(sqlSession, mno);
	}
	
	@Override // 작성자 : 김혜미 -- 사원 수정
	public int updateMember(Member m) {
		return mDao.updateMember(sqlSession, m); 
	}

	@Override // 작성자 : 김혜미 -- 사원 탈퇴
	public int deleteMember(int mno) {
		return mDao.deleteMember(sqlSession, mno);
	}

	@Override // 작성자 : 최선희 -- 전자결재 기안함 리스트 조회 
	public ArrayList<ElecApproval> selectApprovalTotalList() {
		return mDao.selectApprovalTotalList(sqlSession); 
	}
	
}


