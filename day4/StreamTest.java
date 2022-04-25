package com.org.genpact.assign.day4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class TempStudent {
	 public String name;
	 public int age;
	 public Address address;
	 public List<MobileNumber> mobileNumbers;
	 
	 public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		 this.name = name;
		 this.age = age;
		 this.address = address;
		 this.mobileNumbers = mobileNumbers;
	 }
}



class Student{
	 private String name;
	 private int age;
	 private Address address;
	 private List<MobileNumber> mobileNumbers;
	 
	 public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		 this.name = name;
		 this.age = age;
		 this.address = address;
		 this.mobileNumbers = mobileNumbers;
	 }
	 public String getName() {
		 return name;
	 }
	 public int getAge() {
		 return age;
	 }
	 public Address getAddress() {
		 return address;
	 }
	 public List<MobileNumber> getMobileNumbers() {
		 return mobileNumbers;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public void setAge(int age) {
		 this.age = age;
	 }
	 public void setAddress(Address address) {
		 this.address = address;
	 }
	 public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
		 this.mobileNumbers = mobileNumbers;
	 }
	 @Override
	 public String toString() {
	 return "Student{" +
	"name='" + name + '\'' +
	", age=" + age +
	", address=" + address +
	", mobileNumbers=" + mobileNumbers +
	'}';
	 }
}


class Address{
	 private String zipcode;
	 
	 public Address(String zipcode) {
		 this.zipcode = zipcode;
	 }
	 
	 public String getZipcode() {
	 return zipcode;
	 }
	 
	 public void setZipcode(String zipcode) {
		 this.zipcode = zipcode;
	 }
}


class MobileNumber{
	 private String number;
	 
	 public MobileNumber(String number) {
		 this.number = number;
	 }
	 public String getNumber() {
		 return number;
	 }
	 public void setNumber(String number) {
	 	this.number = number;
	 }
}



public class StreamTest {
 public static void main(String[] args) {
	 
Student student1 = new Student("Jayesh",20,new Address("1234"),Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
Student student2 = new Student("Bharath",20,new Address("1235"),Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
Student student3 = new Student("Uday",20,new Address("1236"),Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
System.out.println(student1); 
List<Student> students = Arrays.asList(student1, student2, student3);
 
 
 System.out.println("1....");
 List<String> l = students.stream().filter(s->s.getName().equals("Jayesh")).map(x->x.getName()).collect(Collectors.toList());
 System.out.println(l);
 System.out.println("********************************");
 
 

 System.out.println("2...");
 Optional<Student> stud1 = students.stream().filter(student -> student.getAddress().getZipcode().equals("1235")).findFirst();
 System.out.println(stud1.isPresent() ? stud1.get().getName() : "There is no such student");
 System.out.println("********************************");
 
 
 
 
 System.out.println("3...");
 List<Student> stud2 = students.stream().filter(student111 -> student111.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(), "3333"))).collect(Collectors.toList());
 String result1 = stud2.stream().map(std -> std.getName()).collect(Collectors.joining(",", "[", "]"));
 System.out.println(result1);
 System.out.println("********************************");

 

 System.out.println("8....");
 List<String> nameList =Arrays.asList("Jayesh", "Bharath", "Uday", "Sham", "ling");
 nameList.stream().map(String::toUpperCase).forEach(System.out::println);
 System.out.println("********************************");

 
 System.out.println("9....");
 List<String> namesList =Arrays.asList("Jayesh", "Bharath", "Uday", "Sham", "ling");
 namesList.stream().sorted().forEach(System.out::println);
 System.out.println("********************************");

 
 

 }
}
