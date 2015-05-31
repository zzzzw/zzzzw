package dao;

import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import model.Student;

public class StudentDao {
	/**	insert;	 */
	public void addStudent(Student stu){
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			session.save(stu);
			tx.commit();
		}catch(HibernateException he){
			tx.rollback();
			he.printStackTrace();
		}finally{
			session.close();
		}
	}
	/**	select;	 */
	public Student getStudent(int sid){
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		Student stu=null;
		try{
			tx=session.beginTransaction();
			stu=(Student)session.load(Student.class,new Integer(sid));
//			stu=(Student)session.get(Student.class,new Integer(sid));
			tx.commit();
		}catch(HibernateException he){
			tx.rollback();
			he.printStackTrace();
		}finally{
			session.close();
		}
		return stu;
	}
	/**	update	 */
	public void updateStudent(String oldName,String newName){
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query q=session.createQuery("from Student s where s.name= ?");
			q.setParameter(0, oldName);
			Iterator<Student> it=q.list().iterator();
			while(it.hasNext()){
				Student s=it.next();
				s.setName(newName);
				session.update(s);
			}
			tx.commit();
			session.close();
		}catch(HibernateException he){
			tx.rollback();
			he.printStackTrace();
		}
	}
	/**	delete	 */
	public void deleteStudent(String str){
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			/*	1.Criteria查询；*/	
			Criteria criter=session.createCriteria(Student.class).add(Restrictions.like("name","%"+str+"%"));
			Iterator<Student> it=criter.list().iterator();
			/*	2.Query查询	
			Query q=session.createQuery("from Student as s where s.name like ?");
			q.setParameter(0, "%"+str+"%");	
			Iterator<Student> it=q.list().iterator();*/	
			/*	3.Native sql查询	表名和表中的列名而不是实体类的类名和属性名了
			SQLQuery sqlq=session.createSQLQuery("SELECT * FROM s WHERE sname like ?").addEntity(Student.class);
			sqlq.setParameter(0, "%"+str+"%");
			Iterator<Student> it=sqlq.list().iterator();	*/
			while(it.hasNext()){
				session.delete(it.next());
			}
			tx.commit();
		} catch (HibernateException he) {
			tx.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}
}
