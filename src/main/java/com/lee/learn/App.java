package com.lee.learn;

/**
 * Hello world!
 *
 */
public class App 
{
    enum Source{
    	Engine,Database
    }
	
	
	public static void main( String[] args )
    {
    	
		System.out.println(Source.Engine.toString().equals("Engine"));
		int capacity = 1;
        while (capacity < 1){
        	capacity <<= 1;
        	System.out.println(capacity);
        }
        System.out.println(capacity);
    }
    
    
    
}
