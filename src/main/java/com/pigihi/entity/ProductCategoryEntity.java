/**
 * 
 */
package com.pigihi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Ashish Sam T George
 *
 */
@Document(collection = "category_collection")
@Data
public class ProductCategoryEntity {
	
	@Id
	private String id;
	private String category;

}
