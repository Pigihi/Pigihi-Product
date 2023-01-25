/**
 * 
 */
package com.pigihi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pigihi.entity.ProductCategoryEntity;
import com.pigihi.repository.CategoryRepository;

/**
 * Service class for category requests <br>
 * Contains methods that can change values
 * 
 * @author Ashish Sam T George
 *
 */
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductCategoryEntity addCategory(String category) {
		
		ProductCategoryEntity productCategory = new ProductCategoryEntity();
		productCategory.setCategory(category);
		
		ProductCategoryEntity savedCategory = categoryRepository.save(productCategory);
		return savedCategory;
		
	}

}
