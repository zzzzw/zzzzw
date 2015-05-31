package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory=buildSessionFactory();
	
	/**	init sessionFactory	*/
	private static SessionFactory buildSessionFactory() {
		SessionFactory sessionFactory=null;
		try{
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}catch(Throwable te){
			System.err.println("init sessionFactory Error:"+te);
			te.printStackTrace();
		}
		return sessionFactory;
	} 
	
	/**	get session	*/
	public static Session getSession(){
		Session stion=sessionFactory.openSession();
		return stion;
	}

}
