package com.lee.learn.commons.collections;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.collection.TypedCollection;

public class TypedCollectionTests {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Collection c = TypedCollection.decorate(list, String.class);
		c.add("ass");
		//c.add(110); //exception ,must be String
		System.out.println(c.size());
		
	}
}
