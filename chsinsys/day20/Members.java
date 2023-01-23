package com.chsinsys.day20;
//using data members
public class Members {
public String name;
public int age;
public long phoneNo;
public String address;
public float salary;
//using default constructor
public Members() {
	
}
//using parameterized constructor
public Members(String name, int age, long phoneNo, String address, float salary ) {
	
	this.name = name;
	this.age = age;
	this.phoneNo = phoneNo;
	this.address = address;
	this.salary = salary;
}
//to create the method and print the salary
public float printSalary(float salary) {

	System.out.println("your salary");
	return salary;
	
	}
//using validation
public boolean nameValidation(String name)throws Exception{
	if(name.length()>=3) {
        String n=name;	
		boolean valid=n.matches("[a-z A_Z]+");
		return valid;
		}
	else 
		throw new Exception("Invalid name");
	}
	
//using validation
public boolean ageValidation(int age)throws Exception {
	if(age>=18) {
		return true;
		
	}
	else {
		throw new Exception("Invalid age");
	}
}
	public boolean phoneNoValidation(long phoneNo) throws Exception{
		String valid=Long.toString(phoneNo);
		if(valid.length()==10) {
			return true;
		}
		else {
			throw new Exception("Invalid no");
		}
	}
}
	



