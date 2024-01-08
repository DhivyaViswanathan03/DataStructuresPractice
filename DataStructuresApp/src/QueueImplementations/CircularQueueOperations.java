package QueueImplementations;

import java.util.Scanner;

public class CircularQueueOperations {
	static int n;
	static int front=-1;
	static int rear=-1;
	static int[] cQueue;
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter queue size:");
		n=input.nextInt();
		cQueue=new int[n];
		System.out.println("Circular Queue Operations....");
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
		if(front==-1 && rear==-1) {
			front=rear=0;
			cQueue[rear]=data;
		}else if((rear+1)%n==front) {
			System.out.println("Circular queue is full");
		}else {
			rear=(rear+1)%n;
			cQueue[rear]=data;
		}
	}
	
	private static void dequeue() {
		if(front==-1 && rear==-1) {
			System.out.println("Circular queue is empty");
		}else if(front==rear) {
			front=rear=-1;
		}else {
			System.out.println(cQueue[front]);
			front=(front+1)%n;
			
		}
	}

	private static void peek() {
		if(front==-1 && rear==-1) {
			System.out.println("Circular queue is empty");
		}else {
			System.out.println(cQueue[front]);
		}
	}

	private static void display() {
		int i=front;
		if(front==-1 && rear==-1) {
			System.out.println("Circular queue is empty");
		}else {
			while(i!=rear) {
				System.out.println(cQueue[i]);
				i=(i+1)%n;
			}
			System.out.println(cQueue[i]);
		}
	}


}
