package com.lee.learn.others;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMd5 {
	public static void main(String[] args) {
		//limit 3,onlyfree 1,timestamp 20130116164603,keyversion 1,clientid 10001,passcode
		//rest/openread/cat/supercatlog/cntlist/3/20130118112301/10001/1/1ccaac24f6e7131e6566f11e0b5e963c
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println(timestamp);
		System.out.println(getMD5Str(timestamp + "100011yitianxindong"));
	}
	  /** 
     * MD5 加密 
     */  
    private static String getMD5Str(String str) {  
        MessageDigest messageDigest = null;  
  
        try {  
            messageDigest = MessageDigest.getInstance("MD5");  
  
            messageDigest.reset();  
  
            messageDigest.update(str.getBytes("UTF-8"));  
        } catch (NoSuchAlgorithmException e) {  
            System.out.println("NoSuchAlgorithmException caught!");  
            System.exit(-1);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
  
        byte[] byteArray = messageDigest.digest();  
  
        StringBuffer md5StrBuff = new StringBuffer();  
  
        for (int i = 0; i < byteArray.length; i++) {              
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
            else  
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
        }  
  
        return md5StrBuff.toString();  
    }  
}
