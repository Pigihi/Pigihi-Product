/**
 * 
 */
package com.pigihi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pigihi.entity.ProductCategoryEntity;
import com.pigihi.entity.ProductEntity;
import com.pigihi.model.ProductModel;
import com.pigihi.model.UpdateStatusModel;
import com.pigihi.service.QueryServiceInterface;

/**
 * @author Ashish Sam T George
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private QueryServiceInterface productQueryService;
	
	/**
	 * Get information of all the products
	 * 
	 * @return String in JSON format
	 */
	@GetMapping("/all")
	public String listAllProducts() {
		
		//TODO Don't need to give away all the details of the products to clients. Only neccessary information to be sent
		List<ProductEntity> productList = productQueryService.listAllProducts();
		String products = convertToJson(productList);
		return products;
		
	}
	
	/**
	 * Get information about similar products
	 * 
	 * @param query
	 * @return
	 */
	@GetMapping("/similar")
	public String listSimilarProducts(@RequestParam String query) {
		
		List<ProductEntity> productList = productQueryService.listSimilarProducts(query);
		String products = convertToJson(productList);
		return products;
		
	}
	
	/**
	 * Get all the products having that pincode
	 * 
	 * @return String in JSON format 
	 */
	@GetMapping("/allByPin")
	public String listProductsByPin(@RequestParam String pincode) {
		
		//TODO Improve this approach
		List<ProductEntity> productList = productQueryService.findProductsByPincode(pincode);
		String products = convertToJson(productList);
		return products;
		
	}
	
	/**
	 * Get information of product based on id
	 * 
	 * @param id
	 * @return String in JSON format
	 */
	@GetMapping("/id")
	public String getProductById(@RequestParam String prodId) {
		
		ProductEntity productEntity = productQueryService.findProductById(prodId);
		
		//TODO Create some common interface or something to convert different data types into json
		Gson gson = new Gson();
		String product = gson.toJson(productEntity);
		return product;
		
	}
	
	@GetMapping("/productsbycategory")
	public String listProductsByCategory(@RequestParam String category){
		List<ProductEntity> productList = productQueryService.findProductsByCategory(category);
		String products = convertToJson(productList);
		return products;
	}
	
	/**
	 * Store product details in database and returns the id
	 * 
	 * @param productEntity
	 * @return String in JSON format
	 */
	@PostMapping("/addProuct")
	public String addProduct(@RequestBody ProductModel productModel) {
		ProductEntity productEntity = productQueryService.addProduct(productModel);
		Gson gson = new Gson();
		String product = gson.toJson(productEntity);
		return product;
	}
	
	/**
	 * Update product details in database and returns the id
	 * 
	 * @param productEntity
	 * @return String in JSON format
	 */
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody ProductEntity productEntity) {
		
		return "Not yet implemented";
		
	}
	
	/**
	 * 
	 * 
	 * @param prodId
	 * @return
	 */
	@DeleteMapping("/")
	public String deleteProduct(@RequestParam String prodId) {
		productQueryService.deleteProduct(prodId);
		return "SUCCESSFULLY DELETED";
	}
	
	@PostMapping("/admin/product/category")
	public String addCategory(@RequestParam String category) {
		ProductCategoryEntity savedCategory = productQueryService.addCategory(category);
		Gson gson = new Gson();
		String response = gson.toJson(savedCategory);
		return response;
	}
	
	/**
	 * 
	 * @param updateStatusModel
	 * @return
	 */
	@PostMapping("/enableStatus")
	public String enableStatus(@RequestBody UpdateStatusModel updateStatusModel) {
		
		//TODO How about making the enable status and disable status under one method
		
		//TODO How about keeping two status for a product: one for the product itself
		// and other for the shops containing the products, which indicate whether the shop
		// is actually authorized to sell that product
		
		return "Not implemented yet";
	
	}
	
	/**
	 * 
	 * @param updateStatusModel
	 * @return
	 */
	@PostMapping("/disableStatus")
	public String disableStatus(@RequestBody UpdateStatusModel updateStatusModel) {
		
		//TODO How about making the enable status and disable status under one method
		
		return "Not implemented yet";
		
	}
	
	private String convertToJson(List<ProductEntity> productList) {
		
		Gson gson = new Gson();
		String products = gson.toJson(productList);
		return products;
		
	}

}
