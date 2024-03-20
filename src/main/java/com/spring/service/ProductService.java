package com.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.dto.ProductRequest;
import com.spring.entity.Product;
import com.spring.utility.ResponseStructure;


public interface ProductService {
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest);
	public ResponseEntity<ResponseStructure<Product>> updateProductById(ProductRequest productRequest,int productId);
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int productId);
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId);
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct();
	

}
