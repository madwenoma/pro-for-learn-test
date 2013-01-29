package com.lee.learn.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BookFacadeCglib implements MethodInterceptor{

	private Object target;
	
	public Object getInstance(Object target){
		this.target = target;
		/*enhancer的翻译为 增强者、加强者*/
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("do something before method invoke");
		proxy.invokeSuper(obj, args);
		System.out.println("do something after method invoked");
		return null;
	}
	
	

}
