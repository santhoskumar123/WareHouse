package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IitemDao;
import com.app.model.Item;
import com.app.service.IItemService;
@Service
public class IItemServiceImpl implements IItemService {
	@Autowired
	private IitemDao dao;
	@Transactional
	public Integer saveItem(Item i) {
		// TODO Auto-generated method stub
		return dao.saveItem(i);
	}

	@Transactional
	public void updateItem(Item i) {
		dao.updateItem(i);
	}

	@Transactional
	public void deleteItem(Integer id) {
		dao.deleteItem(id);
	}

	@Transactional(readOnly=true)
	public Item getItemById(Integer id) {
		return dao.getItemById(id);
	}

	@Transactional(readOnly=true)
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return dao.getAllItems();
	}

}
