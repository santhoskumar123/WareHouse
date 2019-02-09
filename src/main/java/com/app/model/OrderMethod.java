package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="ordermthdtab")

public class OrderMethod {
	@Id
	@GeneratedValue
	@Column(name="oid")
	private Integer id;
	@Column(name="omode")
	private String orderMode;
	@Column(name="ocode")
	private String orderCode;
	@Column(name="etype")
	private String exeType;
	@ElementCollection(fetch=FetchType.EAGER)
	
	@CollectionTable(name="orderacctab",joinColumns=@JoinColumn(name="oid"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String> orderAccept;
	@Column(name="odsc")
	private String orderDsc;
	public OrderMethod() {
		super();
	}
	public OrderMethod(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getExeType() {
		return exeType;
	}
	public void setExeType(String exeType) {
		this.exeType = exeType;
	}
	public List<String> getOrderAccept() {
		return orderAccept;
	}
	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}
	public String getOrderDsc() {
		return orderDsc;
	}
	public void setOrderDsc(String orderDsc) {
		this.orderDsc = orderDsc;
	}
	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", exeType="
				+ exeType + ", orderAccept=" + orderAccept + ", orderDsc=" + orderDsc + "]";
	}
	
	
}
