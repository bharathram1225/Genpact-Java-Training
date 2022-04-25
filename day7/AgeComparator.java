package com.org.genpact.assign.day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AgeComparator {

	public static void main(String[] args) {
		List<StudentList> list = new ArrayList<StudentList>();
		list.add(new StudentList(1, "Bharath",24 ,"Developer", "2022", 99));
		list.add(new StudentList(2, "Uday",28, "sales", "1998", 999));
		list.add(new StudentList(3, "Kirshna",21, "IT", "2002", 9));
		list.add(new StudentList(4, "Yogesh",21, "devops", "2008", 99999));
		list.add(new StudentList(5, "kishore",30, "QA", "2017", 9999));
		
		System.out.println("**Before Sorting by age or DOJ**");
		StudentList.printsalary(list);
		
		
		Comparator<StudentList> com = new Comparator<StudentList>() {
			
			@Override
			public int compare(StudentList o1, StudentList o2) {
				if(o1.getAge() > o2.getAge()) {
					return 1;
				}
				else if (o1.getAge() == o2.getAge()) {
					if(Integer.parseInt(o1.getDoj()) > Integer.parseInt(o2.getDoj())) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else
					return -1;
				
			}
		};
		
		
		
		System.out.println("**After Sorting by age if equal then DOj**");
		Collections.sort(list, com);
		StudentList.printsalary(list);

	}

}
