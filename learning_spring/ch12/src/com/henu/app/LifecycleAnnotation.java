package com.henu.app;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
 @Resource
public class LifecycleAnnotation {
	private Animal animal;
	public Animal getAnimal() {
		return animal;
	}
	@PostConstruct
	public void init(){
		System.out.println("init zoo");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("destroy zoo");
	}
	@Autowired
	public void setAnimal(@Qualifier("swallow")Animal animal) {
		this.animal = animal;
	}
	public void add(){
		System.out.println("the animal is in the zoo and");
		animal.info();
	}
}
