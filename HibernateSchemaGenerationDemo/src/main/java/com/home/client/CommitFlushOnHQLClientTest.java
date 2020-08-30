package com.home.client;

import java.util.Date;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import com.home.entities.Call;
import com.home.entities.Employee;
import com.home.entities.Partner;
import com.home.entities.Phone;
import com.home.entities.PhoneType;
import com.home.util.HibernateUtil;

public class CommitFlushOnHQLClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			/*Employee employee = session.get(Employee.class, 1);
			employee.setEmployeeName("Paras Gupta");
			session.save(employee);*/
			session.createQuery("select e from Employee e").setFlushMode(FlushMode.COMMIT).getResultList();
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
