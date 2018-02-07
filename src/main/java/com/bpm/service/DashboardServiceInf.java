package com.bpm.service;

import java.util.HashMap;
import java.util.List;

public interface DashboardServiceInf {


	public List saveToCart(String cartItemList);

	public HashMap createUser(String userDetails);

	public HashMap getCatalogDetails();
}
