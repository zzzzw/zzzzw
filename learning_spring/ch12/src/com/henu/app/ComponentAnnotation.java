package com.henu.app;
import javax.annotation.Resource;
public class ComponentAnnotation {
	private Animal animal;
	public Animal getAnimal() {
		return animal;
	}
	//为setAnmial()方法添加@Resource注解
	@Resource     //@Resource(name="bird")指定名称
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		animal.info();
	}
}
