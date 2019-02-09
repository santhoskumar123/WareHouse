package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;

	@Transactional
	public Integer saveUom(Uom u) {
		
		return (Integer) ht.save(u);
	}

	@Transactional
	public void updateUom(Uom u) {
		ht.update(u);

	}

	@Transactional
	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));

	}

	@Transactional(readOnly=true)
	public Uom getUomById(Integer id) {
		
		return ht.get(Uom.class,id);
	}

	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {
		
		return ht.loadAll(Uom.class);
	}

	@Override
	public List<Object[]> getUomTypeCount() {
		String hql=" select uomType,count(uomType) from com.app.model.Uom group by uomType ";
		return (List<Object[]>) ht.find(hql);
	}

}
