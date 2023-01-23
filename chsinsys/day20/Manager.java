package com.chsinsys.day20;
//extending he parent class members into child class employee
public class Manager extends Members{
	//using the data members	
	public String specialization;
	public String department;
//using default constructor
	public Manager() {
		
	}

//to use the parameterized constructor
	public Manager(String name, int age, long phoneNo, String address, float salary,String specialization,String department) {
		this.name=name;
		this.age=age;
		this.phoneNo=phoneNo;
		this.address=address;
		this.salary=salary;
		this.specialization=specialization;
		this.department=department;
	}
	//to use the validation
	public float printSalary(float salary,float pf,float hra)throws Exception {
		if(salary>0) {
			float n;
			//pf=pf*(salary/100);
			//hra=salary*(10/100);
			//n=pf-salary+hra;
			n=salary-(pf+hra);
			return n;
		}
		else {
			
		throw new Exception("Invalid  salary data");
		
	}

}
}


