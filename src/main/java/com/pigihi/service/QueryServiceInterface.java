/**
 * 
 */
package com.pigihi.service;

import java.util.List;

import com.pigihi.entity.ProductCategoryEntity;
import com.pigihi.entity.ProductEntity;
import com.pigihi.model.ProductModel;

/**
 * @author Ashish Sam T George
 *
 */
public interface QueryServiceInterface {

	List<ProductEntity> listAllProducts();

	List<ProductEntity> listSimilarProducts(String query);

	List<ProductEntity> findProductsByPincode(String pincode);

	ProductEntity findProductById(String prodId);

	List<ProductEntity> findProductsByCategory(String category);

	ProductEntity addProduct(ProductModel productModel);

	void deleteProduct(String prodId);

	ProductCategoryEntity addCategory(String category);

}
