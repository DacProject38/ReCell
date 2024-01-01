package com.recell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recell.exception.ProductException;
import com.recell.model.Product;
import com.recell.request.CreateProductRequest;
import com.recell.response.ApiResponse;
import com.recell.service.ProductService;

@RestController	//indicates class handles HTTP requests and produce HTTP response
@RequestMapping("/api/admin/products")	//base URL path that controller will handle
public class AdminProductController {

	@Autowired	//automatically inject an instance of 'ProductService' into this controller
	private ProductService productService;	//'ProductService' is a service class responsible for handling business logic related to products

	@PostMapping("/") //method will handle HTTP POST request
	public ResponseEntity<Product> createProductHandler(@RequestBody CreateProductRequest req) throws ProductException { //this method takes 'CreateProductRequest' object ('req') as request body
		//this method is designed to create new product
		//response body will be of type 'Product'
		
		Product createdProduct = productService.createProduct(req);
		//invokes the 'createProduct' method of the 'ProductService' class
		//passing the 'CreateProductRequest' object as an argument
		//performs business logic to create a new product based on the provided request data

		return new ResponseEntity<Product>(createdProduct, HttpStatus.ACCEPTED);
		//create a ResponseEntity with the created product and HTTP status code
		//response that will be sent back to the client
		
	}

	@DeleteMapping("/{productId}/delete")	//map HTTP DELETE requests to this method //'{productId}' is a placeholder for a variable value that will be extracted from the URL path
	public ResponseEntity<ApiResponse> deleteProductHandler(@PathVariable Long productId) throws ProductException {	//returns a 'ResponseEntity' containing an instance of the 'ApiResponse' class
		//annotation indicates that the value of the {productId} placeholder in the URL will be extracted and passed as an argument to this method
			
		String msg = productService.deleteProduct(productId);
		//this method is responsible for deleting a product and it returns a message indicating the result of the deletion
		
		ApiResponse res = new ApiResponse(msg, true);
		//instance of the ApiResponse class is created, response will be sent back to the client

		return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
		//creates a ResponseEntity wrapping the ApiResponse instance and an HTTP status code

	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct() {

		List<Product> products = productService.getAllProducts();

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@PutMapping("/{productId}/update")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product req, @PathVariable Long productId)
			throws ProductException {

		Product updatedProduct = productService.updateProduct(productId, req);

		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
	}

	@PostMapping("/creates")
	public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] reqs)
			throws ProductException {

		for (CreateProductRequest product : reqs) {
			productService.createProduct(product);
		}

		ApiResponse res = new ApiResponse("products created successfully", true);
		return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
	}

}
