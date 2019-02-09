package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht=new HibernateTemplate();
	public Integer saveDocument(Document doc) {
		
		return (Integer) ht.save(doc);
	}
	public List<Object[]> getDocsIdAndNames() {
		//SQL:select fid,fname from doctab
		String hql="select fileId,fileName from com.app.model.Document";
		List<Object[]> data=(List<Object[]>) ht.find(hql);
		return data;
	}
	@Override
	public Document getDocumentById(int docId) {
		return ht.get(Document.class,docId);
	}
	

}
