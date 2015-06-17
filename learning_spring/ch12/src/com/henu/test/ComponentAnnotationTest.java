package com.henu.test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.henu.app.ComponentAnnotation;


public class ComponentAnnotationTest {
	ComponentAnnotation comp;
	@Test
	public void test() {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		comp = (ComponentAnnotation)aac.getBean("component");
		comp.add();
	}
}
