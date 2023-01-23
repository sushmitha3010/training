package com.chsinsys.day20;

import java.util.PriorityQueue;

public class QueueExample {

	public static void main(String[] args) {
	PriorityQueue pq=new PriorityQueue();
		pq.add(3);
		pq.add(10);
		pq.add(7);
		System.out.println(pq);
		Boolean contains=pq.contains(3);
		Boolean contains1=pq.contains(10);
		System.out.println(contains);
		System.out.println(contains1);
		pq.offer(15);
		System.out.println(pq.peek());
		
		
		

	}

}
