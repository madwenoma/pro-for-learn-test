package com.lee.learn.spring.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.GenericConversionService;

/**
 * 本类用于测试spring的类型转化功能
 * @author user
 *
 */
public class TestSpringConverter {
	private	GenericConversionService service;
	
	@Before
	public void setUp() {
		service = ConversionServiceFactory.createDefaultConversionService();
	}
	
	
	@Test
	public void demoStringToBoolean() {
		Assert.assertTrue(service.canConvert(String.class, Boolean.class));
		String boolStr = "true";
		Assert.assertEquals(true, service.convert(boolStr, Boolean.class));
		boolStr = "off";
		Assert.assertEquals(false, service.convert(boolStr, Boolean.class));
	}
	
	@Test
	public void demoStringToInteger() {
		Assert.assertTrue(service.canConvert(String.class, Integer.class));
		String intStr = "100";
		System.out.println(service.convert(intStr, Integer.class));
	}
	
	
}
