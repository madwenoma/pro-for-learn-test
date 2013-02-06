package com.lee.learn.commons.collections;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public class PredicateImpl implements Predicate {

	private String propertyName;
	private Object inValue;

	public PredicateImpl(String propertyName, Object inValue) {
		this.propertyName = propertyName;
		this.inValue = inValue;
	}

	@Override
	public boolean evaluate(Object object) {
		try {
			Object beanValue;
			if (propertyName.indexOf(".") > 0) {
				beanValue = PropertyUtils.getNestedProperty(object, propertyName);
			} else {
				beanValue = PropertyUtils.getProperty(object, propertyName);	
			}
			if (beanValue == null)
				return false;
			if (!beanValue.getClass().equals(inValue.getClass())) {
				 throw new RuntimeException("value.class!=beanValue.class");
			}
			return compare(inValue, beanValue);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		
	}

	private boolean compare(Object inValue, Object beanValue) {
		return inValue.equals(beanValue);
	}
	
	
	public static void main(String[] args) {
		
		
		ArrayList<Employee> e = new ArrayList<Employee>(); 
		e.add(new Employee("lodos", 12, new Date(), "grade one", 1000.00));
		e.add(new Employee("moon", 22, new Date(), "grade two", 2000.00));
		e.add(new Employee("lucifer", 32, new Date(), "grade three", 2000.00));
		Object o = CollectionUtils.select(e, new PredicateImpl("age", new Integer(32)));	
		System.out.println(o);
	}
	

}
