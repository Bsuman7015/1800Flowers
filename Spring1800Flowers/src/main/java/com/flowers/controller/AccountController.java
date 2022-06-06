package com.flowers.controller;


import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.flowers.model.AccountBean;
import com.flowers.model.AppCount;
import com.flowers.service.AccountService;

@RestController()
@RequestMapping(path="/api")
public class AccountController {

	@Autowired
	AccountService accountService;
     
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<List<AccountBean>> createAccounts(@RequestBody List<AccountBean> list) {
		try {
		accountService.createAccounts(list);
		if (list!=null) 
			return new ResponseEntity<>(list,HttpStatus.OK);
		else 
		return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(path = "/uniqueUserIds", method = RequestMethod.GET)
	public ResponseEntity<AppCount> getUniqueUserIds() { 
    try {
	 AppCount uniqueIds = accountService.getUniqueIds();

		if (uniqueIds!=null) 
			return new ResponseEntity<>(uniqueIds, HttpStatus.OK);
		else	
		return new ResponseEntity<>(uniqueIds, HttpStatus.NOT_FOUND);
	
    }catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
	}
	
	@RequestMapping(path = "/updatedUniqueUserIds", method = RequestMethod.GET)
	public ResponseEntity<List<AccountBean>> getUpdatedUserIds() {
		try {
	 List<AccountBean> updatedList = accountService.getUpdatedUserIds();
	 if(updatedList !=null) 
		 return new ResponseEntity<>(updatedList,HttpStatus.OK); 
	 else 
		return new ResponseEntity<> (accountService.getUpdatedUserIds(),HttpStatus.NOT_FOUND);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(path = "/updatedTitleAndBody", method = RequestMethod.PUT)
	public ResponseEntity<List<AccountBean>> getUpdatedTitleAndBody() {
		try {
            List<AccountBean> updatedTitleAndBody = accountService.getUpdatedTitleAndBody();
		
            if (updatedTitleAndBody != null) 
            	return new ResponseEntity<>(updatedTitleAndBody,HttpStatus.OK);
           
            else 
		       return new ResponseEntity<>(accountService.getUpdatedTitleAndBody(),HttpStatus.NOT_FOUND);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		
	}
	
	@RequestMapping(path = "/endPointsCount", method = RequestMethod.GET)
	public ResponseEntity<Integer> countEndPoints() {
		try {
		Set<RequestMappingInfo> endPoints = accountService.getEndPoints();
		if (endPoints.size()>0) 	
			return new ResponseEntity<>( endPoints.size(),HttpStatus.OK);
		else 
			return new ResponseEntity<>( endPoints.size(),HttpStatus.NOT_FOUND);
		
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
           		
		
	}

	@RequestMapping(path = "/allAccounts", method = RequestMethod.GET)
	public ResponseEntity<List<AccountBean>> getAccounts() {
		try {
		List<AccountBean> accounts = accountService.getAccounts();
		if (accounts!=null) 
			return new ResponseEntity<>(accounts,HttpStatus.OK);
			
		else 
				return new ResponseEntity<>( accounts,HttpStatus.NOT_FOUND);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	
	
	@RequestMapping(path = "/endPointsList", method = RequestMethod.GET)
	public ResponseEntity<Set<RequestMappingInfo>> endPointsList() {
		  try {
		Set<RequestMappingInfo> endPoints = accountService.getEndPoints();
		if (endPoints!=null) 
			return new ResponseEntity<>( endPoints,HttpStatus.OK);
		
		else 
           		return new ResponseEntity<>( endPoints,HttpStatus.NOT_FOUND);
		
		  }catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }       

	}
	
	
}