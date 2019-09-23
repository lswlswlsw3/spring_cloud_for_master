package com.sicc.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Apple VO
 * @author Woongs
 */
@Component
@Data // lombok 사용 위함
@Entity
@Table(name = "tb_member") // jpa 사용 위함 (tb_member 테이블로써 저장)
public class MemberVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sn", length = 10, unique = true, nullable = false)
	private int sn; // sn
	
	@Column(name = "sabun", length = 7, unique = true, nullable = false)
	private String sabun;		// 사번
	
	@Column(name = "name", length = 30, nullable = false)
	private String name;		// 이름
	
	@Column(name = "division", length = 30, nullable = false)
	private String division;	// 부서
}
