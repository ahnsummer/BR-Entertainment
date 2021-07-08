package com.brEnt.brFamily.personnelMgt.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.brEnt.brFamily.personnelMgt.model.vo.PersonnelMgt;

@Repository
public class PersonnelMgtDao {

	// 작성자 : 안소은 -- 근태관리 조회
	public ArrayList<PersonnelMgt> selectAttend(SqlSessionTemplate sqlSession, int memNo) {
		return (ArrayList)sqlSession.selectList("personnelMgtMapper.selectAttend", memNo);
	}
	
	// 작성자 : 안소은 -- 근무일수 조회
	public PersonnelMgt selectTotalWorkDay(SqlSessionTemplate sqlSession, int memNo) {
		return sqlSession.selectOne("personnelMgtMapper.selectTotalWorkDay", memNo);
	}
	
	// 작성자 : 안소은 -- 출근시간 insert
	public int insertCheckIn(SqlSessionTemplate sqlSession, PersonnelMgt p) {
		return sqlSession.insert("personnelMgtMapper.insertCheckIn", p);
	}
}
