package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

/*����һ��Product���󣬲�ͨ��hibernate��������󣬲��뵽���ݿ���

hibernate�Ļ��������ǣ�
1. ��ȡSessionFactory 
2. ͨ��SessionFactory ��ȡһ��Session
3. ��Session�����Ͽ���һ������
4. ͨ������Session��save�����Ѷ��󱣴浽���ݿ�
5. �ύ����
6. �ر�Session
7. �ر�SessionFactory
*/

public class Insert1 {
	public static void main(String[] args){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		s.beginTransaction();
		
		//��һ��Product���󱣴浽���ݿ�
		Product p=new Product();
		p.setName("iphone9");
		p.setPrice(7000);
		s.save(p);
		
		//��һ��Category���󱣴浽���ݿ�
		Category c=new Category();
		c.setName("�ֻ�");
		s.save(c);
				
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
