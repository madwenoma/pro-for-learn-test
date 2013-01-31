package com.lee.learn.guava;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

public class TestGuava {
	
	@Test
	public void demoMap() {
		Map<String, Map<Long, List<String>>> map = Maps.newHashMap();
		Assert.assertNotNull(map);
		
	}
	
	@Test
	public void demoList() {
		ImmutableList<String> list = ImmutableList.of("a", "b", "c", "d");
		Assert.assertEquals("a", list.get(0));
	}
	
}
