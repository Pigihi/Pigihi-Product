/**
 * 
 */
package com.pigihi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pigihi.entity.ProductCategoryEntity;

/**
 * @author Ashish Sam T George
 *
 */
public interface CategoryRepository extends MongoRepository<ProductCategoryEntity, String> {

}
