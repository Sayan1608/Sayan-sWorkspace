package com.stockers.service;

import java.util.ArrayList;

import com.stockers.model.Company;

public class BinarySearch {

	public static int search(ArrayList<Company> companies, int left, int right,double key) {
		
//		System.out.println("inside search");
		
		MergeSort.mergeSort(companies, left, right, true);
		
		while(left <= right) {
			
			int mid = (left+right)/2;
			
			if(companies.get(mid).getSharePrice() == key) {
				return mid;
			}else if(companies.get(mid).getSharePrice() < key) {
				return search(companies,mid+1,right,key);
			}else {
				return search(companies, left, mid-1, key);
			}
		}
		
		return -1;
	}
}
