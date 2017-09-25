package com.how2java.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//HIBERNATE 使用标准SQL语句进行查询
public class QueryNormal {
	/*通过标准SQL语句进行查询 
	Hibernate依然保留了对标准SQL语句的支持，在一些场合，比如多表联合查询，
	并且有分组统计函数的情况下，标准SQL语句依然是效率较高的一种选择*/
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();//开始事务
		
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
