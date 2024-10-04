package com.Nimap.Entites;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productid;
	
	@Column(name="category_id")
	private int categoryid;
	
	@Column(name="product_name")
	private String productname;
	
	@Column(name="product_price")
	private double product_price;
	
	@Column(name="product_image")
	private String product_image; 
	
	@Column(name="created_on")
	private LocalDate createdon;
	
	@ManyToOne
	@JoinColumn(name="category_id",insertable = false,updatable = false)
	private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productid, int categoryid, String productname, double product_price, String product_image,
			LocalDate createdon, Category category) {
		super();
		this.productid = productid;
		this.categoryid = categoryid;
		this.productname = productname;
		this.product_price = product_price;
		this.product_image = product_image;
		this.createdon = createdon;
		this.category = category;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public LocalDate getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDate createdon) {
		this.createdon = createdon;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", categoryid=" + categoryid + ", productname=" + productname
				+ ", product_price=" + product_price + ", product_image=" + product_image + ", createdon=" + createdon
				+ ", category=" + category + "]";
	}
	
	

}
