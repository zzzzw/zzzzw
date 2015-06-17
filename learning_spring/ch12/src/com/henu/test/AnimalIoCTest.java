package com.henu.test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.henu.app.Animal;
import com.henu.app.ZZ_Zoo;
public class AnimalIoCTest {
	public static void main(String[] args){
		ZZ_Zoo zz_Zoo = new ZZ_Zoo();
		Animal animal;
		BeanFactory applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		animal = (Animal)applicationContext.getBean("imp");
		zz_Zoo.setAnimal(animal);
		zz_Zoo.add();	
	}
}
