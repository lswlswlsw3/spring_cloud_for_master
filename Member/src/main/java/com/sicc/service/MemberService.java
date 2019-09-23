package com.sicc.service;

import com.sicc.vo.MemberVO;

/**
 * Member CRUD Service
 * @author Woongs
 */
public interface MemberService {
	public MemberVO saveMember(String sabun, String name, String division); // Apple 정보 셋팅 및 리턴
}
