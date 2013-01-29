package com.lee.learn.commonlang;

import java.util.Properties;

import org.apache.commons.collections.ExtendedProperties;
import org.junit.Test;

public class ExtendedPropertiesTest {
	ExtendedProperties p = new ExtendedProperties();
	ExtendedProperties configuration = new ExtendedProperties();
	
	
	@Test
	public void testExtendedProperties(){
		System.out.println(p.isInitialized());
		Properties props = new Properties();
		props.setProperty("key", "value");
		ExtendedProperties ep = ExtendedProperties.convertProperties(props);
		p = ep;
		this.configuration.combine(p);
		System.out.println(configuration.isInitialized());
	
	}
}
