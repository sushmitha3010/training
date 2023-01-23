package com.p.task;

import java.util.Scanner;

public class FascinatingNumber {
	public static void main(String[] args) {
		int n,a,b;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any number");
		n=sc.nextInt();
		a=n*2;
		b=n*3;
		String concatstr=n+""+a+b;
		boolean found=true;
		for(char c='1';c<='9';c++) {
			int count=0;
			for(int i=0;i<concatstr.length();i++) {
				char ch=concatstr.charAt(i);
				if(ch == c)
					count++;
			}
			if(count>1 || count == 0) {
				found=false;
				break;
			}
		}
		if(found) {
			System.out.println(n+"is a fascinating number");
		}else {
			System.out.println(n+"is not a fascinating number");
		}
	}

}
