package com.henu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.henu.domain.Person;

public class TestHibernate
{
	Congfiguration cfg=new Configuration();
	SessionFactory sf=cfg.congigure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
	Person tom=new Person();
	tom.setName("Tom");
	tom.setAge(29);
	tom.setMajor("Computer Science");
	session.save(tom);
	tx.commit();
	session.close();
}
package com.henu.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Congfiguration;
import com.henu.domain.Person;
public class TestHibernate
{
	Congfiguration cfg=new Congfiguration();
	SessionFactory sf=cfg.congigure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
	Person tom=new Person();
	tom.setName("Tom");
	tom.setAge(29);
	session.save(tom);
	tx.commit();
	session.close();
}
package com.henu.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.henu.domain.Person;
public class TestHibernate
{
	Congfiguration cfg=new Congfiguration();
	SessionFactory sf=cfg.congigure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
	Person tom=new Person();
	tom.setName("Tom");
	session.save(tom);
	tx.commit();
	session.close();

}