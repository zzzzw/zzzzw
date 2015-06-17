package com.henu.app;
public class ConstructorDI {
	private Animal animal;
	public ConstructorDI(Animal animal) {
		this.animal = animal;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		animal.info();
	}
}
