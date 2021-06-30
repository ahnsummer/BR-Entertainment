package com.brEnt.brFamily.member.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brEnt.brFamily.member.model.dao.MemberDao;
import com.brEnt.brFamily.member.model.vo.Member;

//@Component (전체적으로 두루 쓰이는 어노테이션) 
@Service // Service의 역할을 가진 클래스 빈 등록
public class MemberServiceImpl implements MemberService {
	
	@Autowired		
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDao mDao; 
	
	
	@Override
	public Member loginMember(Member m) {

		Member loginUser =mDao.loginMember(sqlSession,m);
		return loginUser;
	}

	@Override
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override // 작성자 : 김혜미 -- 신규사원 리스트 조회
	public ArrayList<Member> newMemberList() {
		return mDao.newMemberList(sqlSession);
	}

	@Override // 작성자 : 김혜미 -- 신규사원 상세조회
	public Member selectNewMemberDetail(Member m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // 작성자 : 김혜미 -- 사원 리스트 조회
	public ArrayList<Member> memberList() {
		return mDao.memberList(sqlSession);
	}

	@Override // 작성자 : 김혜미 -- 사원 상세조회
	public Member selectMemberDetail(Member m) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}


