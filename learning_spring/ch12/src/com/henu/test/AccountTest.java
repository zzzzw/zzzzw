package com.henu.test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.henu.app.Account;
public class AccountTest {
	Account account;
	@Test
	public void test() {
		ClassPathXmlApplicationContext aac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
			account = (Account)aac.getBean("account");
			aac.destroy();
	}
}
