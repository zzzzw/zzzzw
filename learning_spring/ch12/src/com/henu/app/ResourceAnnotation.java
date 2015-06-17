package com.henu.app;

import javax.annotation.Resource;

public class ResourceAnnotation {
	private Animal animal;
	public Animal getAnimal() {
		return animal;
	}
    //将id为animal的Bean所生成的对象注入到setAnimal方法的参数中
	@Resource(name="swallow")
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		animal.info();
	}
}
