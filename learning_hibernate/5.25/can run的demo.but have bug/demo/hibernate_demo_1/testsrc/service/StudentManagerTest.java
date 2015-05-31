package service;

import model.Student;
import org.junit.Before;
import org.junit.Test;

public class StudentManagerTest {
	StudentManager manager;
	@Before
	public void init(){
		manager=new StudentManager();
	}
	@Test public void testSave() {
		Student stu1=new Student();
		stu1.setName("Nie");
		manager.save(stu1);
	}
	@Test public void testGet(){
		Student stu=manager.get(14);
		System.out.println(stu.getName());
	}
	@Test public void testUpdate(){
		manager.update("Herry","Nie");
	}
	@Test public void testDelete(){
		manager.delete("ie");
	}
}
//Hibernate: select student0_.sid as sid0_0_, student0_.sname as sname0_0_ from s student0_ where student0_.sid=?
//Hibernate: select this_.sid as sid0_0_, this_.sname as sname0_0_ from s this_ where this_.sname like ?
