package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.WhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements WhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	public Integer saveWhUserType(WhUserType wut) {
		return (Integer) ht.save(wut);
	}

	public void updateWhUserType(WhUserType wut) {
		ht.update(wut);

	}

	public void deleteWhUserType(Integer id) {
		ht.delete(new WhUserType(id));

	}

	public WhUserType getWhUserTypeById(Integer id) {
		return ht.get(WhUserType.class, id);
	}

	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	
	public List<Object[]> getWhUserTypeCount() {
		String hql=" select userType,count(userType) " + " from " + WhUserType.class.getName() + " group by userType ";
		return (List<Object[]>) ht.find(hql);
	}

}
