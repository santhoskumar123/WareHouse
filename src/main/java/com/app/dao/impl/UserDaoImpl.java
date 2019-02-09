package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate ht;

	public Integer saveUser(User u) {
		
		return (Integer) ht.save(u);
	}
	public void updateUser(User u) {
		ht.update(u);

	}
	public void deleteUser(Integer id) {
		ht.delete(new User(id));

	}
	public User getUserById(Integer id) {
		
		return ht.get(User.class, id);
	}
	public List<User> getAllUsers() {
		return ht.loadAll(User.class);
	}

}
