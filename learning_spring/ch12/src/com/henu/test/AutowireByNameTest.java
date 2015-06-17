package com.henu.test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.henu.app.AutowireByName;
import com.henu.app.ConstructorDI;
public class AutowireByNameTest {
	AutowireByName byname;
	@Test
	public void test() {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		byname = (AutowireByName)aac.getBean("byname");
		byname.add();
	}
}
