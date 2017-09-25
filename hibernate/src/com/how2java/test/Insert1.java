package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

/*创建一个Product对象，并通过hibernate把这个对象，插入到数据库中

hibernate的基本步骤是：
1. 获取SessionFactory 
2. 通过SessionFactory 获取一个Session
3. 在Session基础上开启一个事务
4. 通过调用Session的save方法把对象保存到数据库
5. 提交事务
6. 关闭Session
7. 关闭SessionFactory
*/

public class Insert1 {
	public static void main(String[] args){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		//把一个Product对象保存到数据库
		Product p=new Product();
		p.setName("iphone9");
		p.setPrice(7000);
		s.save(p);
		
		//把一个Category对象保存到数据库
		Category c=new Category();
		c.setName("手机");
		s.save(c);
				
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
