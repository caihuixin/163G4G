package com.qhit.lh.g4.chx.t4.dao.impl;

import java.util.List;














import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.g4.chx.t4.bean.Emp;
import com.qhit.lh.g4.chx.t4.bean.UserInfo;
import com.qhit.lh.g4.chx.t4.dao.BaseDao;
import com.qhit.lh.g4.chx.t4.service.BaseService;
import com.qhit.lh.g4.chx.t4.utils.HibernateSessionFactory;


public class BaseDaoImpl implements BaseDao, BaseService {

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		//4,操作对象-->完成数据的CRUD
		session.save(obj);
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
	}


	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		//4,操作对象-->完成数据的CRUD
		session.delete(obj);
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
	}


	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		//4,操作对象-->完成数据的CRUD
		session.update(obj);
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
	}


	@Override
	public List<Object> queryAll(String fromStr) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(fromStr);
		//4,查询
		List<Object> list = query.list();
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
		return list;

	}


	@Override
	public Object getObjectById(Class clazz, int id) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		//4,操作对象-->完成数据的CRUD
		Object obj = session.get(clazz,id);
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
		return obj;
	}
	public List<Emp> getEmpByName(String name){
		Session session=HibernateSessionFactory.getSession();
		String hql="select emp from Emp emp where emp.empname like ?";
		Query query=session.createQuery(hql);
		query.setString(0, name);
		return query.list();
	}


	@Override
	public List<UserInfo> login(UserInfo user) {
		Session session=HibernateSessionFactory.getSession();
		String hql="select user from UserInfo user where user.username=:name and user.password=:password";
		Query query=session.createQuery(hql);
		query.setString("name",user.getUserName());
		query.setString("pwd",user.getPassword());
		
		
		return query.list();
	}

}
