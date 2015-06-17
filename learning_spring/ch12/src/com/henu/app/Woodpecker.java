package com.henu.app;

import org.springframework.stereotype.Component;

//使用@Component标注Woodpecker类
@Component
public class Woodpecker extends Bird {
	private String birdName;
	private int birdId;	
	public String getBirdName() {
		return birdName;
	}
	public void setBirdName(String birdName) {
		this.birdName = birdName;
	}
	public int getBirdId() {
		return birdId;
	}
	public void setBirdId(int birdId) {
		this.birdId = birdId;
	}
	@Override
	public void info() {
		System.out.println("这是一只啄木鸟!");
		System.out.println("名字："+birdName);
		System.out.println("ID："+birdId);
	}
}

