package com.lee.learn.commonlang;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;


public class CommonLangTest {
	public static void main(String[] args) throws InterruptedException {
		String doubleStr = "100.00";
		System.out.println(isDouble(doubleStr));
		testStringUtils();
		
		testStopWatch();
	}
	
	public static boolean isDouble(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		
		try {
			Double.valueOf(str);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public static void testStringUtils(){
		String str1 = "";
		String str2 = null;
		System.out.println(StringUtils.isEmpty(str1));
		System.out.println(StringUtils.isEmpty(str2));
		System.out.println(StringUtils.isBlank(str2));
	}
	
	
	
	public static void testStopWatch() throws InterruptedException{
		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println(sw.getStartTime());
		
		TimeUnit.SECONDS.sleep(3);
		sw.split();
		TimeUnit.SECONDS.sleep(2);
		System.out.println("split executed");
		sw.stop();
		//sw.reset();\
		System.out.println(sw.getSplitTime());
		System.out.println(sw.getTime());
		
	}
	
	
	
	
	
	
}
