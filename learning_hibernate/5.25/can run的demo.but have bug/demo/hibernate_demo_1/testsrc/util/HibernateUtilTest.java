package util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void testGetSession() {
		Session stion=HibernateUtil.getSession();
		System.out.println(stion);
	}

}
