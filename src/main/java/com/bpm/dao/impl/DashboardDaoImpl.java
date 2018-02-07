package com.bpm.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bpm.dao.inf.DashboardDaoInf;
import com.bpm.model.CatalogItem;
import com.bpm.model.User;

@Service("dashboardDao")
//@Repository("dashboardDao")
public class DashboardDaoImpl implements DashboardDaoInf{
	private static Logger log = Logger.getLogger(DashboardDaoImpl.class.getName()); 
	
	@Override
	public HashMap getCatalogDetails() {
		log.debug("DashboardDaoImpl.java : getCatalogDetails()");

//		String getCatalogDetailsURI = "http://localhost:8080/Catalog/catalog/getCatalogDetails";
//		String getCatalogDetailsURI = "http://localhost:8080/farmax-catalog/catalog/getCatalogDetails";
//		String getCatalogDetailsURI = "http://10.65.182.240:8086/farmax-catalog/catalog/getCatalogDetails";
		String getCatalogDetailsURI = "http://172.17.0.3:8086/farmax-catalog/catalog/getCatalogDetails";
		
	    RestTemplate restTemplate = new RestTemplate();
	    List<CatalogItem> catalogItemList = new ArrayList();
//	    List<CatalogItem> catalogItemList =  (List<CatalogItem>) restTemplate.getForObject(getCatalogDetailsURI, ArrayList.class);
//	    log.debug("\t catalogItemList :" + catalogItemList.toString());
//		System.out.println("\t catalogItem.size() : " + catalogItemList.size() + "\n\t catalogItemList :" + catalogItemList.toString());

	    HashMap catalogItemMap =   restTemplate.getForObject(getCatalogDetailsURI, HashMap.class);
	    log.debug("\t catalogItemMap :" + catalogItemMap.toString());
		System.out.println("\t catalogItemMap.size() : " + catalogItemMap.size() + "\n\t catalogItemMap :" + catalogItemMap.toString());

		
		return catalogItemMap;
	}
	
	@Override
	public List saveToCart(String cartItemList) {
		System.out.println("DashboardDaoImpl.java : saveToCart()");
		System.out.println("\t cartItemList : " + cartItemList);
		log.debug("DashboardDaoImpl.java : saveToCart()");

		String saveToCartURL = "http://localhost:8080/farmax-catalog/cart/saveToCart";
		
		RestTemplate restTemplateQuote = new RestTemplate();
        HashMap cartItemMap = restTemplateQuote.postForObject(saveToCartURL, cartItemList,  HashMap.class) ;
        
        log.debug("\t cartItemMap : " + cartItemMap.toString());
        System.out.println("\t cartItemMap : " + cartItemMap.toString());
        
		List cartList = new ArrayList();
		cartList.add(cartItemMap);
	
		System.out.println("\t cartList.size() : " + cartList.size());
		return cartList;
	}	


	@Override
	public HashMap createUser(String userDetails) {
		log.info("DashboardDaoImpl.java : createUser()");
		
		String createUserUrl = "http://localhost:8080/farmax-User/user/createUser";
		RestTemplate restTemplateQuote = new RestTemplate();
        HashMap userDetailsMap = restTemplateQuote.postForObject(createUserUrl, userDetails,  HashMap.class) ;
        
        log.debug("\t userDetailsMap : " + userDetailsMap.toString());
        System.out.println("\t userDetailsMap : " + userDetailsMap.toString());

        
		List userList = new ArrayList<User>();
		User user = new User(); 
		
		user.setLogin("rahil");
		user.setPassword("*******");
		user.setUsername("Rahil Khan");
		user.setAddress("ASF,GGN");
		user.setCity("GGN");
		user.setState("Haryana");
		user.setCountry("India");
		user.setZip("122003");
		user.setCreditcard("2367982345091298");
		userList.add(user);
		
		System.out.println("\t userDetailsMap.size() : " + userDetailsMap.size());
		return userDetailsMap;
		
	}

}
