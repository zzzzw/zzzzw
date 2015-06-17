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
		//实例化Bean工厂
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从applicationContext.xml文件中创建id为woodpecker的Woodpecker的Bean对象
		Animal animal = (Woodpecker)beanFactory.getBean("woodpecker");
		//从applicationContext.xml文件中创建id为logHandler的LogHandler的Bean对象
		LogHandler logHandler = (LogHandler)beanFactory.getBean("logHandler");
		logHandler.setObj(animal);
		//动态代理生成Animal对象
		Animal animalProxy = (Animal) Proxy.newProxyInstance(animal.getClass().getClassLoader(), new Class[]{Animal.class},logHandler);
		animalProxy.info();
	}

}
