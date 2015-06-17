package com.henu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.henu.app.Animal;
import com.henu.app.Woodpecker;

public class LogHandlerWithSpringTest {

	@Test
	public void test() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Woodpecker animal = (Woodpecker) beanFactory.getBean("animal");
		//调用info()方法，验证@Before织入点是否执行
		animal.info();
	}

}
