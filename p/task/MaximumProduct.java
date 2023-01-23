package com.p.task;
import java.util.Arrays;
import java.util.Scanner;
public class MaximumProduct {
public static void main(String[] args) {
	int product=0;
	int n1=0,n2=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the size of an array:");
		int size=sc.nextInt();
		System.out.println("enter"+size+"numbers");
		int a[]=new int[size];
		for (int i=0;i<size;i++) {
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if(a[i]*a[i+1]>product) {
					n1=a[i];
					n2=a[i+1];
					product=a[i]*a[i+1];
				}
			}
		}
		System.out.println("the maximum product is:"+n1+","+ n2);
		System.out.println("the maximum product of two numbers are:"+product);
	    int  maximumProduct1=sc.nextInt();

	}

}
