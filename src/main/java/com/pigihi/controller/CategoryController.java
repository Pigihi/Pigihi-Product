/**
 * 
 */
package com.pigihi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.pigihi.entity.ProductCategoryEntity;
import com.pigihi.service.CategoryService;
import com.pigihi.service.interfaces.QueryServiceInterface;

/**
 * Controller class for handling category API requests
 * 
 * @author Ashish Sam T George
 *
 */
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * Add new category
	 * 
	 * @param category
	 * @return JSON string
	 * 
	 * @see ProductCategoryEntity
	 * 
	 * @author Ashish Sam T George
	 * 
	 */
	@PostMapping("/admin/product/category")
	public String addCategory(@RequestParam String category) {
		ProductCategoryEntity savedCategory = categoryService.addCategory(category);
		Gson gson = new Gson();
		String response = gson.toJson(savedCategory);
		return response;
	}

}
