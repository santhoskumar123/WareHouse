package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IitemDao;
import com.app.model.Item;
import com.app.model.OrderMethod;
@Repository
public class ItemImpl implements IitemDao {
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveItem(Item i) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(i);
	}

	@Override
	public void updateItem(Item i) {
		ht.update(i);
	}

	@Override
	public void deleteItem(Integer id) {
		ht.delete(new Item(id));
	}

	@Override
	public Item getItemById(Integer id) {
		return ht.get(Item.class, id);
	}

	@Override
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

	

}
