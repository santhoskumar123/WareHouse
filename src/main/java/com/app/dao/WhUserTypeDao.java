package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface WhUserTypeDao {
	public Integer saveWhUserType(WhUserType wut);
	public void updateWhUserType(WhUserType wut);
	public void deleteWhUserType(Integer id);
	public WhUserType getWhUserTypeById(Integer id);
	public List<WhUserType> getAllWhUserTypes();
	public List<Object[]> getWhUserTypeCount();
}
