package com.henu.app;

import javax.annotation.Resource;

public class ResourceAnnotation {
	private Animal animal;
	public Animal getAnimal() {
		return animal;
	}
    //��idΪanimal��Bean�����ɵĶ���ע�뵽setAnimal�����Ĳ�����
	@Resource(name="swallow")
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		animal.info();
	}
}
