package com.lee.learn.commons.collections;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

/**
 * org.apache.commons.collections.MapUtils 的一些常见用法
 * @author user
 *
 */
public class MapUtilsTests {
	
	@SuppressWarnings("rawtypes")
	@Test//(expected = NullPointerException.class)
	public void test(){
		HashMap<String, String> nullHashMap = null;
		Assert.assertTrue(MapUtils.isEmpty(nullHashMap));
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("100", "100");
		int a = MapUtils.getInteger(map, "100");
		Integer a1 = MapUtils.getInteger(map, "1000");
		//System.out.println(a1.intValue());
		Assert.assertEquals(null, a1);
		Assert.assertEquals(100, a);
		
		Map typeMap = MapUtils.typedMap(map, String.class, String.class);
		System.out.println(typeMap.size());
	}
	
}
