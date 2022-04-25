package com.org.genpact.assign.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

class LocalStudent {
    public String name;
    public int age;
    public Location Location;
    public List<PhoneNumber> PhoneNumbers;
	public LocalStudent(String name, int age, com.org.genpact.assign.day4.Location location,
			List<PhoneNumber> phoneNumbers) {
		super();
		this.name = name;
		this.age = age;
		Location = location;
		PhoneNumbers = phoneNumbers;
	}
}


class Student_Part{
	private String name;
	private int age;
	private Location Location;
	private List<PhoneNumber> PhoneNumbers;
	
	public Student_Part(String name, int age, com.org.genpact.assign.day4.Location location,
			List<PhoneNumber> phoneNumbers) {
		super();
		this.name = name;
		this.age = age;
		Location = location;
		PhoneNumbers = phoneNumbers;
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

	public Location getLocation() {
		return Location;
	}

	public void setLocation(Location location) {
		Location = location;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return PhoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		PhoneNumbers = phoneNumbers;
	}
}


class Location{
    private String zipcode;

	public Location(String zipcode) {
		super();
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}  
}


class PhoneNumber{
    private String number;

	public PhoneNumber(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}  
} 





public class Stream_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Location lc1 = new Location("1235");		
		Location lc2 = new Location("562158");	
		Location lc3 = new Location("560064");
		
		List<PhoneNumber> list1 = new ArrayList<PhoneNumber>();
		list1.add(new PhoneNumber("987654272"));
		list1.add(new PhoneNumber("324452372"));
		
		
		List<PhoneNumber> list2 = new ArrayList<PhoneNumber>();
		list2.add(new PhoneNumber("4353"));
		list2.add(new PhoneNumber("123"));
		
		
		List<PhoneNumber> list3 = new ArrayList<PhoneNumber>();
		list3.add(new PhoneNumber("1234"));
		list3.add(new PhoneNumber("1233"));
		
		
		List<Student_Part> list_stud = new ArrayList<Student_Part>();
		list_stud.add(new Student_Part("bharath", 24, lc1, list1));
		list_stud.add(new Student_Part("uday", 19, lc2, list2)); 
		list_stud.add(new Student_Part("Jayesh", 21, lc3, list3));
		
		
		System.out.println("1....");
		 List<String> l = list_stud.stream().filter(s->s.getName().equals("Jayesh")).map(x->x.getName()).collect(Collectors.toList());
		 System.out.println(l);
		 System.out.println("********************************");
		 
		 
		 List<String> addre = list_stud.stream().filter(x->x.getLocation().getZipcode().equals("1235")).map(x->x.getName()).collect(Collectors.toList());
		 System.out.println(addre);
		 
//		 System.out.println("3.....");
//		 List<Student_Part> l1 = list_stud.stream().filter(s->s.getPhoneNumbers().stream().anyMatch(x->x.getNumber().equals("123"))).collect(Collectors.toList());
//		 List<String> abc = l1.stream().map(x->x.getName()).collect(Collectors.toList());
//		System.out.println(abc);
		
		List<Student_Part> mob = list_stud.stream().filter(x1->x1.getPhoneNumbers().stream().anyMatch(x->x.getNumber().equals("1233") || x.getNumber().equals("1234"))).collect(Collectors.toList());
		List<String> mobname = mob.stream().map(x->x.getName()).collect(Collectors.toList());
		System.out.println(mobname);
		
		LocalStudent l_student1 = new LocalStudent("Bharath", 20, new Location("0873"), Arrays.asList(new PhoneNumber("76328"), new PhoneNumber("34342")));
		LocalStudent l_student2 = new LocalStudent("kiran", 22, new Location("5126"), Arrays.asList(new PhoneNumber("32047"), new PhoneNumber("8739")));
		LocalStudent l_student3 = new LocalStudent("sham", 29, new Location("8123"), Arrays.asList(new PhoneNumber("09347"), new PhoneNumber("9730")));
		ArrayList<LocalStudent> l_student = new ArrayList<LocalStudent>();
		l_student.add(l_student1);
		l_student.add(l_student2);
		l_student.add(l_student3);
		
		List<Student_Part> listls = l_student.stream().map(x->new Student_Part(x.name, x.age, x.Location, x.PhoneNumbers)).collect(Collectors.toList());
		System.out.println(listls);
		
		
		List<String> ls = listls.stream().map(x->x.getName()).collect(Collectors.toList());
		System.out.println(ls);
		
		
		List<String> nameuppercase = list_stud.stream().map(x->x.getName().toUpperCase()).collect(Collectors.toList());
		System.out.println(nameuppercase);
		
		List<String> namesort = list_stud.stream().map(x->x.getName()).sorted().collect(Collectors.toList());
		System.out.println(namesort);
		
		System.out.println("before sorting..........");
		for (Student_Part string : list_stud) {
			System.out.print(string.getName()+" ");
		}
		System.out.println("");
		
		System.out.println("after sorting...........");
		List<String> namesort1 = list_stud.stream().map(x->x.getName()).sorted().collect(Collectors.toList());
		System.out.println(namesort1);
		
		List<String> names_list = list_stud.stream().map(x->x.getName()).filter(x->x.equals("Jayesh")).collect(Collectors.toList());
		System.out.println(names_list);
		


		
	}

}
