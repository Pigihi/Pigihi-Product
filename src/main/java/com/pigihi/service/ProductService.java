/**
 * 
 */
package com.pigihi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pigihi.entity.ProductEntity;
import com.pigihi.model.ProductModel;
import com.pigihi.model.ShopModel;
import com.pigihi.model.ShopStockModel;
import com.pigihi.repository.ProductRepository;
import com.pigihi.service.interfaces.ProductServiceInterface;
import com.pigihi.service.interfaces.QueryServiceInterface;

/**
 * @author Ashish Sam T George
 *
 */
@Service
public class ProductService implements ProductServiceInterface {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private QueryServiceInterface productQueryService;
	
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
		
		ProductEntity productCheck = productQueryService.findProductByName(productModel.getProdName());
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
	
	@Override
	public void deleteProduct(String prodId) {
		productRepository.deleteById(prodId);
		
	}

}
