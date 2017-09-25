package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/*ͨ��ID��ȡһ������
����Session��get����������id��ȡ���� ����id֮�⣬����Ҫ����һ������󣬱Ͼ���Ҫ֪����ȡ�����ĸ�����

����ʹ��get������������ʹ��load��ȡ���� ��ο�get��load������*/
public class GetObjectById {
	public static void main(String[] args){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		Product p=(Product)s.get(Product.class, 6);//��ȡidΪ6��Product
		System.out.println("id=6�Ĳ�Ʒ���������ǣ�"+p.getName());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}
