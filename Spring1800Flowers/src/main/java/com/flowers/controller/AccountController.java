package com.flowers.controller;


import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import com.flowers.model.AccountBean;
import com.flowers.model.AppCount;
import com.flowers.service.AccountService;

@RestController()
@RequestMapping(path="/api")
public class AccountController {

	@Autowired
	AccountService accountService;

	  private static final Logger LOGGER = LogManager.getLogger(AccountController.class);

	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<List<AccountBean>> createAccounts(@RequestBody List<AccountBean> list) {
		try {
		
		
		if (list!=null) {
			accountService.createAccounts(list);
			LOGGER.info("Accounts Created Successfully");
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else 
		{
			LOGGER.info("Provided List is Null");
		return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
		}catch (Exception e) {
			LOGGER.info("Provided List is Null");
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(path = "/uniqueUserIds", method = RequestMethod.GET)
	public ResponseEntity<AppCount> getUniqueUserIds() { 
    try {
	 AppCount uniqueIds = accountService.getUniqueIds();

		if (uniqueIds!=null) {
			LOGGER.info("Uniqueid retrived");
			return new ResponseEntity<>(uniqueIds, HttpStatus.OK);
		}
		else	{
			LOGGER.info("Provided List is Null");
		return new ResponseEntity<>(uniqueIds, HttpStatus.NOT_FOUND);
		}
    }catch (Exception e) {
    	LOGGER.info("Provided List is Null");
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
	}
	
	@RequestMapping(path = "/updatedUniqueUserIds", method = RequestMethod.GET)
	public ResponseEntity<List<AccountBean>> getUpdatedUserIds() {
		try {
	 List<AccountBean> updatedList = accountService.getUpdatedUserIds();
	 if(updatedList !=null) {
		 LOGGER.info("Updated List");
		 return new ResponseEntity<>(updatedList,HttpStatus.OK);
	 }
	 else { 
		 LOGGER.info("Provided List is Null");
		return new ResponseEntity<> (accountService.getUpdatedUserIds(),HttpStatus.NOT_FOUND);
	 }
		}catch (Exception e) {
			LOGGER.info("Provided List is Null");
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(path = "/updatedTitleAndBody/{id}/{title}", method = RequestMethod.PUT)
	public ResponseEntity<List<AccountBean>> getUpdatedTitleAndBody(@PathVariable("id") int id,@PathVariable("title") String title) {
		try {
             
			List<AccountBean> updatedTitleAndBody = accountService.getUpdatedTitleAndBody(id,title);
            if (updatedTitleAndBody!=null) 
            {
            	LOGGER.info("Update Tittle and Body");
            	return new ResponseEntity<>(updatedTitleAndBody,HttpStatus.OK);
            }
           
            else {
            	LOGGER.info("Provided List is Null");
		       return new ResponseEntity<>(updatedTitleAndBody,HttpStatus.NOT_FOUND);
            }
		}catch (Exception e) {
			   LOGGER.info("Provided List is Null");
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		
	}
	
	@RequestMapping(path = "/endPointsCount", method = RequestMethod.GET)
	public ResponseEntity<Integer> countEndPoints() {
		try {
		Set<RequestMappingInfo> endPoints = accountService.getEndPoints();
		if (endPoints.size()>0) { 	
			LOGGER.info("EndPointsCount");
			return new ResponseEntity<>( endPoints.size(),HttpStatus.OK);
		}
		else {
			LOGGER.info("Provided List is Null");
			return new ResponseEntity<>( endPoints.size(),HttpStatus.NOT_FOUND);
		}
		
		}catch (Exception e) {
			LOGGER.info("Provided List is Null");
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
           		
		
	}

	@RequestMapping(path = "/allAccounts", method = RequestMethod.GET)
	public ResponseEntity<List<AccountBean>> getAccounts() {
		try {
		List<AccountBean> accounts = accountService.getAccounts();
		if (accounts!=null) {
			LOGGER.info("allAccounts");
			return new ResponseEntity<>(accounts,HttpStatus.OK);
		}
		else {
			   LOGGER.info("Provided List is Null");
				return new ResponseEntity<>( accounts,HttpStatus.NOT_FOUND);
		}
		}catch (Exception e) {
			LOGGER.info("Provided List is Null");
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	
	
	@RequestMapping(path = "/endPointsList", method = RequestMethod.GET)
	public ResponseEntity<Set<RequestMappingInfo>> endPointsList() {
		  try {
		Set<RequestMappingInfo> endPoints = accountService.getEndPoints();
		if (endPoints!=null) { 
			LOGGER.info("endPointsList");
			return new ResponseEntity<>( endPoints,HttpStatus.OK);
		}
		else { 
			LOGGER.info("Provided List is Null");
           		return new ResponseEntity<>( endPoints,HttpStatus.NOT_FOUND);
		}
		
		  }catch (Exception e) {
			  LOGGER.info("Provided List is Null");
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }       

	}
	
	
}