package com.recell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recell.exception.ProductException;
import com.recell.model.Product;
import com.recell.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> findProductByCategoryHandler(@RequestParam String category,@RequestParam List<String> color,@RequestParam List<String> sizes, Integer minPrice,Integer maxPrice,Integer minDiscount,String stock, String sort,  Integer pageNumber, Integer pageSize){
		Page<Product> res= productService.getAllProduct(category, color, sizes, minPrice, maxPrice, minDiscount, sort,stock,pageNumber,pageSize);
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
//		return null;
		
	}
	
	@GetMapping("/products/id/{productId}")
	public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId) throws ProductException{
		
		Product product=productService.findProductById(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}


}
