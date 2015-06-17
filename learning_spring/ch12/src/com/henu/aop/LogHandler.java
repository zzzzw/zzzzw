package com.henu.aop;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class LogHandler implements InvocationHandler {
	private Object obj;
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	//横向切入点
	public void beforeMethod(){
		System.out.println("进入动物园之前");
	}
	public void afterMethod(){
		System.out.println("进入动物园之后");
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		beforeMethod();
		method.invoke(obj, args);
		afterMethod();
		return null;
	}
}
