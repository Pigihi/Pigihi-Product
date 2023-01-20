/**
 * 
 */
package com.pigihi.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pigihi.model.ShopStockModel;

import lombok.Data;

/**
 * @author Ashish Sam T George
 *
 */
@Document(collection = "product_collection")
@Data
public class ProductEntity {
	
	@Id
	private String id;
	private List<ShopStockModel> shops;
	private List<String> pincode;
	private String prodName;
	private String category;
	private String imageUrl;
	private String mainUnit;
	private String saleUnit;
	private double weight;
	private double price;
	private int increment;
	private boolean enabled = true;

}
