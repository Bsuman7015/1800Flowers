package com.flowers.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class AppCount {
	
	private List<Integer> uniqueIds; 
    private Long count;
	public List<Integer> getUniqueIds() {
		return uniqueIds;
	}
	public void setUniqueIds(List<Integer> uniqueIds) {
		this.uniqueIds = uniqueIds;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AppCount [uniqueIds=" + uniqueIds + ", count=" + count + "]";
	}
    
}
