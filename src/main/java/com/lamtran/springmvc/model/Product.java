package com.lamtran.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int proID;

	private int catID;

	private int price;

	private String proName;

	private int quantity;

	private String tinyDes;

	public Product() {
	}

	public int getProID() {
		return this.proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public int getCatID() {
		return this.catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTinyDes() {
		return this.tinyDes;
	}

	public void setTinyDes(String tinyDes) {
		this.tinyDes = tinyDes;
	}

}