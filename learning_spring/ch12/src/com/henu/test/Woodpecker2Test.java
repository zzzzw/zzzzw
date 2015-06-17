package com.henu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.henu.app.Woodpecker2;

public class Woodpecker2Test {
	Woodpecker2 woodpecker;
	@Test
	public void test() {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		woodpecker = (Woodpecker2)aac.getBean("woodpecker2");
		woodpecker.add();
	}
}
