# Spring Boot Category and Product Management API

This project is a Spring Boot REST API for managing **Categories** and **Products**, where each **Category** can have multiple **Products** (One-to-Many relationship). It also integrates with **Cloudinary** for image uploading and supports CRUD operations on both **Categories** and **Products**.

## Features

- Create, read, update, and delete **Categories**.
- Create, read, update, and delete **Products** under each **Category**.
- Upload images to **Cloudinary** for both **Categories** and **Products**.
- Return responses using `ResponseEntity` for better HTTP status handling and testing.

## Technology Used

- **Java**: 21
- **Spring Boot**: 3.x
  - Spring Web
  - Spring Data JPA
- **Cloudinary**: Image uploading service
- **MySQL**: Database 
- **Maven**: Project management and build tool

## Project Structure

- **Entities**:
  - `Category`: Represents product categories, with fields for `categoryname` and `category_image`.
  - `Product`: Represents products with fields for `productName`, `product_price` and `product_image`. Each product belongs to a `Category`.

- **One-to-Many Relationship**:
  - A **Category** can have multiple **Products**.
  - Each **Product** is assigned to a specific **Category**.

## API Endpoints

### Category Endpoints

1. **Create a Category**: 
   - **POST** `/Nimap/categories/addCategory`
   - Form Data: `categoryname`, `image` (Optional if you want)
   
2. **Get All Categories**: 
   - **GET** `/Nimap/categories`
   
3. **Get Category by ID**: 
   - **GET** `/Nimap/categories/{categoryid}`
   
4. **Update a Category**: 
   - **PUT** `/Nimap/categories/updateCategory/{categoryid}`
   - Form Data: `categoryName`, `image` 
   
5. **Delete a Category**: 
   - **DELETE** `/Nimap/categories/deleteCategory/{categoryid}`

### Product Endpoints

1. **Create a Product**: 
   - **POST** `/Nimap/products/addProducts`
   - Form Data: `productname`, `product_price`, `categoryid`, `image` (Optional if you want)

2. **Get All Products**: 
   - **GET** `/Nimap/products`

3. **Get Product by ID**: 
   - **GET** `/Nimap/products/{productid}`

4. **Update a Product**: 
   - **PUT** `/Nimap/products/updateProduct/{productid}`
   - Form Data: `productname`, `product_price`, `categoryid`, `image` 

5. **Delete a Product**: 
   - **DELETE** `/Nimap/products/deleteProduct/{productid}`

## How to Run the Project

### Prerequisites

Make sure you have the following installed:

- **Java 21**
- **Maven**
- **MySQL**
- **Cloudinary account** (for image uploading)

### Steps to Run

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
   cd your-repo-name

