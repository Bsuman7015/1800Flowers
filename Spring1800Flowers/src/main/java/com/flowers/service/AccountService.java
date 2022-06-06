package com.flowers.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import com.flowers.model.AccountBean;
import com.flowers.model.AppCount;
import com.flowers.repository.AccountRepository;

@Service
public class AccountService {

	  private static final Logger LOGGER = LogManager.getLogger(AccountService.class);

	@Autowired
	AccountRepository accountRepository;
	
	
	Set<RequestMappingInfo> keys=new LinkedHashSet<>();
	 
	public AppCount getUniqueIds(){
		List<Integer> uniqueIds=new ArrayList<>();
		List<AccountBean> acountBeanList = accountRepository.findAll();
		for (AccountBean accountBean : acountBeanList) {
			
			uniqueIds.add(accountBean.getUserId());
		}
		AppCount appCount = new AppCount();
		appCount.setUniqueIds(uniqueIds);
		appCount.setCount(uniqueIds.stream().count());
	return 	appCount;
	}
	
	
public List<AccountBean> getUpdatedList(List<AccountBean> acountBeanList){
		
		List<AccountBean> newList = new ArrayList<AccountBean>();
		newList=	acountBeanList.stream().collect(Collectors.toConcurrentMap(AccountBean::getUserId, Function.identity(), (p, q) -> p)).values().stream().collect(Collectors.toList());

		
	return 	newList;
	}

public List<AccountBean> getUpdatedTitleAndBody(int id,String title){
	

	List<AccountBean> acountBeanList = accountRepository.findAll();
	if(acountBeanList!=null) {
		for (AccountBean accountBean : acountBeanList) {
			if(accountBean.getUserId()==id) {
				accountBean.setTitle(title);
				accountBean.setBody(title);
			accountRepository.save(accountBean);
			}
		}
	}
	return acountBeanList;
	}


public void createAccounts(List<AccountBean> list) {
	
	List<AccountBean> updatedList = getUpdatedList(list);
	if(updatedList==null) {
	LOGGER.info("Provided List is Null");
	}
	else {
	for (AccountBean accountBean : updatedList) {
		accountRepository.save(accountBean);
	}
	
	}
}


public List<AccountBean> getAccounts() {
	
	return accountRepository.findAll();
}


public List<AccountBean> getUpdatedUserIds() {
	
	return accountRepository.findAll();
}

public Set<RequestMappingInfo> getEndPoints() {
	
	return keys;
}


public void getEnPointCount(Map<RequestMappingInfo, HandlerMethod> map) {

	keys=map.keySet();
}
}
