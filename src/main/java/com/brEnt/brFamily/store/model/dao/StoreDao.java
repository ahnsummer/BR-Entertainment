package com.brEnt.brFamily.store.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.brEnt.brFamily.common.model.vo.PageInfo;
import com.brEnt.brFamily.store.model.vo.PayDto;
import com.brEnt.brFamily.store.model.vo.Product;

@Repository
public class StoreDao {

	// 작성자 : 김혜미 -- 상품 개수 조회
	public int selectProductListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("storeMapper.selectProductListCount");
	}

	
	// 작성자 : 김혜미 -- 상품 리스트 조회 (페이징처리)
	public ArrayList<Product> selectProductList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getProductLimit();
		int limit = pi.getProductLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("storeMapper.selectProductList", null, rowBounds);
	}

	
	// 작성자 : 김혜미 -- 상품 상세조회
	public Product selectProductDetail(SqlSessionTemplate sqlSession, int pdtNo) {
		return sqlSession.selectOne("storeMapper.selectProductDetail", pdtNo);
	}

	// 작성자 : 김혜미 -- 바로 구매하기
	public Product buyNowProduct(SqlSessionTemplate sqlSession, int pdtNo) {
		return sqlSession.selectOne("storeMapper.buyNowProduct", pdtNo);
	}
	
	
	// 작성자 : 김혜미 -- 상품 리스트 조회 (관리자)
	public ArrayList<Product> selectProductListAdmin(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("storeMapper.selectProductListAdmin");
	}

	
	// 작성자 : 김혜미 -- 상품 상세조회 (관리자)
	public Product selectProductDetailAdmin(SqlSessionTemplate sqlSession, int pdtNo) {
		return sqlSession.selectOne("storeMapper.selectProductDetailAdmin", pdtNo);
	}
	
	// 작성자 : 김혜미 -- 상품관리 등록
	public int orderInsert(SqlSessionTemplate sqlSession, PayDto pd) {
		return sqlSession.insert("storeMapper.orderInsert", pd);
	}


}