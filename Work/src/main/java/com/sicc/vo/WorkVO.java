package com.sicc.vo;

import org.springframework.stereotype.Component;

/**
 * Banana Application VO
 * @author Woongs
 */
@Component
public class WorkVO {
	private String title;	// 작업명
	private String work;	// 작업내용
	private String grade;	// 등급

	// 기본 생성자
	public WorkVO() {
		// TODO Auto-generated constructor stub
	}
	
	// 생성자
	public WorkVO(String title, String work, String grade) {
		super();
		this.title = title;
		this.work = work;
		this.grade = grade;
	}

	// setter & getter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	// toString
	@Override
	public String toString() {
		return "BananaVO [title=" + title + ", work=" + work + ", grade=" + grade + "]";
	}
}