package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pertab")
public class PurchaseOrder {
	@Id
	@GeneratedValue
	@Column(name="oid")
	private Integer orderId;
	@Column(name="ocode")
	private String orderCode;
	@Column(name="shipMode")
	private String shipmentMode;
	@Column(name="vendor")
	private String vendor;
	@Column(name="rNo")
	private String refNum;
	@Column(name="qCheck")
	private String qualityCheck;
	@Column(name="oStatus")
	private String orderStatus;
	@Column(name="oorder")
	private String orderDsc;
	public PurchaseOrder() {
		super();
	}
	public PurchaseOrder(Integer orderId) {
		super();
		this.orderId = orderId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDsc() {
		return orderDsc;
	}
	public void setOrderDsc(String orderDsc) {
		this.orderDsc = orderDsc;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [orderId=" + orderId + ", orderCode=" + orderCode + ", shipmentMode=" + shipmentMode
				+ ", vendor=" + vendor + ", refNum=" + refNum + ", qualityCheck=" + qualityCheck + ", orderStatus="
				+ orderStatus + ", orderDsc=" + orderDsc + "]";
	}
	
	
	
}
