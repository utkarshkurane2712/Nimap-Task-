package com.Nimap.Services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.Nimap.Entites.Product;
import com.Nimap.Repos.ProductRepo;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepo productRepo;

	@Autowired
	Cloudinary cloudnary;
	
	
	// To Handle Uploaded Image
	@SuppressWarnings("rawtypes")
	private String saveImage(MultipartFile image) throws IOException{
		if(image != null && !image.isEmpty()) {
			 Map uploadResult = cloudnary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
	            return uploadResult.get("url").toString();
		}
		
		return null;
	}
	
	
	// Add Product Logic
	public Product addProduct(String Productname, int categoryid, double product_price, MultipartFile image) throws IOException{
		Product product = new Product();
		product.setCreatedon(LocalDate.now());
		product.setProductname(Productname);
		product.setCategoryid(categoryid);
		product.setProduct_price(product_price);
		 
		String product_image = saveImage(image);
		product.setProduct_image(product_image);
		return productRepo.save(product);
	}
	
	// If Product Already Present Logic
	public boolean isProductAllreadyExists(String productname) {
		return productRepo.findByProductname(productname).isPresent();
	}
	
	
	// Update Product Logic 
	public Product updateProduct(int productid, String productname, int categoryid, double product_price, MultipartFile image ) throws IOException {
		Product product = productRepo.findById(productid).orElseThrow(() -> new RuntimeException("Product Not Found"));
		product.setCreatedon(LocalDate.now());
		product.setProductname(productname);
		product.setCategoryid(categoryid);
		product.setProduct_price(product_price);
		
		if(image != null && !image.isEmpty()) {
			
			String product_image = saveImage(image);
			product.setProduct_image(product_image);	
		}
		
		return productRepo.save(product);
	}
	
	
	// Delete Product Logic 
	public void deleteProduct(int productid) {
		Product product = productRepo.findById(productid).orElseThrow(() -> new RuntimeException(" Product Not Found"));
		if(product.getProduct_image() != null) {
			
			String publicId = product.getProduct_image().substring(product.getProduct_image().lastIndexOf("/") + 1, product.getProduct_image().lastIndexOf("."));
			
			try {
				cloudnary.uploader().destroy(publicId, ObjectUtils.emptyMap());
			}
			catch(IOException e) {
				
				throw new RuntimeException("Failed to delete image",e);
			}
		}
		
		productRepo.deleteById(productid);
	}
	
	//Get All Products
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	//Find Category By Id Logic
	public Optional<Product> getProductById(int productid) {
		return productRepo.findById(productid);
	}

}
