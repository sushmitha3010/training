package com.chsinsys.day20;

public class ManagerTest {

	public static void main(String[] args)throws Exception {
		// to create object
		Manager m1=new Manager("ram",22,976542789,"Trichy",36543.0f,"java","java Manager");
		//to print the data variables
		System.out.println("name:"+m1.name);
		System.out.println("age:"+m1.age);
		System.out.println("phoneNo:"+m1.phoneNo);
		System.out.println("address:"+m1.address);
		System.out.println("salary:"+m1.salary);
		//System.out.println("salary:"+m1.salary);
		System.out.println("specialization:"+m1.specialization);
		System.out.println("department:"+m1.department);
		System.out.println(m1.printSalary(34567.0f,50f,34f));
	
	}

}
