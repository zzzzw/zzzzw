package com.henu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.henu.app.LifecycleAnnotation;

public class LifecycleAnnotationTest {
	LifecycleAnnotation lifecycle;
	@Test
	public void test() {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		lifecycle = (LifecycleAnnotation)aac.getBean("lifecycle");
		lifecycle.add();
	}
}
