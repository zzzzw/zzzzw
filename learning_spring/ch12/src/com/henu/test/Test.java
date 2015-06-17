package com.henu.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.henu.app.Animal;
import com.henu.app.LifecycleAnnotation;
import com.henu.app.Woodpecker2;
import com.henu.app.ZZ_Zoo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory aac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
			ZZ_Zoo zz_Zoo = (ZZ_Zoo)aac.getBean("zoo");
			zz_Zoo.add();

	}

}
