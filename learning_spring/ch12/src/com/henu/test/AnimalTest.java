package com.henu.test;

import com.henu.app.Animal;
import com.henu.app.Dog;

public class AnimalTest {
	public static void main(String[] args){
		Animal animal = new Dog();//如果输出猫的信息，则实例化一个Cat对象
		animal.info();
	}
}
