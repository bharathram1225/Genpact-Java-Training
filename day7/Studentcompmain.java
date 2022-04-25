package com.org.genpact.assign.day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Studentcompmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<StudentList> list = new ArrayList<StudentList>();
		list.add(new StudentList(1, "Bharath",24 ,"Developer", "2022", 99));
		list.add(new StudentList(2, "Uday",28, "sales", "1998", 999));
		list.add(new StudentList(3, "Kirshna",21, "IT", "2002", 9));
		list.add(new StudentList(4, "Yogesh",21, "devops", "2008", 99999));
		list.add(new StudentList(5, "kishore",30, "QA", "2017", 9999));
		
		System.out.println("**Before Sorting**");
		StudentList.printsalary(list);
		Collections.sort(list);
		System.out.println("**After Sorting**");
		StudentList.printsalary(list);
		;
		
		
		
		
//		Collections.sort(list, new Comparator<StudentList>() {
//
//			@Override
//			public int compare(StudentList o1, StudentList o2) {
//				if(o1.getSal() > o2.getSal()) {
//					return 1;
//				}
//				return -1;
//			}
//		});
		
		
	}
	
	
	

	

}
