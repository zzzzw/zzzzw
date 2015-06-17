package com.henu.app;
public class AutowireByName {
	private Animal woodpecker;
	public Animal getWoodpecker() {
		return woodpecker;
	}
	//通过setter方法传入animal的实例
	public void setWoodpecker(Animal woodpecker) {
		this.woodpecker = woodpecker;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		woodpecker.info();
	}
}
