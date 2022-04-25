package com.org.genpact.assign.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TrimListData {
	
	
	public void StringListTriem(List<String> list) {
		ListIterator<String> value = list.listIterator();
		while(value.hasNext()) {
			String names = value.next();
			String trimdata = names.trim();
			value.set(trimdata);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listobj = new ArrayList<String>();
		listobj.add("Bharath ");
		listobj.add("Bharath1 ");
		listobj.add("Bharath2 ");
		listobj.add("Bharath3 ");
		
		TrimListData t1 = new TrimListData();
		t1.StringListTriem(listobj);
		
		System.out.println("------display----------");
		for (String string : listobj) {
			
			 System.out.println(string);
		}
		
		
	}

}
