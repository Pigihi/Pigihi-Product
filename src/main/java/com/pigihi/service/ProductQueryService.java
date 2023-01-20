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

/**
 * @author Ashish Sam T George
 *
 */
@Service
public class ProductQueryService implements QueryServiceInterface {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

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
	public ProductEntity addProduct(ProductModel productModel) {
		ProductEntity product;
		
//		Authentication usernamePasswordAuthenticationToken = 
//				SecurityContextHolder.getContext().getAuthentication();
//		String email = usernamePasswordAuthenticationToken.getName();
		
		//TODO Get the email somehow
		String email = "";
		
		//TODO Make API call to shop microservice for getting details of the shop
//		ShopEntity shop = shopInfo(email);
		ShopModel shop = new ShopModel();
		
		ShopStockModel productShop = new ShopStockModel();
		
		//TODO I am confused about the logic here. Think and write a description
		productShop.setShopId(shop.getId());
		productShop.setStock(productModel.getStock());
		
		ProductEntity productCheck = findProductByName(productModel.getProdName());
		if(productCheck != null) {
			productCheck.getShops().add(productShop);
			productCheck.getPincode().add(shop.getPincode());
			product = productCheck;
		}
		else {
			product = new ProductEntity();
			List<ShopStockModel> listProductShop = new ArrayList<ShopStockModel>();
			listProductShop.add(productShop);
			
			List<String> listPincode = new ArrayList<String>();
			listPincode.add(shop.getPincode());
			
			product.setShops(listProductShop);
			product.setPincode(listPincode);
			product.setProdName(productModel.getProdName());
			product.setImageUrl(productModel.getImageUrl());
			product.setCategory(productModel.getCategory());
			product.setMainUnit(productModel.getMainUnit());
			product.setSaleUnit(productModel.getSaleUnit());
			product.setWeight(productModel.getWeight());
			product.setPrice(productModel.getPrice());
			product.setIncrement(productModel.getIncrement());
		}

		product = productRepository.save(product);
		if(shop.getProductId() != null) {
			shop.getProductId().add(product.getId());
		}
		else {
			List<String> productIdList = new ArrayList<String>();
			productIdList.add(product.getId());
			shop.setProductId(productIdList);
		}
		
		//TODO Make an API call to shop repository to update the details of the shop
//		shopRepository.save(shop);
		return product;
	}
	
	public ProductEntity findProductByName(String prodName) {
		Optional<ProductEntity> product = productRepository.findByName(prodName);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteProduct(String prodId) {
		productRepository.deleteById(prodId);
		
	}

	@Override
	public ProductCategoryEntity addCategory(String category) {
		
		ProductCategoryEntity productCategory = new ProductCategoryEntity();
		productCategory.setCategory(category);
		
		ProductCategoryEntity savedCategory = categoryRepository.save(productCategory);
		return savedCategory;
		
	}

}
