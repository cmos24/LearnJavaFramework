package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

//ͨ��forѭ������10��Product�������ݿ�
public class Insert2 {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
//		ʹ��Session��save�����������ݡ� �������������ݣ���Ϊ�˺���ѧϰɾ������ҳ�ȹ������̵�
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
