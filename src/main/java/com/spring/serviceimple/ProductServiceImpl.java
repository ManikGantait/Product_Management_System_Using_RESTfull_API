package com.spring.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.dto.ProductRequest;
import com.spring.entity.Product;
import com.spring.exception.ProductIdNotFoundException;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;
import com.spring.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository repository;
	
	private ResponseStructure<Product> structure;
	private ResponseStructure<List<Product>> listStructure;	
	

	public ProductServiceImpl(ProductRepository repository, ResponseStructure<Product> structure,
			ResponseStructure<List<Product>> listStructure) {
		super();
		this.repository = repository;
		this.structure = structure;
		this.listStructure = listStructure;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest) {

		Product product = repository.save(mapToProduct(productRequest, new Product()));
		
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
									.setMessage("Product saved Successfully").setData(product));

	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateProductById(ProductRequest productRequest, int productId) {

		return repository.findById(productId).map(p -> {
//			Product product = mapToProduct(productRequest, p);
			
			return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
												.setMessage("Product Found")
												.setData( repository.save(mapToProduct(productRequest, p)) )
									);

		}).orElseThrow(() -> new ProductIdNotFoundException("Product with the given id is not present"));
		
		/*
		 * Optional<Product> optional = repository.findById(productId); if
		 * (optional.isPresent()) { Product fetchProduct = optional.get();
		 * System.out.println(fetchProduct);
		 * 
		 * product.setProductId(fetchProduct.getProductId());
		 * 
		 * Product updatedProduct = repository.save(product);
		 * 
		 * ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		 * responseStructure.setStatusCode(HttpStatus.OK.value());
		 * responseStructure.setMessage("Product Object Updated");
		 * responseStructure.setData(updatedProduct); return new
		 * ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		 * } else throw new ProductIdNotFoundException("Product with the given id '"
		 * +productId+"' is not avalivle");
		 */
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int productId) {
		
		
		return repository.findById(productId).map(p -> {
			repository.delete(p);
			return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
								.setMessage("Product Object Is deleted").setData(p));
			
		}).orElseThrow(() -> new ProductIdNotFoundException("Product With the Given Id Is Not Present"));
		/*
		 * Optional<Product> optional = repository.findById(productId); if
		 * (optional.isPresent()) { repository.delete(optional.get());
		 * ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		 * responseStructure.setStatusCode(HttpStatus.OK.value());
		 * responseStructure.setMessage("Product Object deleted");
		 * responseStructure.setData(optional.get()); return new
		 * ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		 * } else throw new ProductIdNotFoundException("Product with the given id '"
		 * +productId+"' is not avalivle");
		 */
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId) {
		
	  return repository.findById(productId).map(p->{
		  
			return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
					.setMessage("Product Found").setData(p));
		}).orElseThrow(()->new ProductIdNotFoundException("Product Not Found"));
	

		/*
		 * Optional<Product> optional = repository.findById(productId); if
		 * (optional.isPresent()) { Product fetchProduct = optional.get();
		 * 
		 * ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		 * responseStructure.setStatusCode(HttpStatus.FOUND.value());
		 * responseStructure.setMessage("Product Found");
		 * responseStructure.setData(fetchProduct); return new
		 * ResponseEntity<ResponseStructure<Product>>(responseStructure,
		 * HttpStatus.FOUND); } else throw new
		 * ProductIdNotFoundException("Product with the given id '"
		 * +productId+"' is not avalivle");
		 */
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {

		return ResponseEntity.ok(listStructure.setStatusCode(HttpStatus.OK.value())
									.setMessage("product List")
									.setData(repository.findAll()));
			
		
		
		
		
		/*List<Product> list = repository.findAll();

		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Product Found");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.FOUND);*/

	}
	
	private Product mapToProduct(ProductRequest productRequest,Product product)
	{
		
		  product.setProductName(productRequest.getProductName());
		  product.setProductPrice(productRequest.getProductPrice());
		 
		
//		Product.builder.productName(productRequest.getProductName()).build();
		return product;
	}

}
