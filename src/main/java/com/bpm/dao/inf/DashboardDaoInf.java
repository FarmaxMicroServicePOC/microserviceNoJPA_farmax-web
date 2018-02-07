package com.bpm.dao.inf;

import java.util.HashMap;
import java.util.List ;

import com.bpm.model.CartItem;
import com.bpm.model.User;

public interface DashboardDaoInf {

	public List saveToCart(String cartItemList);

	public HashMap createUser(String userDetails);

	public HashMap getCatalogDetails();
	
}
