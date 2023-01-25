/**
 * 
 */
package com.pigihi.service.interfaces;

import com.pigihi.entity.ProductEntity;
import com.pigihi.model.ProductModel;

/**
 * Interface for Prouduct service 
 * 
 * @author Ashish Sam T George
 *
 */
public interface ProductServiceInterface {

	ProductEntity addProduct(ProductModel productModel);

	void deleteProduct(String prodId);

}
