package com.zhaoya.pojo;

import java.io.Serializable;

public class Spu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  goodsName;
	private String isMarketable;
	private Integer brandId;
	private String caption;
	private Integer categoryId;
	private String smallPic;
	
	private Brand brand;
	private Category category;
	public Spu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Spu(Integer id, String goodsName, String isMarketable, Integer brandId, String caption, Integer categoryId,
			String smallPic, Brand brand, Category category) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.isMarketable = isMarketable;
		this.brandId = brandId;
		this.caption = caption;
		this.categoryId = categoryId;
		this.smallPic = smallPic;
		this.brand = brand;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getIsMarketable() {
		return isMarketable;
	}
	public void setIsMarketable(String isMarketable) {
		this.isMarketable = isMarketable;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Spu [id=" + id + ", goodsName=" + goodsName + ", isMarketable=" + isMarketable + ", brandId=" + brandId
				+ ", caption=" + caption + ", categoryId=" + categoryId + ", smallPic=" + smallPic + ", brand=" + brand
				+ ", category=" + category + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isMarketable == null) ? 0 : isMarketable.hashCode());
		result = prime * result + ((smallPic == null) ? 0 : smallPic.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spu other = (Spu) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isMarketable == null) {
			if (other.isMarketable != null)
				return false;
		} else if (!isMarketable.equals(other.isMarketable))
			return false;
		if (smallPic == null) {
			if (other.smallPic != null)
				return false;
		} else if (!smallPic.equals(other.smallPic))
			return false;
		return true;
	}
	
}
