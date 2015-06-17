package com.henu.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.henu.app.Animal;
import com.henu.app.ZZ_Zoo;

public class AnimalTestWithSpring {
	public static void main(String[] args){
		ZZ_Zoo zz_Zoo = new ZZ_Zoo();
		Animal animal;
		BeanFactory applicationContext = null;
		try {
			applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		animal = (Animal)applicationContext.getBean("imp");
		zz_Zoo.setAnimal(animal);
		zz_Zoo.add();
	}
}
