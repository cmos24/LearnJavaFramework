package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

// HIBERNATE 对象的三种状态 瞬时 持久 脱管
public class HibernateObjectStatus {
/*	实体类对象在Hibernate中有3种状态 
	分别是瞬时，持久和脱管

	瞬时 指的是没有和hibernate发生任何关系，在数据库中也没有对应的记录，一旦JVM结束，这个对象也就消失了 
	持久 指得是一个对象和hibernate发生联系，有对应的session,并且在数据库中有对应的一条记录 
	脱管 指的是一个对象虽然在数据库中有对应的一条记录，但是它所对应的session已经关闭了 */
	
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		Product p=new Product();
		p.setName("p1");
		System.out.println("此时p是瞬时状态");
		s.save(p);
		System.out.println("此时p是持久状态");
		s.getTransaction().commit();
		s.close();
		System.out.println("此时p是脱管状态");
		sf.close();
		
	}		
}
