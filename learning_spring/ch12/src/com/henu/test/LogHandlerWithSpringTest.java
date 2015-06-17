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
		//����info()��������֤@Before֯����Ƿ�ִ��
		animal.info();
	}

}
