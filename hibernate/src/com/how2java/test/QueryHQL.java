package com.how2java.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

// HIBERNATE 使用HQL进行查询
public class QueryHQL {
/*	HQL（Hibernate Query Language）是hibernate专门用于查询数据的语句，有别于SQL，HQL跟接近于面向对象的思维方式。 

	比如使用的是类的名字Product,而非表格的名字product_*/
	public static void main(String[] args) {
		/*使用HQL,根据name进行模糊查询  提问
		1. 首先根据hql创建一个Query对象
		2. 设置参数(和基1的PreparedStatement不一样，Query是基0的)
		3. 通过Query对象的list()方法即返回查询的结果了。

		注： 使用hql的时候，用的是类名Product,而不是表名product_
		注： 使用hql的时候，不需要在前面加 select *		*/
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		String name="iphone";
		Query q=s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%"+name+"%");//基0
		List<Product> ps=q.list();
		for(Product p:ps){
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

}
