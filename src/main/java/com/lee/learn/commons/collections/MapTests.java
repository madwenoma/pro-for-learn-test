package com.lee.learn.commons.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import junit.framework.Assert;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * BidiMap  双向map key-value value-key（key和value都不可以重复）
 * MultiMap 一个key对应的是一组数量不定对象，返回的是一个collection，一对多的实现
 * LazyMap	这个map的键值开始不存在，调用时才创建。有什么用?：
 * 		1.需要一个Map，但是由于创建成员的方法很“重”（比如数据库访问），或者我们只有在调用get()时才知道如何创建，
 * 		2.或者Map中出现的可能性很多很多，我们无法在get()之前添加所有可能出现的键/值对，
 * 		我们觉得没有必要去初始化一个Map而又希望它可以在必要时自动处理数据生成的话，LazyMap就变得很有用
 * MapUtils
 * 
 * @author user
 */
public class MapTests {
	
	/**
	 * 测试 BidiMap - key value的双向map
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void demoBidiMap(){
		System.out.println(StringUtils.center("BidiMap Demo", 40, "="));
		BidiMap bidi = new DualHashBidiMap();
		bidi.put("bj", "北京");
		bidi.put("qd", "青岛");
		//bidi.put("qd2", "青岛"); //加入此行，bidi.getKey("青岛")得到的是qd2
		Assert.assertEquals("bj", bidi.getKey("北京"));
		System.out.println(bidi.getKey("青岛"));
		Set<Entry<String, String>> entrySet = bidi.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println(StringUtils.repeat("=", 40));
	}
	
	/**
	 * MultiMap Demo,类似于map中存放的是key对应一个list的感觉
	 */
	@Test
	public void demoMutilMap(){
        System.out.println(StringUtils.center("MutilMap Demo", 40, "="));
	    MultiMap multiMap = new MultiValueMap();
        multiMap.put("SW-BOSS", "布鲁斯");
        multiMap.put("SW-BOSS", "双子");
        multiMap.put("SW-BOSS", "穆鲁");
        multiMap.put("SW-BOSS", "阿克蒙德");
        Assert.assertTrue(multiMap.get("SW-BOSS") instanceof ArrayList);
		System.out.println(multiMap.get("SW-BOSS"));
    }
	
	/**
	 * LazyMap - not synchronized and is not thread-safe
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void demoLazyMap() {
		System.out.println(StringUtils.center(" LazyMap Demo ", 40, "="));
		// borrowed from Commons Collection's Javadoc
		Factory factory = new Factory() {
			public Object create() {
				return new Date();
			}
		};
		Map lazy = LazyMap.decorate(new HashMap(), factory);
		System.out.println(lazy.get("NOW")); //随便参数都可以，动态取，即检测是否有此key，没有当即添加，value的值为factory中返回的
		System.out.println(StringUtils.repeat("=", 40));
	}
}
