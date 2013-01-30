package com.lee.learn.spring.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.util.ReflectionUtils;

class Animal{
	private int weight;
	private String name;
	
	public Animal() {
		super();
	}

	public Animal(int weight, String name) {
		super();
		this.weight = weight;
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void methodOne() {
		System.out.println("method one invoked");
	}
	public int methodTwo(String words) {
		System.out.println("method two invoked," + words);
		return 100;
	}
}

public class TestSpringUtils {

	@Test
	public void demoReflectUtils() {
		Animal dog = new Animal(100, "dog");
		Assert.assertEquals(100,   getFieldValue(dog, "weight"));
		Assert.assertEquals("dog", getFieldValue(dog, "name"));
		setFieldValue(dog, "name", "dogOne");
		Assert.assertEquals("dogOne", getFieldValue(dog, "name"));
		invokeMethod(dog, "methodOne");
		Assert.assertEquals(100, invokeMethod(dog, "methodTwo", "haha"));
	}
	
	/**
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public Object getFieldValue(Object obj, String fieldName) {
		Field field = ReflectionUtils.findField(obj.getClass(), fieldName);
		ReflectionUtils.makeAccessible(field);
		return ReflectionUtils.getField(field, obj);
	};
	
	/**
	 * 
	 * @param target
	 * @param fieldName
	 * @param value
	 */
	public void setFieldValue(Object target, String fieldName, Object value) {
		Field field = ReflectionUtils.findField(target.getClass(), fieldName);
		ReflectionUtils.makeAccessible(field);
		ReflectionUtils.setField(field, target, value);
	}
	
	/**
	 * 
	 * @param target
	 * @param methodName
	 * @param args
	 * @return
	 */
	public Object invokeMethod(Object target, String methodName, Object... args){
		Method method = null;
		if (args == null || args.length == 0) {
			method = ReflectionUtils.findMethod(target.getClass(), methodName);
			ReflectionUtils.makeAccessible(method);
			return ReflectionUtils.invokeMethod(method, target);
		} else {
			Class<?>[] classes = new Class[args.length];
			for (int i = 0; i < classes.length; i++) {
				classes[i] = args[i].getClass();
			}
			method = ReflectionUtils.findMethod(target.getClass(), methodName, classes);
			ReflectionUtils.makeAccessible(method);
			return ReflectionUtils.invokeMethod(method, target, args);
		}
	}
	
	@Test
	public void demoStringUtils() {
	}
}
