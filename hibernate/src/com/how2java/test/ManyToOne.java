package com.how2java.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

//HIBERNATE 实现多对一
public class ManyToOne {
	/*在这个测试例子中，增加了一个新的Category对象"c1" 
	并将其设置为id=8的product的category*/
	public static void main(String[] args){
		SessionFactory sf =new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		//新增一个category
		Category c=new Category();
		c.setName("c5");
		s.save(c);
		
		
		Product p=(Product)s.get(Product.class, 9);//通过id获取对象
		p.setCategory(c);
		s.update(p);
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
