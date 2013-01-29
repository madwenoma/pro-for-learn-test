package com.lee.learn.spring.util;

import java.lang.reflect.Field;

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
}

public class TestSpringUtils {

	@Test
	public void demoReflectUtils() {
		Animal dog = new Animal(100, "dog");
		Assert.assertEquals(100, getFieldValue(dog, "weight"));
		Assert.assertEquals("dog", getFieldValue(dog, "name"));
	}
	
	public Object getFieldValue(Object obj, String fieldName) {
		Field field = ReflectionUtils.findField(obj.getClass(), fieldName);
		ReflectionUtils.makeAccessible(field);
		return ReflectionUtils.getField(field, obj);
	};
	
	
	
}
