package com.lee.learn.commons.beanutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.junit.Test;

/**
 * org.apache.commons.beanutils.ConvertUtils的用法
 * 1.register的作用：http://blog.csdn.net/msl0903/article/details/7706852 似乎作用不大。
 * 一个转换器就是进行转换任务的核心类，注册之后，该类型的转化任务，都会跟你初始化的转换器相关，如demoConvertUtils中的。
 * 2.转化完后需要强制转换，这里的强制转换只是针对convert的返回值而言，必须用封装类型转化，之后的操作就无所谓了，自动装拆。
 * 3.支持数组转化，详见第34行（通过查看源码得知）
 * 
 * @author user
 * 
 */
public class ConvertUtilsTests {

	@Test
	public void demoConvertUtils() {
		IntegerConverter intConverter = new IntegerConverter(30);
		ConvertUtils.register(intConverter, Integer.class);
		String str = "some string";
		int obj = (Integer) ConvertUtils.convert(str, Integer.class);
		Assert.assertEquals(30, obj);/* 转换默认convert为30，是在第一行中设置的值，在28行恢复设置 */

		intConverter = new IntegerConverter(0);
		ConvertUtils.register(intConverter, Integer.class);
	}

	@Test
	public void intConvert() {
		String str = "1000";
		Object obj = ConvertUtils.convert(str, Integer.class);
		Assert.assertEquals(new Integer(1000), (Integer) obj);
		str = "some string";/* 转换失败，默认convert为0 */
		obj = ConvertUtils.convert(str, Integer.class);
		Assert.assertEquals(0, obj);

		/* 支持数组? */
		String[] strs = { "1000", "99", "22" };// String[] strs = {"1000",
												// "99dds", "22"};
												// //99dds会被转为0，其他的正常
		obj = ConvertUtils.convert(strs, Integer.class);
		Integer[] arr = (Integer[]) obj;
		for (int a : arr) {
			System.out.println(a);
		}
	}

	@Test
	public void booleanConvert() {
		String str = "true";
		Object obj = ConvertUtils.convert(str, Boolean.class);
		Assert.assertTrue((Boolean) obj);

		str = "falsesssss";
		obj = ConvertUtils.convert(str, Boolean.class);
		Assert.assertFalse((Boolean) obj);
	}

	@Test
	public void doubleConvert() {
		String str = "1000.00";
		Object obj = ConvertUtils.convert(str, Double.class);
		Assert.assertEquals(new Double(1000.00), (Double) obj);
		str = "some string";
		obj = ConvertUtils.convert(str, Double.class);
		Assert.assertEquals(new Double(0), (Double) obj);
	}

	/**
	 * 实现自定义的类型转换器 "yyyy-MM-dd HH:ss:mm"
	 */
	@Test
	public void myConvert() {
		class DateConverter implements Converter {
			private SimpleDateFormat format;
			private Date defaultDate;
			public DateConverter(String pattern) {
				super();
				this.format = new SimpleDateFormat(pattern);
				defaultDate = new Date();
			}

			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(Class type, Object value) {
				if (value == null) {
					return null;
				}
				if (value instanceof String) {
					String tmp = (String) value;
					if (tmp.trim().length() == 0)
						return null;
					else {
						try {
							return format.parse(tmp);
						} catch (ParseException e) {
							return defaultDate;
						}
					}
				} else {
					throw new ConversionException("not String");
				}
			}
		}
		
		DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:ss:mm");
		ConvertUtils.register(dateConverter, Date.class);    //注册的意义在于将Date.class作为key放入converters（所有的转换器），value是转化器，即某个类型对应的转换器。
		String dateStr = "1988-01-01 21:21:21";
		Object obj = ConvertUtils.convert(dateStr, Date.class); //转换的时候，先根据Date.class找到对应的转换器，然后调用其convert方法。
		Assert.assertTrue(obj instanceof Date);
		
	}

}
