package com.henu.app;

import org.springframework.stereotype.Component;

//ʹ��@Component��עWoodpecker��
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
		System.out.println("����һֻ��ľ��!");
		System.out.println("���֣�"+birdName);
		System.out.println("ID��"+birdId);
	}
}

