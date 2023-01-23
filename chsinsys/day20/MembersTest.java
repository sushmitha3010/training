package com.chsinsys.day20;

import java.util.Scanner;

public class MembersTest {

	public static void main(String[] args)throws Exception {
		//to create object
		Members m=new Members();
		//print the date variables
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name");
		String name=sc.next();
		if(m.nameValidation(name)==true) {
		System.out.println("enter the age");
		int age=sc.nextInt();
	    if(m.ageValidation(age)==true) {
		System.out.println("enter the phone no");
		long phoneNo=sc.nextLong();
		if(m.phoneNoValidation(phoneNo)==true) {
		System.out.println("enter the address");
		String address=sc.next();
		System.out.println("enter the salary");
		float salary=sc.nextLong();
		System.out.println(m.printSalary(567898.0f));
		
	}


	}
}
	}
}