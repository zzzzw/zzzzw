package com.henu.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect   //使用@Aspect标注此类为切面类
public class LogHandlerWithSpring{
	//使用@Before标注beforeMethod()方法将在执行Woodpecker类的info()方法之前执行
	@Before("execution(public void com.henu.app.Woodpecker.info(. .))")
	public void beforeMethod(){
		System.out.println("进入动物园之前");
	}
}
