package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(st);
	}

	@Transactional
	public void updateShipmentType(ShipmentType st) {
		 ht.update(st);

	}

	@Transactional
	public void deleteShipmentType(Integer id) {
		
		ht.delete(new ShipmentType(id));

	}

	@Transactional(readOnly=true)
	public ShipmentType getShipmantTypeById(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(ShipmentType.class, id);
	}

	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {
		// TODO Auto-generated method stub
		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public List<Object[]> getShipmentTypeCount() {
		String hql=" select shipmentMode,count(shipmentMode) " + " from " + ShipmentType.class.getName() + " group by shipmentMode ";
		return (List<Object[]>) ht.find(hql);
	}

}
