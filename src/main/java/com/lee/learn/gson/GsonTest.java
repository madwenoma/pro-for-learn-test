package com.lee.learn.gson;

import java.util.ArrayList;

import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[] args) {

		Gson gson = new Gson();
		// 创建一个学生对象
		Student originStudent = getStudent();

		// 将学生对象转换成JSON串
		String response = gson.toJson(originStudent);
		System.out.println(response);

		// 将JSON串再还原成一个学生对象
		Student newstudent = gson.fromJson(response, Student.class);
		System.out.println(newstudent);

	}

	public static Student getStudent() {
		Subject sub1 = new Subject();
		sub1.setSubject_name("语文");
		sub1.setTeacher_name("张老师");

		Subject sub2 = new Subject();
		sub2.setSubject_name("数学");
		sub2.setTeacher_name("黄老师");

		Subject sub3 = new Subject();
		sub3.setSubject_name("英文");
		sub3.setTeacher_name("林老师");

		ArrayList<Subject> subjects = new ArrayList<Subject>();
		subjects.add(sub1);
		subjects.add(sub2);
		subjects.add(sub3);

		Student student = new Student();
		student.setName("杨辉");
		student.setSubjects(subjects);

		return student;
	}

}