package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

//HIBERNATE 修改(更新)一个对象
public class Update {
	public static void main(String[] args){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		Product p=(Product)s.get(Product.class,13);
		
		System.out.println("修改前name:"+p.getName());
		
		p.setName("iphone-modified");		
		s.update(p);
		
		p=(Product)s.get(Product.class, p.getId());
		System.out.println("修改后的name:"+p.getName());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
