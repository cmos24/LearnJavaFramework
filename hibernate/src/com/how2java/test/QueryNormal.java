package com.how2java.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//HIBERNATE ʹ�ñ�׼SQL�����в�ѯ
public class QueryNormal {
	/*ͨ����׼SQL�����в�ѯ 
	Hibernate��Ȼ�����˶Ա�׼SQL����֧�֣���һЩ���ϣ����������ϲ�ѯ��
	�����з���ͳ�ƺ���������£���׼SQL�����Ȼ��Ч�ʽϸߵ�һ��ѡ��*/
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();//��ʼ����
		
		String name="iphone";
		
		String sql="select * from product_ p where p.name like '%"+name+"%'";
		
		Query q=s.createSQLQuery(sql);
		List<Object[]> list=q.list();
		for(Object[] os:list){
			for(Object filed:os){
				System.out.println(filed+"\t");
			}
			System.out.println();
		}
		
		s.getTransaction();
		s.close();
		sf.close();
		
	}
}
