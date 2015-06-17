package com.henu.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.henu.app.ZZ_Zoo;

public class ZZ_ZooTest {
	ZZ_Zoo zz_Zoo;

	@Test
	public void testAdd() {
		AbstractApplicationContext aac = 
				new ClassPathXmlApplicationContext("bean.xml");
			zz_Zoo = (ZZ_Zoo)aac.getBean("zoo");
			zz_Zoo.add();

	}

}
