# 🛒 E-Commerce Product API

This is a simple **E-commerce REST API App** built using **Spring Boot**, providing CRUD, fetching image and searching product operations for managing products along with image upload/download functionality.

---

## Features

- ✅ Add a new product with image upload (`POST`)
- ✅ Get all products (`GET`)
- ✅ Get product by ID (`GET`)
- ✅ Get product image by ID (`GET`)
- ✅ Search products by keyword (`GET`)
- ✅ Update product and image (`PUT`)
- ✅ Delete product by ID (`DELETE`)

## Technologies Used

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **MySQL** (as the database)
- **Postman** (for API testing)
- **IntelliJ IDEA** (as the development IDE)

## Getting Started

### 1. Clone the repository
**bash**
<pre>git clone https://github.com/your-username/ecommerce-app.git
cd ecommerce-app</pre>

### 2. Configure the MySQL Database
Make sure MySQL is running and update your application.properties file:

**properties**
<pre>spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update </pre>
✅ Tables will be created automatically on startup.

### 3. Run the Application
In IntelliJ IDEA:

**Open the project**

Run EcommerceAppApplication.java (your Spring Boot main class)

Or via terminal:
**bash**
./mvnw spring-boot:run

### API Endpoints
Use POSTMAN as a client to test end-points
Method	Endpoint	Description

- GET	/api/products	Get all products

- GET	/api/product/{id}	Get product by ID

- POST	/api/product	Add new product + image upload

- GET	/api/product/{id}/image	Get image by product ID

- PUT	/api/product/{id}	Update product + image

- DELETE	/api/product/{id}	Delete product by ID

- GET	/api/products/search?keyword=value	Search product by name, brand, description

**Note**: Use multipart/form-data in Postman for POST and PUT.

### Sample Postman Request (Add Product)
- Method: POST
**URL: http://localhost:8081/api/product**
**Body: form-data**

- product: JSON string of the product

- imageFile: Select image file from your system

**Example**:
**json**
**{
"name": "iPhone 14",

"description": "Apple smartphone",

"brand": "Apple",

"price": 79999.00,

"category": "Mobile",

"releaseDate": "2024-01-09",

"available": true,

"quantity": 20
}**
