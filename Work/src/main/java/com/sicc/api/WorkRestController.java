package com.sicc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sicc.service.WorkServiceImpl;
import com.sicc.vo.WorkVO;

/**
 * RestController
 * @author Woongs
 */
@RestController
@RequestMapping("/banana")
public class WorkRestController {

	@Autowired
	WorkServiceImpl bananaServiceImpl;
	
	/**
	 * banana rest url
	 * @return appleVO 정보
	 */
	@RequestMapping("/rest")
	public WorkVO restIndex() {
		return bananaServiceImpl.infoBanana("API Gateway", "Make Project and Test", "As soon as posible");
	}
}