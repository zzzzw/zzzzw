package com.henu.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.henu.app.CollectionObj;

public class CollectionObjTest {
	CollectionObj collection;
	@Test
	public void test() {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		collection = (CollectionObj)aac.getBean("collection");
		for(int i=0;i<2;i++)
			System.out.println(collection.getFieldList().get(i));		
	}

}
