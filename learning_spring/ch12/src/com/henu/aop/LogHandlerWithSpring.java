package com.henu.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect   //ʹ��@Aspect��ע����Ϊ������
public class LogHandlerWithSpring{
	//ʹ��@Before��עbeforeMethod()��������ִ��Woodpecker���info()����֮ǰִ��
	@Before("execution(public void com.henu.app.Woodpecker.info(. .))")
	public void beforeMethod(){
		System.out.println("���붯��԰֮ǰ");
	}
}
