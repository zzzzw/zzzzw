package com.henu.app;
public class AutowireByName {
	private Animal woodpecker;
	public Animal getWoodpecker() {
		return woodpecker;
	}
	//ͨ��setter��������animal��ʵ��
	public void setWoodpecker(Animal woodpecker) {
		this.woodpecker = woodpecker;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		woodpecker.info();
	}
}
