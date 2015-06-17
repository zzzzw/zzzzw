package com.henu.app;
public class SetterDI {
	private Animal animal;
	public Animal getAnimal() {
		return animal;
	}
	//通过setter方法传入animal的实例	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		animal.info();
	}
}
