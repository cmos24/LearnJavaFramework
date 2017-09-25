package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/*通过ID获取一个对象
调用Session的get方法，根据id获取对象。 除了id之外，还需要传递一个类对象，毕竟需要知道获取的是哪个对象

除了使用get方法，还可以使用load获取对象。 请参考get和load的区别*/
public class GetObjectById {
	public static void main(String[] args){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		Product p=(Product)s.get(Product.class, 6);//获取id为6的Product
		System.out.println("id=6的产品名称名称是："+p.getName());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}
