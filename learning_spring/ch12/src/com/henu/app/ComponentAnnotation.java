package com.henu.app;
import javax.annotation.Resource;
public class ComponentAnnotation {
	private Animal animal;
	public Animal getAnimal() {
		return animal;
	}
	//ΪsetAnmial()��������@Resourceע��
	@Resource     //@Resource(name="bird")ָ������
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		animal.info();
	}
}