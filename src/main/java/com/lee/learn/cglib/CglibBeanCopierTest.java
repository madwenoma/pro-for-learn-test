package com.lee.learn.cglib;

import java.math.BigInteger;
import java.util.Date;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

//import net.sf.cglib.core.DebuggingClassWriter;

public class CglibBeanCopierTest {

	static class Source {

		private int value;
		private Date date;

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	static class Target {
		private int value;
		private Date date;

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	public static void main(String args[]) {
		// System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
		// "/tmp/1");
		BeanCopier copier = BeanCopier.create(Source.class, Target.class, true);
		Source from = new Source();
		from.setValue(1);
		from.setDate(new Date());
		
		Target to = new Target();
		Converter converter = new BigIntConverter();
		copier.copy(from, to, converter); // 使用converter类

		System.out.println(to.getValue());
		System.out.println(to.getDate());
	}
}

class BigIntConverter implements net.sf.cglib.core.Converter {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object convert(Object value, Class target, Object context) {
		System.out.println(value.getClass() + " " + value); // from类中的value对象
		System.out.println(target); // to类中的定义的参数对象
		System.out.println(context.getClass() + " " + context); // String对象,具体的方法名
		if (target.isAssignableFrom(BigInteger.class)) {
			return new BigInteger(value.toString());
		} else {
			return value;
		}
	}

}