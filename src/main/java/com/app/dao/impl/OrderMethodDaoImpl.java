package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht=new HibernateTemplate();

	
	public Integer saveOrderMethod(OrderMethod om) {
		return (Integer) ht.save(om);
	}

	
	public void updateOrderMethod(OrderMethod om) {
		ht.update(om);

	}

	
	public void deleteOrdermethod(Integer id) {
		ht.delete(new OrderMethod(id));

	}

	
	public OrderMethod getOrderMethodById(Integer id) {
		return ht.get(OrderMethod.class,id);
	}

	
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}


	@Override
	public List<Object[]> getOrderModeTypeCount() {
		String hql= " select orderMode,count(orderMode) " + " from " + OrderMethod.class.getName()  + " group by orderMode ";
		return (List<Object[]>) ht.find(hql);
	}

}
