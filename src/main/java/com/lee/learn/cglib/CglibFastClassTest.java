package com.lee.learn.cglib;

import static java.lang.System.out;

import java.lang.reflect.Field;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

/**
 * 测试cglib的FastClass类
 * http://www.iteye.com/topic/799827
 * @author user
 *
 */
public class CglibFastClassTest {
	
	public static void println(String str){
		out.println(str);
	}
	
	public static void main(String args[]) throws Exception {  
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\cglib-debug");  
  
        FastClass clazz = FastClass.create(FastSource.class);  
        // fast class反射调用  
        FastSource obj = (FastSource) clazz.newInstance();
        clazz.invoke("setValue", new Class[] { int.class }, obj, new Object[] { 1 });  
        clazz.invoke("setOther", new Class[] { int.class }, obj, new Object[] { 2 });  
  
        int value = (Integer) clazz.invoke("getValue", new Class[] {}, obj, new Object[] {});  
        int other = (Integer) clazz.invoke("getOther", new Class[] {}, obj, new Object[] {});  
        println(value + " " + other);  
        // fastMethod使用  
        FastMethod setValue = clazz.getMethod("setValue", new Class[] { int.class });  
        println("setValue index is : " + setValue.getIndex());  
  
        FastMethod getValue = clazz.getMethod("getValue", new Class[] {});  
        println("getValue index is : " + getValue.getIndex());  
  
        FastMethod setOther = clazz.getMethod("setOther", new Class[] { int.class });  
        println("setOther index is : " + setOther.getIndex());  
  
        FastMethod getOther = clazz.getMethod("getOther", new Class[] {});  
        println("getOther index is : " + getOther.getIndex());  
        // 其他  
        println("getDeclaredMethods : " + clazz.getJavaClass().getDeclaredMethods().length);  
        println("getConstructors : " + clazz.getJavaClass().getConstructors().length);  
        println("getFields : " + clazz.getJavaClass().getDeclaredFields().length);  
        Field[] f =   clazz.getJavaClass().getDeclaredFields();
        for (Field field : f) {
			System.out.println(field.getName());
			System.out.println(field.get(obj));
        }
        
        
        
        
        println("getMaxIndex : " + clazz.getMaxIndex());  
    }  
}  
  
class FastSource {  
    private int value;  
    private int other;
    private UserProfile userProfile;
    
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getOther() {
		return other;
	}
	public void setOther(int other) {
		this.other = other;
	}  
}  


class UserProfile {
	private String nickName;
	private String email;
	private int age;
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
