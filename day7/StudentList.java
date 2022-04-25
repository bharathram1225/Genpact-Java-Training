package com.org.genpact.assign.day7;

import java.util.Comparator;
import java.util.List;

import com.org.genpact.day7.EmployeeStudent;

public class StudentList implements Comparable<StudentList> {
	private int id;
	private String name;
	private int age;
	private String depart;
	private String doj;
	private int sal;

	public StudentList(int id, String name, int age, String depart, String doj, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.depart = depart;
		this.doj = doj;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public static void printsalary(List<StudentList> list) {
		for (StudentList studentList : list) {
			System.out.format("%-15s %-30s %-15s %-30s %-10s %-10s\n", studentList.getId(), studentList.getName(),
					studentList.getAge(), studentList.getDepart(), studentList.getDoj(), studentList.getSal());
		}
	}

	@Override
	public int compareTo(StudentList o) {
		if (sal == o.sal)
			return 0;
		else if (sal > o.sal)
			return 1;
		else
			return -1;

	}

}
