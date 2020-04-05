package com.zhaoya.pojo;

import java.io.Serializable;

public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String firstChar;
	private Integer deletedFlag;
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(Integer id, String name, String firstChar, Integer deletedFlag) {
		super();
		this.id = id;
		this.name = name;
		this.firstChar = firstChar;
		this.deletedFlag = deletedFlag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstChar() {
		return firstChar;
	}
	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}
	public Integer getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", firstChar=" + firstChar + ", deletedFlag=" + deletedFlag + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deletedFlag == null) ? 0 : deletedFlag.hashCode());
		result = prime * result + ((firstChar == null) ? 0 : firstChar.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Brand other = (Brand) obj;
		if (deletedFlag == null) {
			if (other.deletedFlag != null)
				return false;
		} else if (!deletedFlag.equals(other.deletedFlag))
			return false;
		if (firstChar == null) {
			if (other.firstChar != null)
				return false;
		} else if (!firstChar.equals(other.firstChar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
