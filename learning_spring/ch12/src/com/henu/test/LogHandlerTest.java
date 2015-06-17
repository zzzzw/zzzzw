package com.henu.test;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.henu.aop.LogHandler;
import com.henu.app.Animal;
import com.henu.app.Woodpecker;

public class LogHandlerTest {

	@Test
	public void test() {
		//ʵ����Bean����
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
		//��applicationContext.xml�ļ��д���idΪwoodpecker��Woodpecker��Bean����
		Animal animal = (Woodpecker)beanFactory.getBean("woodpecker");
		//��applicationContext.xml�ļ��д���idΪlogHandler��LogHandler��Bean����
		LogHandler logHandler = (LogHandler)beanFactory.getBean("logHandler");
		logHandler.setObj(animal);
		//��̬��������Animal����
		Animal animalProxy = (Animal) Proxy.newProxyInstance(animal.getClass().getClassLoader(), new Class[]{Animal.class},logHandler);
		animalProxy.info();
	}

}
