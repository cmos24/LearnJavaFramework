package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

// HIBERNATE ���������״̬ ˲ʱ �־� �ѹ�
public class HibernateObjectStatus {
/*	ʵ���������Hibernate����3��״̬ 
	�ֱ���˲ʱ���־ú��ѹ�

	˲ʱ ָ����û�к�hibernate�����κι�ϵ�������ݿ���Ҳû�ж�Ӧ�ļ�¼��һ��JVM�������������Ҳ����ʧ�� 
	�־� ָ����һ�������hibernate������ϵ���ж�Ӧ��session,���������ݿ����ж�Ӧ��һ����¼ 
	�ѹ� ָ����һ��������Ȼ�����ݿ����ж�Ӧ��һ����¼������������Ӧ��session�Ѿ��ر��� */
	
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		Product p=new Product();
		p.setName("p1");
		System.out.println("��ʱp��˲ʱ״̬");
		s.save(p);
		System.out.println("��ʱp�ǳ־�״̬");
		s.getTransaction().commit();
		s.close();
		System.out.println("��ʱp���ѹ�״̬");
		sf.close();
		
	}		
}
