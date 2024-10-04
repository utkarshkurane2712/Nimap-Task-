# Spring Boot Category and Product Management API

This project is a Spring Boot REST API for managing **Categories** and **Products**, where each **Category** can have multiple **Products** (One-to-Many relationship). It also integrates with **Cloudinary** for image uploading and supports CRUD operations on both **Categories** and **Products**.

## Features

- Create, read, update, and delete **Categories**.
- Create, read, update, and delete **Products** under each **Category**.
- Upload images to **Cloudinary** for both **Categories** and **Products**.
- Return responses using `ResponseEntity` for better HTTP status handling and testing.

## Technology Stack

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
  - `Product`: Represents products with fields for `productName`, `price`, `status`, and `imageUrl`. Each product belongs to a `Category`.

- **One-to-Many Relationship**:
  - A **Category** can have multiple **Products**.
  - Each **Product** is assigned to a specific **Category**.

## API Endpoints

### Category Endpoints

1. **Create a Category**: 
   - **POST** `/api/categories`
   - Form Data: `categoryName`, `image` (optional)
   
2. **Get All Categories**: 
   - **GET** `/api/categories`
   
3. **Get Category by ID**: 
   - **GET** `/api/categories/{id}`
   
4. **Update a Category**: 
   - **PUT** `/api/categories/{id}`
   - Form Data: `categoryName`, `image` (optional)
   
5. **Delete a Category**: 
   - **DELETE** `/api/categories/{id}`

### Product Endpoints

1. **Create a Product**: 
   - **POST** `/api/products`
   - Form Data: `productName`, `price`, `status`, `categoryId`, `image` (optional)

2. **Get All Products**: 
   - **GET** `/api/products`

3. **Get Product by ID**: 
   - **GET** `/api/products/{id}`

4. **Update a Product**: 
   - **PUT** `/api/products/{id}`
   - Form Data: `productName`, `price`, `status`, `categoryId`, `image` (optional)

5. **Delete a Product**: 
   - **DELETE** `/api/products/{id}`

## How to Run the Project

### Prerequisites

Make sure you have the following installed:

- **Java 17**
- **Maven**
- **MySQL** (or you can switch to H2 in the properties file for local testing)
- **Cloudinary account** (for image uploading)

### Steps to Run

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
   cd your-repo-name

