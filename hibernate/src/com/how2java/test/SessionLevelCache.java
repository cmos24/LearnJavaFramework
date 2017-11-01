package com.how2java.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Category;

//测试hibernate的一级缓存
public class SessionLevelCache {
	public static void main(String args[]){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		System.out.println("log1");
		Category c1=(Category)s.get(Category.class,1);
		System.out.println(c1.getName());
		
		c1.setName("手机1");
		s.update(c1);
		
		
		
		System.out.println("log2");
		Category c2=(Category)s.get(Category.class,1);
		System.out.println(c2.getName());
		
		System.out.println("log3");
		Category c3=(Category)s.get(Category.class,1);
		System.out.println(c3.getName());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
