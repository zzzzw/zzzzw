package com.henu.test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.henu.app.SetterDI;
public class SetterDITest {
	SetterDI setterDI;
	@Test
	public void testAdd() {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		setterDI = (SetterDI)aac.getBean("setterDI");
		setterDI.add();
	}
}
