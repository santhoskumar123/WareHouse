package com.app.dao;

import java.util.List;

import com.app.model.Uom;

public interface IUomDao {
	public Integer saveUom(Uom u);
	public void updateUom(Uom u);
	public void deleteUom(Integer id);
	public Uom getUomById(Integer id);
	public List <Uom> getAllUoms();
	public List<Object[]> getUomTypeCount();
	
}
