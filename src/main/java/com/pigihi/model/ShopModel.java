package com.pigihi.model;

import java.util.List;

import lombok.Data;

@Data
public class ShopModel {
	
	private String id;
	private String shopName;
	private String email;
	private String ownerFullName;
	private String role;
	private String mobile;
	private String imageUrl;
//	private EnableStatusEnum enableStatus = EnableStatusEnum.ENABLED;
	private boolean verifyStatus = false;
	private String documentUrl;
	private String streetName;
	private String cityName;
	private String pincode;
	private List<String> productId;

}
