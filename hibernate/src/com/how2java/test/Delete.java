package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

//HIBERNATE ɾ��һ������
/*����id�Ѷ���ӱ���ɾ���� 
ע��:hibernate��ɾ��һ������֮ǰ����Ҫͨ��id��������¼ȡ����*/
public class Delete {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		Product p=(Product)s.get(Product.class, 14);
		s.delete(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
}
