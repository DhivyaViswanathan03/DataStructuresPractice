package com.divs.QueueImplementations;

import java.util.Scanner;

public class QueueEnQueueDeQueue {
	static int n;
	static int front=-1;
	static int rear=-1;
	static int[] queue;
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter queue size:");
		n=input.nextInt();
		queue=new int[n];
		while(true) {
			System.out.println("1.Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.Display");
			System.out.println("4.Peek");
			System.out.println("5.Exit");
			System.out.println("Enter the choice");
			int ch=input.nextInt();
			switch(ch){
			case 1:
				System.out.print("Enter the data");
				int data=input.nextInt();
				enqueue(data);
				break;
			case 2:
				dequeue();
				break;
			case 3:
				display();
				break;
			case 4:
				peek();
				break;
			case 5:
				System.exit(1);
			default:
				System.out.println("Invalide choice");
				
			}
		}

	}
	private static void enqueue(int data) {
		try {
			if(rear==n-1) {
				System.out.println("Queue is full");
			}else if(front==-1 && rear==-1) {
				front=rear=0;
				queue[rear]=data;
			}
			else {
				rear++;
				queue[rear]=data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void dequeue() {
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty");
		}else if(front==rear) {
			System.out.println("Dequeue ele is:"+queue[front]);
			front=rear=-1;
		}else {
			System.out.println("Dequeue ele is:"+queue[front]);
			front++;
		}
	}

	private static void peek() {
		if(front==-1 && rear==-1) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println("Front ele is :"+queue[front]);
		}
	}

	private static void display() {
		int i;
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty");
		}else {
			for(i=front;i<rear+1;i++ ) {
				System.out.println("Data is:"+queue[i]);
			}
		}
	}


}
