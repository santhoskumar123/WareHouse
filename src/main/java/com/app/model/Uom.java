package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="uomtab")
@Component
public class Uom {
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer id;
	public Uom(Integer id) {
		super();
		this.id = id;
	}
	@Column(name="utype")
	private String uomType;
	@Column(name="umodel")
	private String uomModel;
	@Column(name="udes")
	private String uomDes;
	public Uom() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getUomDes() {
		return uomDes;
	}
	public void setUomDes(String uomDes) {
		this.uomDes = uomDes;
	}
	@Override
	public String toString() {
		return "Uom [id=" + id + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDes=" + uomDes + "]";
	}
	
}
