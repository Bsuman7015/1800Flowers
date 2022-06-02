package com.flowers.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import com.flowers.model.AccountBean;
import com.flowers.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	
	Set<RequestMappingInfo> keys=new LinkedHashSet<>();
	 
	public List<Integer> getUniqueIds(){
		List<Integer> uniqueIds=new ArrayList<>();
		List<AccountBean> acountBeanList = accountRepository.findAll();
		for (AccountBean accountBean : acountBeanList) {
			uniqueIds.add(accountBean.getUserId());
		}
	return 	uniqueIds;
	}
	
	
public List<AccountBean> getUpdatedList(List<AccountBean> acountBeanList){
		
		List<AccountBean> newList = new ArrayList<AccountBean>();
		newList=	acountBeanList.stream().collect(Collectors.toConcurrentMap(AccountBean::getUserId, Function.identity(), (p, q) -> p)).values().stream().collect(Collectors.toList());

		
	return 	newList;
	}

public List<AccountBean> getUpdatedTitleAndBody(){
	

	List<AccountBean> acountBeanList = accountRepository.findAll();
	if(acountBeanList!=null) {
		for (AccountBean accountBean : acountBeanList) {
			if(accountBean.getUserId()==4) {
				accountBean.setTitle("1800flowers");
				accountBean.setBody("1800flowers");
			accountRepository.save(accountBean);
			}
		}
	}
	return acountBeanList;
	}


public void createAccounts(List<AccountBean> list) {
	
	List<AccountBean> updatedList = getUpdatedList(list);

	for (AccountBean accountBean : updatedList) {
		accountRepository.save(accountBean);
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
