/**
 * 
 */
package com.pigihi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pigihi.entity.ProductEntity;

/**
 * @author Ashish Sam T George
 *
 */
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

	@Query("{prodName: {$regex: /?0/, $options: i}}")
	List<ProductEntity> findSimilarProducts(String prodName);
	
	@Query("{pincode: ?0}")
	List<ProductEntity> findAllByPincode(String pincode);
	
	@Query("{category: ?0}")
	List<ProductEntity> findAllByCategory(String category);
	
	@Query("{prodName: ?0}")
	Optional<ProductEntity> findByName(String prodName);

}
