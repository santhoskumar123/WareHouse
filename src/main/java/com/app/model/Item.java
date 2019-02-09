package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemtab")
public class Item {
	@Id
	@GeneratedValue
	@Column(name="itemId")
	private Integer itemId;
	@Column(name="icode")
	private String itemCode;
	@Column(name="ilen")
	private Double itemLen;
	@Column(name="iwidth")
	private Double itemWidth;
	@Column(name="iheight")
	private Double itemHeight;
	@Column(name="bcost")
	private Double baseCost;
	@Column(name="bcurr")
	private String baseCurrency;
	@Column(name="idsc")
	private String itemDsc;
	public Item() {
		super();
	}
	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}
	
		public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Double getItemLen() {
		return itemLen;
	}
	public void setItemLen(Double itemLen) {
		this.itemLen = itemLen;
	}
	public Double getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(Double itemWidth) {
		this.itemWidth = itemWidth;
	}
	public Double getItemHeight() {
		return itemHeight;
	}
	public void setItemHeight(Double itemHeight) {
		this.itemHeight = itemHeight;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getItemDsc() {
		return itemDsc;
	}
	public void setItemDsc(String itemDsc) {
		this.itemDsc = itemDsc;
	}
		@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemLen=" + itemLen + ", itemWidth=" + itemWidth
				+ ", itemHeight=" + itemHeight + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency
				+ ", itemDsc=" + itemDsc + "]";
	}
	
	
}
