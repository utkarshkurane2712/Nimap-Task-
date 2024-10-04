package com.Nimap.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.Nimap.Entites.Product;
import com.Nimap.Services.ProductServices;

@RestController
@RequestMapping("/Nimap/products")
public class ProductController {
	
	@Autowired
	ProductServices productService;
	
	// Get All Products Present In Software
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	// To Get Product info in Specific Id
	@GetMapping("/{productid}")
	 public Optional<Product> findEmployeeById(@PathVariable int productid) {
		 return productService.getProductById(productid);
	 }
	
	// Add New Product 
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestParam("productname") String productname, @RequestParam("categoryid") int categoryid,@RequestParam("product_price") double product_price,@RequestParam("image") MultipartFile image){
		if(productService.isProductAllreadyExists(productname)) {
			
			System.err.println("===== PRODUCT ALLREADY EXISTS =====");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Product Already Exists");
		}
		else {
			try {
				productService.addProduct(productname, categoryid, product_price, image);
				System.err.println(" ===== PRODUCT ADDED SUCCESSFULLY ====");
				return ResponseEntity.status(HttpStatus.CREATED).body("Product Added Successfully");
			}
			catch( IOException e) {
				
				System.err.println("===== FAILED TO UPLOAD IMAGE =====");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
			}
		}
	}
	
	
	//To Update A Existing Product 
	@PutMapping("/updateProduct/{productid}")
	public ResponseEntity<String> updateProduct(@PathVariable int productid, @RequestParam("productname") String productname, @RequestParam("categoryid") int categoryid, @RequestParam("product_price") double product_price, @RequestParam("image") MultipartFile image ){
		
		try {
			
			productService.updateProduct(productid, productname, categoryid, product_price, image);
			System.err.println("===== PRODUCT UPDATED SUCCESSFULLY =====");
			return ResponseEntity.ok("Product Updated Successfully");
		}
		catch(IOException e) {
			
			System.err.println("===== Failed to upload image =====");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
			
		}
	}
	
	
	// To Delete the Product
	@DeleteMapping("/deleteProduct/{productid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productid) {
		productService.deleteProduct(productid);
		System.err.println("===== PRODUCT DELETED SUCCESSFULLY =====");
		return ResponseEntity.ok("Product Deleted Successfully");
	}


}
