/**
 * 
 */
package com.pigihi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class for product
 * 
 * @author Ashish Sam T George
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	
	private String pincode;
	private int stock;
	private String prodName;
	private String category;
	private String imageUrl;
	private String mainUnit;
	private String saleUnit;
	private double weight;
	private double price;
	private int increment;

}
