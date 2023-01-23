package com.chsinsys.day20;
//extending he parent class members into child class employee
public class Employee extends Members{
//using data members
	public String specialization;
	 public String department;
//using default constructor
	public Employee() {
		
	}
//using parameterized constructor
	public Employee(String name, int age, long phoneNo, String address, float salary,String specialization,String department) {
		this.name=name;
		this.age=age;
		this.phoneNo=phoneNo;
		this.address=address;
		this.salary=salary;
		this.specialization=specialization;
		this.department=department;
	}
	//to use the validation
	public float printSalary(float salary,float pf)throws Exception {
		if(salary>0) {
			float n;
			pf=pf*(salary/100);
			n=salary-pf;
			return n;
		}
		else
		throw new Exception("Invalid salary data");
		
	
	}
}
