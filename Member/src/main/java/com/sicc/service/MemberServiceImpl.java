package com.sicc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sicc.dao.MemberDao;
import com.sicc.vo.MemberVO;

/**
 * Member CRUD Service Impl
 * @author Woongs
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao; // member CRUD DAO
	
	@Autowired
	MemberVO memberVO; // member VO

	/**
	 * saveMember
	 * @param sabun 사번
	 * @param name 이름
	 * @param division 부서
	 * @return 멤버VO(사번, 이름, 부서)
	 */
	@Override
	@HystrixCommand(commandKey = "saveMember", fallbackMethod = "saveMemberFallback")
	public MemberVO saveMember(String sabun, String name, String division) {
		memberVO.setSabun(sabun);
		memberVO.setName(name);
		memberVO.setDivision(division);
		
		memberVO = memberDao.save(memberVO);
		System.out.println(">>> MemberServiceImpl saveMember : "+memberVO);
		
		return memberVO;
	}

	/**
	 * saveMemberFallback
	 * @param sabun 사번
	 * @param name 이름
	 * @param division 부서
	 * @param t 오류내용
	 * @return 오류정보
	 */
	public String saveMemberFallback(String sabun, String name, String division, Throwable t) {
		return ">>> saveMemberFallback works : "+t;
	}
}
