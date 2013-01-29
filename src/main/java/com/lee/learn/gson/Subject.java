package com.lee.learn.gson;

import java.io.Serializable;

/**
 * 学科类，包含学科名字和学科老师名字
 * 
 * @author yanghui<yanghui1986527@gmail.com>
 */
public class Subject implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2574980011831897251L;

	private String subject_name;
	private String teacher_name;

	/**
	 * 
	 * @return  subject_name 学科名称
	 */
	public String getSubject_name() {
		return subject_name;
	}

	/**
	 * @param  subject_name 学科名称
	 */
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	/**
	 *
	 * @return  teacher_name 学科老师的名字
	 */
	public String getTeacher_name() {
		return teacher_name;
	}

	/**
	 * 
	 * @param teacher_name 学科老师的名字
	 */
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	@Override
	public String toString() {
		return "Subject [subject_name=" + subject_name + ", teacher_name="
				+ teacher_name + "]";
	}
	
	
	
}
