package com.lee.learn.commons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

/**
 * org.apache.commons.collections.CollectionUtils的一些常见用法
 * 
 * @author user
 * 
 */
public class CollectionUtilsTests {

	@SuppressWarnings("rawtypes")
	@Test
	public void demoCollectionUtils() {
		List list = Collections.EMPTY_LIST;
		Assert.assertNotNull(list);
		Assert.assertEquals(0, list.size());
		Assert.assertTrue(CollectionUtils.isEmpty(list));

		List<String> nullList = null;
		Assert.assertNull(nullList);
		Assert.assertTrue(CollectionUtils.isEmpty(nullList));

		String[] arrayA = new String[] { "1", "2", "3", "3", "4", "5" };
		String[] arrayB = new String[] { "3", "4", "4", "5", "6", "7" };
		/*String[] arrayA = new String[] { "1", "2", "3", "4", "5" };
		String[] arrayB = new String[] { "4", "6", "7" };;*/
		List<String> a = Arrays.asList(arrayA);
		List<String> b = Arrays.asList(arrayB);
		/*求并集*/
		Collection union = CollectionUtils.union(a, b);
		System.out.println(union);									/*[3, 3, 2, 1, 7, 6, 5, 4, 4]*/
		Assert.assertEquals(ArrayList.class, union.getClass());
		/*求交集*/
		System.out.println(CollectionUtils.intersection(a, b)); 	/*[3, 5, 4]*/
		/*交集的补集*/
		System.out.println(CollectionUtils.disjunction(a, b));		/*[3, 2, 1, 7, 6, 4] 奇怪的结果，有重复的值都没过滤*/
		/*集合相减*/
		System.out.println(CollectionUtils.subtract(a, b));			/*[1, 2, 3]*/
	}
}
