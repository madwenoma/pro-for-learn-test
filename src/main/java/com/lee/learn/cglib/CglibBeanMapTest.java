package com.lee.learn.cglib;

import java.math.BigInteger;

import net.sf.cglib.beans.BeanMap;

/**
 * 相比于BeanCopier,BulkBean，都是针对两个Pojo Bean进行处理，
 * 那如果对象一个是Pojo Bean和Map对象之间，
 * 那就得看看BeanMap，将一个java bean允许通过map的api进行调用。
 * http://www.iteye.com/topic/799827
 * @author user
 *
 */
public class CglibBeanMapTest {
	
	public static void main(String args[]) {  
        // 初始化  
        BeanMap map = BeanMap.create(new Pojo());  
        // 构造  
        Pojo pojo = new Pojo();  
        pojo.setIntValue(1);  
        pojo.setBigInteger(new BigInteger("2"));  
        // 赋值  
        map.setBean(pojo);  
        // 验证  key为属性值
        System.out.println(map.get("intValue"));  
        System.out.println(map.keySet());  
        System.out.println(map.values());  
    }  
}

class Pojo {  
	
    private int        intValue;  
    private BigInteger bigInteger;
    
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	public BigInteger getBigInteger() {
		return bigInteger;
	}
	public void setBigInteger(BigInteger bigInteger) {
		this.bigInteger = bigInteger;
	}  
    
}  