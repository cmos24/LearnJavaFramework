package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

//HIBERNATE ʵ�ֶ��һ
public class ManyToOne {
	/*��������������У�������һ���µ�Category����"c1" 
	����������Ϊid=8��product��category*/
	public static void main(String[] args){
		SessionFactory sf =new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		Category c=new Category();
		c.setName("c2");
		s.save(c);
		
		Product p=(Product)s.get(Product.class, 5);//ͨ��id��ȡ����
		p.setCategory(c);
		s.update(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
