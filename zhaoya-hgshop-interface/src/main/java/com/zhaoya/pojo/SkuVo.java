package com.zhaoya.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SkuVo extends Sku{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	
	private BigDecimal maxPrice;
	
	private BigDecimal minPrice;
	
	private int maxStockCount;
	
	private int minStockCount;
	
	//卖点或者标题当中含有的关键词 
	private String key;

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxStockCount() {
		return maxStockCount;
	}

	public void setMaxStockCount(int maxStockCount) {
		this.maxStockCount = maxStockCount;
	}

	public int getMinStockCount() {
		return minStockCount;
	}

	public void setMinStockCount(int minStockCount) {
		this.minStockCount = minStockCount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SkuVo(BigDecimal maxPrice, BigDecimal minPrice, int maxStockCount, int minStockCount, String key) {
		super();
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
		this.maxStockCount = maxStockCount;
		this.minStockCount = minStockCount;
		this.key = key;
	}

	public SkuVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkuVo(Integer id, String title, String sellPoint, BigDecimal price, Integer stockCount, String barcode,
			String image, String status, Date createTime, Date updateTime, BigDecimal costPrice, Integer marketPrice,
			Integer spuId, String cartThumbnail, Spu spu, List<SpecOption> specs) {
		super(id, title, sellPoint, price, stockCount, barcode, image, status, createTime, updateTime, costPrice, marketPrice,
				spuId, cartThumbnail, spu, specs);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
