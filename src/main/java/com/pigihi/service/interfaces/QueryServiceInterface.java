/**
 * 
 */
package com.pigihi.service.interfaces;

import java.util.List;

import com.pigihi.entity.ProductCategoryEntity;
import com.pigihi.entity.ProductEntity;
import com.pigihi.model.ProductModel;

/**
 * Interface for product query service <br>
 * No change in values
 * 
 * @author Ashish Sam T George
 *
 */
public interface QueryServiceInterface {

	List<ProductEntity> listAllProducts();

	List<ProductEntity> listSimilarProducts(String query);

	List<ProductEntity> findProductsByPincode(String pincode);

	ProductEntity findProductById(String prodId);

	List<ProductEntity> findProductsByCategory(String category);

	ProductEntity findProductByName(String prodName);

}
