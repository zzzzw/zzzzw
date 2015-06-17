package com.henu.app;
import org.springframework.beans.factory.annotation.*;
public class Woodpecker2 extends Bird {
	private Animal animal;
	public Animal getAnimal() {
		return animal;
	}
	@Autowired
	public void setAnimal(@Qualifier("swallow") Animal animal) {
		this.animal = animal;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		animal.info();
	}
}