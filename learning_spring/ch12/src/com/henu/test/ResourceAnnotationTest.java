package com.henu.test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.henu.app.ResourceAnnotation;
public class ResourceAnnotationTest {
	ResourceAnnotation resource;
	@Test
	public void test() {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		resource = (ResourceAnnotation)aac.getBean("resource");
		resource.add();
	}
}
