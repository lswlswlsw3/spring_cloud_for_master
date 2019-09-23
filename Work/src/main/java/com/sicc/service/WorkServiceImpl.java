package com.sicc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicc.vo.WorkVO;

/**
 * Banana Service Impl
 * @author Woongs
 */
@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	WorkVO bananaVO;
	
	@Override
	public WorkVO infoBanana(String title, String work, String grade) {
		bananaVO.setTitle("API Gateway");
		bananaVO.setWork("make project and test");
		bananaVO.setGrade("As soon as posible");

		return bananaVO;
	}
}
