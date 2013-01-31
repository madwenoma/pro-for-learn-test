package com.lee.learn.commons.collections;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.FixedOrderComparator;
import org.apache.commons.lang.StringUtils;

/**
 * BooleanComparator 		– 用于排序一组Boolean对象，指明先true还是先false；
 * 
 * ComparableComparator 	– 用于排序实现了java.lang.Comparable接口的对象（我们常用的Java类如String、Integer、Date、Double、File、Character等等都实现了Comparable接口）；
 * 
 * ComparatorChain 			– 定义一组Comparator链，链中的Comparator对象会被依次执行；
 * 
 * FixedOrderComparator 	– 用于定义一个特殊的顺序，对一组对象按照这样的自定义顺序进行排序；
 * 
 * NullComparator 			– 让null值也可参与比较，可以设定为先null或者后null；
 * 
 * ReverseComparator 		– 将原有的Comparator效果反转；
 * 
 * TransformingComparator 	– 将一个Comparator装饰为具有Transformer效果的Comparator。
 * 
 * @author user
 */

public class ComparatorTests {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		   System.out.println(StringUtils.center(" demoComparator ", 40, "=")); 
	        // data setup 
	        Issue[] issues = new Issue[] { 
	                new Issue(15102, "Major", "John"), 
	                new Issue(15103, "Minor", "Agnes"), 
	                new Issue(15104, "Critical", "Bill"), 
	                new Issue(15105, "Major", "John"), 
	                new Issue(15106, "Major", "John"), 
	                new Issue(15107, "Critical", "John"), 
	                new Issue(15108, "Major", "Agnes"), 
	                new Issue(15109, "Minor", "Julie"), 
	                new Issue(15110, "Major", "Mary"), 
	                new Issue(15111, "Enhancement", "Bill"), 
	                new Issue(15112, "Minor", "Julie"), 
	                new Issue(15113, "Major", "Julie") 
	        }; 
	        // comparators setup 
	        String[] severityOrder = {"Critical", "Major", "Minor", "Enhancement"}; 
	        Comparator severityComparator = new FixedOrderComparator(severityOrder); 
	        ComparatorChain compChain = new ComparatorChain(); 
	        compChain.addComparator(new BeanComparator("owner")); 
	        compChain.addComparator(new BeanComparator("severity", severityComparator)); 
	        compChain.addComparator(new BeanComparator("id")); 
	        // sort and display 
	        Arrays.sort(issues, compChain); 
	        for (int i = 0; i < issues.length; i++) { 
	            System.out.println(issues[i]); 
	        } 
	        System.out.println(StringUtils.repeat("=", 40)); 
	}

}

