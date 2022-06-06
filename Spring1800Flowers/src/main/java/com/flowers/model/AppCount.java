package com.flowers.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class AppCount {
	
	private List<Integer> uniqueIds; 
    private int count;
	public List<Integer> getUniqueIds() {
		return uniqueIds;
	}
	public void setUniqueIds(List<Integer> uniqueIds) {
		this.uniqueIds = uniqueIds;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AppCount [uniqueIds=" + uniqueIds + ", count=" + count + "]";
	}
    
}
