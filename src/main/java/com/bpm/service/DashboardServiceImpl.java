package com.bpm.service;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bpm.dao.inf.DashboardDaoInf;
import com.bpm.model.CartItem;
import com.bpm.model.CatalogItem;
import com.bpm.service.DashboardServiceInf;

@Service("dashboardService")
public class DashboardServiceImpl implements DashboardServiceInf{
	private static Logger log = Logger.getLogger(DashboardServiceImpl.class.getName());
	
	@Autowired
	DashboardDaoInf dashboardDao;

	@Override
	public HashMap getCatalogDetails() {
		System.out.println("DashboardServiceImpl.java : getCatalogDetails()");
		
		HashMap catalogMap = dashboardDao.getCatalogDetails();
		System.out.println("\t catalogMap.size() : " + catalogMap.size());
		
		return catalogMap;
	}
	
	@Override
	public List saveToCart(String cartItemList) {
		log.info("DashboardServiceImpl.java : saveToCart()");
		System.out.println("\t cartItemList : " + cartItemList);
		
		List<CartItem> cartItemListResponse = dashboardDao.saveToCart(cartItemList);
//		System.out.println("\t cartItemList.size() : " + cartItemList.size());
		log.info("\t cartItemListResponse.size() : " + cartItemListResponse.size());
		return cartItemListResponse;
	}

	@Override
	public HashMap createUser(String userDetails) {
		System.out.println("DashboardServiceImpl");
		HashMap userMap = dashboardDao.createUser(userDetails);
		System.out.println("\t userMap.size() : " + userMap.size());
		return userMap;
	}



	
}
