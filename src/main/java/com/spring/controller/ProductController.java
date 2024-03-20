package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.ProductRequest;
import com.spring.entity.Product;
import com.spring.service.ProductService;
import com.spring.utility.ErrorStructure;
import com.spring.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ProductController {

	
	private ProductService service;
	
	
	public ProductController(ProductService service) {
		this.service = service;
	}

	
	@Operation(description = "The end point is used to save the Product ",responses = {
			@ApiResponse(responseCode = "200",description = "Product Inserted successfully"),
			@ApiResponse(responseCode = "404",description = "Product Insertion faild",content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody ProductRequest productRequest ) {
		
		return service.saveProduct(productRequest);	
	}
	
	
	@Operation(description = "The End point is used to update the product by Id",responses = {
			@ApiResponse(responseCode = "200",description = "Product is Updated successfully"),
			@ApiResponse(responseCode = "404",description = "product is faild to update",content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@PutMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateProductById(@PathVariable int productId,@RequestBody ProductRequest productRequest) {
		return service.updateProductById(productRequest, productId);
	}
	
	@Operation(description = "The end point is used to delete the product based on the Id" ,responses= {
			@ApiResponse(responseCode = "200",description = "Product Is deleted"),
			@ApiResponse(responseCode = "404",description = "failed to delete the Product",content = {
					@Content(schema=@Schema(implementation = ErrorStructure.class))
			})
			
			})
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(@PathVariable int productId) {
		return service.deleteProductById(productId);
	}
	
	
	@Operation(description = "The end point is used for fetch the product based on the ID",responses= {
			@ApiResponse(responseCode = "200", description = "Product Found"),
			@ApiResponse(responseCode = "404",description = "Product Not Found",content = {
					@Content(schema=@Schema(implementation = ErrorStructure.class))
			})
			})
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findProductById(@PathVariable int productId) {
		return service.findProductById(productId);
	} 
	
	@Operation(description = "The end point is used to fetch all the products",responses = {
			@ApiResponse(responseCode = "200",description = "products Found"),
			@ApiResponse(responseCode = "404",description = "Unable to fetch the product",content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		return service.findAllProduct();
	}

}
