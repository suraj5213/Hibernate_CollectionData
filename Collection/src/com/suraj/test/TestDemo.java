package com.suraj.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suraj.bean.Address;
import com.suraj.bean.Person;

public class TestDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		Address address = new Address("pune","411001");
		
		HashSet<String> hobbies = new HashSet<String>(); 
		hobbies.add("reading");
		hobbies.add("running");
		
		Person person = new Person(5,"tejas","kumbhar",address,hobbies);
		
		session.save(person);
		
		session.getTransaction().commit();

		session.close();
	}

}
