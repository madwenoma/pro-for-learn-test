package com.lee.learn.commons.collections;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 这个东西有什么作用?验证字符串是否合法? 
 * 		是的这个词的意思就是“断言”
 * Predicate
 * AndPredicate 
 * OrPredicate 
 * AllPredicate 
 * OnePredicate 
 * NonePredicate 
 * PredicateUtils 
 * 
 * 它以一个Object对象为参数，处理后返回一个boolean值，检验某个对象是否满足某个条件。
 * 其实这个Predicate以及上一篇笔记提到的Comparator还有我们即将看到的Transformer和Closure等都有些类似C/C++中的函数指针，
 * 它们都只是提供简单而明确定义的函数功能而已。
 * 
 * 跟其他组类似，Commons Collections也提供了一组定义好的Predicate类供我们使用，
 * 这些类都放在org.apache.commons.collections.functors包中。当然，我们也可以自定义Predicate，
 * 只要实现这个Predicate接口即可。在Commons Collections中我们也可以很方便使用的一组预定义复合Predicate，
 * 我们提供2个或不定数量个Predicate，然后交给它，它可以帮我们处理额外的逻辑，如AndPredicate处理两个Predicate，
 * 只有当两者都返回true它才返回true；AnyPredicate处理多个Predicate，当其中一个满足就返回true，等等。
 * @author user
 *
 */
public class PredicateTests {
	
	public static void main(String[] args) {
		
		demoPredicates();
	}
	
	 public static void demoPredicates() {
	        System.out.println(StringUtils.center(" demoPredicates ", 40, "="));
	        Predicate p1 = new InstanceofPredicate(String.class);
	        Predicate p2 = NotNullPredicate.getInstance();
	        Predicate p3 = new Predicate() {
	            public boolean evaluate(Object obj) {
	                String str = (String) obj;
	                return StringUtils.isAlphanumeric(str) 
	                		&& str.length() >= 6 
	                		&& str.length() <= 10;
	            }
	        };
	        Predicate p4 = PredicateUtils.allPredicate(new Predicate[]{p1, p2, p3});   
	        
	        String input = "ABCD1234";
	        Object[] raw = new Object[] {
	            "Is '",
	            input,
	            "' a valid input? ",
	            BooleanUtils.toStringYesNo(p4.evaluate(input)),
	            "."
	        };
	        System.out.println(StringUtils.join(raw));
	        System.out.println(StringUtils.repeat("=", 40));
	    }
	
}
