package service;

import dao.StudentDao;
import model.Student;

public class StudentManager {
	StudentDao dao=new StudentDao();
	public void save(Student stu){
		dao.addStudent(stu);
	}
	public Student get(int id){
		return dao.getStudent(id);
	}
	public void update(String oname,String nname){
		dao.updateStudent(oname, nname);
	}
	public void delete(String name){
		dao.deleteStudent(name);
	}
}
