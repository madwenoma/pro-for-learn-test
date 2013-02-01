package com.lee.learn.reflect;

import java.lang.reflect.Field;


/**
 * 反射获取实例属性
 * @author user
 *
 */
public class ReflectFieldTest {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		UserProfile profile = new UserProfile("papa", "papa@sina.com", 23);
		ClientInfo info = new ClientInfo("8.1.10.0", profile);
		Class<?> infoClass= info.getClass();
		Field[] fields = infoClass.getDeclaredFields();
		
		for (Field field : fields) {
			String name = field.getName();
			field.setAccessible(true);
			System.out.print(name + "-");
			System.out.println(field.get(info));
		}
	}
}

class ClientInfo {
	
	private String version;
	private UserProfile userProfile;
	
	
	public ClientInfo(String version, UserProfile userProfile) {
		super();
		this.version = version;
		this.userProfile = userProfile;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	@Override
	public String toString() {
		return "ClientInfo [version=" + version + ", userProfile="
				+ userProfile + "]";
	}
}

class UserProfile {
	private String nickName;
	private String email;
	private int age;
	
	public UserProfile(String nickName, String email, int age) {
		super();
		this.nickName = nickName;
		this.email = email;
		this.age = age;
	}
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
	@Override
	public String toString() {
		return "UserProfile [nickName=" + nickName + ", email=" + email
				+ ", age=" + age + "]";
	}
}