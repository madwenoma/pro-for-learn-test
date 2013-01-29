package com.lee.learntest.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.lee.learn.cglib.BookFacadeCglib;
import com.lee.learn.cglib.BookFacadeImpl;

/**
 * 测试未实现接口的类的cglib的动态代理功能
 * 与jdk动态代理的最大区别在于，jdk的动态代理类必须是一个实现某个接口的类
 * @{link} BookFacade
 * @{link} BookFacadeImpl
 * @{link} BookFacadeCglib
 * 
 * @author user
 */
public class CglibTest {
	
	private BookFacadeCglib cglibProxy;
	
	@Before
	public void prepare(){
		cglibProxy = new BookFacadeCglib();
		System.out.println("prepare executed");
	}
	
	/**
	 * 测试未实现接口的类的cglib的动态代理功能
	 * 与jdk动态代理的最大区别在于，jdk的动态代理类必须是一个实现某个接口的类
	 */
	@Test
	public void testObjectNotImpl(){
		Assert.assertNotNull(cglibProxy);
		BookFacadeImpl target = new BookFacadeImpl();
		target = (BookFacadeImpl) cglibProxy.getInstance(target); /*交给cglib代理*/
		target.addBook();
	}
}
