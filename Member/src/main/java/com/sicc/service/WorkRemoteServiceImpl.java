package com.sicc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sicc.vo.MemberVO;

/**
 * Apple Service Impl
 * @author Woongs
 */
@Service
public class WorkRemoteServiceImpl implements WorkRemoteService {

	private String url = "http://localhost:8082/banana/rest";
	
	@Autowired
	MemberVO memberVO;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(commandKey = "remoteWorkInfo", fallbackMethod = "remoteWorkInfoFallback") // fallback method 추가 방법 다시 찾아보기
	public String infoAppleWithInfoBanana(String sabun, String name, String division) {
		memberVO.setSabun(sabun);
		memberVO.setName(name);
		memberVO.setDivision(division);
		
		String workInfo = restTemplate.getForObject(url, String.class);
		
		return memberVO.toString()+" : "+workInfo;
	}

	// fallback 메소드 (구성시 파라미터 값이 포함되어 있어야 함)
	public String remoteWorkInfoFallback(String sabun, String name, String division, Throwable t) {
		return ">>> this is fallback workInfo : "+t;
	}
}