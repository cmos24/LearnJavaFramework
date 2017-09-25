package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

//通过for循环插入10个Product对象到数据库
public class Insert2 {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
//		使用Session的save方法插入数据。 这里插入多条数据，是为了后面学习删除，分页等功能做铺垫
		for(int i=0;i<10;i++){
			Product p=new Product();
			p.setName("iphone"+i);
			p.setPrice(i*100);
			s.save(p);			
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
