package com.henu.test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.henu.app.ConstructorDI;
import com.henu.app.SetterDI;
public class ConstructorDITest {
	ConstructorDI constructorDI;
	@Test
	public void test() {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		constructorDI = (ConstructorDI)aac.getBean("constructorDI");
		constructorDI.add();
	}
}
