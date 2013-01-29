package com.lee.learn.gson;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 学生类，包含学生名字和学科列表
 * 
 * @author yanghui<yanghui1986527@gmail.com>
 */
public class Student implements Serializable {

    /**
     * Serializable
     */
    private static final long serialVersionUID = -2689979321936117293L;
    
    private String name;
    
    private ArrayList<Subject> subjects;

    /**
     * 
     * @return name 学生名字
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 学生名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return subjects 学科列表
     */
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    /**
     * 
     * @param subjects 学科列表
     */
    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

	@Override
	public String toString() {
		return "Student [name=" + name + ", subjects=" + subjects
				+ ", getName()=" + getName() + ", getSubjects()="
				+ getSubjects() + "]";
	}

    
}