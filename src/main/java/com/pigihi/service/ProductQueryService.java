/**
 * 
 */
package com.pigihi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pigihi.entity.ProductCategoryEntity;
import com.pigihi.entity.ProductEntity;
import com.pigihi.model.ProductModel;
import com.pigihi.model.ShopModel;
import com.pigihi.model.ShopStockModel;
import com.pigihi.repository.CategoryRepository;
import com.pigihi.repository.ProductRepository;
import com.pigihi.service.interfaces.QueryServiceInterface;

/**
 * Implementation class for Query Service interface <br>
 * 
 * 
 * @author Ashish Sam T George
 *
 */
@Service
public class ProductQueryService implements QueryServiceInterface {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductEntity> listAllProducts() {
		List<ProductEntity> products = productRepository.findAll();
		return products;
	}

	@Override
	public List<ProductEntity> listSimilarProducts(String prodName) {
		List<ProductEntity> products = productRepository.findSimilarProducts(prodName);
		return products;
	}

	@Override
	public List<ProductEntity> findProductsByPincode(String pincode) {
		List<ProductEntity> products = productRepository.findAllByPincode(pincode);
		return products;
	}

	@Override
	public ProductEntity findProductById(String prodId) {
		Optional<ProductEntity> product = productRepository.findById(prodId);
		return product.get();
	}

	@Override
	public List<ProductEntity> findProductsByCategory(String category) {
		List<ProductEntity> products = productRepository.findAllByCategory(category);
		return products;
	}
	
	@Override
	public ProductEntity findProductByName(String prodName) {
		Optional<ProductEntity> product = productRepository.findByName(prodName);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}


}
