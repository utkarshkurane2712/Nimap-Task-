package com.Nimap.Entites;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private int categoryid;
	
	@Column(unique = true, name="category_name")
	private String categoryname;
	
	@Column(name="category_image")
	private String category_image;
	
	@Column(name="created_on")
	private LocalDate createdon;
	
	@OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL ) 
	private List<Product> products;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryid, String categoryname, String category_image, LocalDate createdon,
			List<Product> products) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.category_image = category_image;
		this.createdon = createdon;
		this.products = products;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategory_image() {
		return category_image;
	}

	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}

	public LocalDate getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDate createdon) {
		this.createdon = createdon;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryname=" + categoryname + ", category_image="
				+ category_image + ", createdon=" + createdon + ", products=" + products + "]";
	}
	
	

}
