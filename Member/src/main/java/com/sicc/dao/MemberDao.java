package com.sicc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sicc.vo.MemberVO;

/**
 * member dao
 * @author Woongs
 */
@Repository
public interface MemberDao extends JpaRepository<MemberVO, Long> {
	
	// C = 입력
	@Override
	default <S extends MemberVO> S save(S memberVO) {
		return memberVO;
	}
	
	// R = 조회
	//public List<MemberVO> findALL(); // 전체 멤버 조회
	
	//public MemberVO findBySabun(String sabun); // 사번에 의한 멤버 조회
	
	//public List<MemberVO> findByNameLike(String name); // 이름에 의한 멤버 조회 (문자열 포함)
	
	// U = 갱신
	
	
	// D = 삭제
	
}
