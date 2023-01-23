package com.chsinsys.day20;

public class EmployeeTest {

	public static void main(String[] args)throws Exception{
		// to create object
		Employee e=new Employee("sus",22,98765432,"madurai",345678,"oracle","oracle trainee");
		//to print the data variables
		System.out.println("name:"+e.name);
		System.out.println(e.nameValidation("dheenu"));
		System.out.println("age:"+e.age);
		System.out.println(e.ageValidation(24));
		System.out.println("phoneNo:"+e.phoneNo);
		System.out.println("address:"+e.address);
		System.out.println("salary:"+e.salary);
		System.out.println("specialization:"+e.specialization);
		System.out.println("department:"+e.department);
		System.out.println(e.printSalary(456732.0f,40f));
	}

}
