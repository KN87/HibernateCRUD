package com.hibernate.caller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fetch.FetchStuDetail;


public class Application {

	public static void main(String[] args) {
		FetchStuDetail stu1 = new FetchStuDetail();
		stu1.setFname("Sunko");
		stu1.setLname("Mjau");
		stu1.setEmail("SMjo@foo.com");
		stu1.setAddress("14 NJha Road 8702");
		
		FetchStuDetail stu2 = new FetchStuDetail();
		stu2.setFname("Goya");
		stu2.setLname("Nag");
		stu2.setEmail("Gno@foo.com");
		stu2.setAddress("12 JNU Road 4234");
		
		// SessionFactory is created only once to create the connection between java class & db using the JDBC config in hibernate.cfg.xml file
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(FetchStuDetail.class).buildSessionFactory();
	    
		// Session created from session factory
		Session sess = factory.openSession();
		/*sess.beginTransaction();
		sess.save(stu1);
		sess.getTransaction().commit();
		sess.close();
		
		//Cannot use same session to store objects . Creating another session.
		sess = factory.openSession();
		sess.beginTransaction();
		sess.save(stu2);
		sess.getTransaction().commit();
		sess.close();*/
		
		//Retrieve data from database
		FetchStuDetail stu3 = new FetchStuDetail();
		FetchStuDetail stu4 = new FetchStuDetail();
		sess = factory.openSession();
		sess.beginTransaction();
		stu3 = (FetchStuDetail)sess.get(FetchStuDetail.class,4);
		System.out.println("The user is:" +stu3.getFname());
		
		//Update 
		stu3.setFname("Yana");
		stu3.setEmail("Yana@rtt.com");
		
		//Delete
		stu4 = (FetchStuDetail)sess.get(FetchStuDetail.class,5);
		sess.delete(stu4);
		
		// Commit & end transaction
		sess.getTransaction().commit();
		sess.close();
		
	}

}
