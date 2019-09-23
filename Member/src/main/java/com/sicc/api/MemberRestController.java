package com.sicc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sicc.service.MemberServiceImpl;
import com.sicc.service.WorkRemoteServiceImpl;
import com.sicc.vo.MemberVO;

/**
 * RestController
 * @author Woongs
 */
@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	MemberServiceImpl memberServiceImpl;

	@Autowired
	WorkRemoteServiceImpl bananaRemoteServiceImpl;
	
	/**
	 * apple rest url
	 * @return appleVO 정보
	 */
	@RequestMapping(path = "/{sabun}/{name}/{division}", method = RequestMethod.POST)
	public MemberVO saveMember(@PathVariable String sabun, @PathVariable String name, @PathVariable String division) {
		System.out.println(">>> sabun : "+sabun+", name : "+name+", division : "+division);
		return memberServiceImpl.saveMember(sabun, name, division);
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public MemberVO saveMember() {
		return memberServiceImpl.saveMember("2136100", "woongs", "MSA");
	}
	
	/**
	 * apple + banana url 정보
	 * @param sabun 사번
	 * @param name 이름
	 * @param division 부서
	 * @return appleVO + bananaVO toString 값
	 */
	@RequestMapping(path = "/{sabun}/{name}/{division}", method = RequestMethod.GET)
	public String infoAppleWithInfoBanana(@PathVariable String sabun, @PathVariable String name, @PathVariable String division) {
		return bananaRemoteServiceImpl.infoAppleWithInfoBanana(sabun, name, division);
	}	
}