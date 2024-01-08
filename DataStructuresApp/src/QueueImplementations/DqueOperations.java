package QueueImplementations;

import java.util.Scanner;

public class DqueOperations {
	static int n;
	static int front=-1;
	static int rear=-1;
	static int[] dQue;
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter queue size:");
		n=input.nextInt();
		dQue=new int[n];
		System.out.println("DQue Operations....");
		while(true) {
			System.out.println("1.EnqueueAtFront");
			System.out.println("2.EnqueueAtRear");
			System.out.println("3.DequeueFromFront");
			System.out.println("4.DequeueFromRear");
			System.out.println("5.Display");
			System.out.println("6.GetFront");
			System.out.println("7.GetRear");
			System.out.println("8.Exit");
			System.out.println("Enter the choice");
			int ch=input.nextInt();
			int data;
			switch(ch){
			case 1:
				System.out.print("Enter the data");
				data=input.nextInt();
				enqueueAtFront(data);
				break;
			case 2:
				System.out.print("Enter the data");
				data=input.nextInt();
				enqueueAtRear(data);
				break;
			case 3:
				dequeueFromFront();
				break;
			case 4:
				dequeueFromRear();
				break;
			case 5:
				display();
				break;
			case 6:
				getFront();
				break;
			case 7:
				getRear();
				break;
			case 8:
				System.exit(1);
			default:
				System.out.println("Invalide choice");
				
			}
		}

	}
	private static void enqueueAtFront(int data) {
		if((rear+1)%n==front) {
			System.out.println("Deque is full...");
		}else if(front==-1 && rear==-1) {
			front=rear=0;
			dQue[front]=data;
		}else if(front==0) {
			front=n-1;
			dQue[front]=data;
		}else {
			front--;
			dQue[front]=data;
		}
		
	}
	private static void enqueueAtRear(int data) {
		if((rear+1)%n==front) {
			System.out.println("Deque is full...");
		}else if(front==-1 && rear==-1) {
			front=rear=0;
			dQue[rear]=data;
		}else if(rear==n-1) {
			rear=0;
			dQue[rear]=data;
		}else {
			rear++;
			dQue[rear]=data;
		}
		
	}
	private static void dequeueFromFront() {
		if(front==-1 && rear==-1) {
			System.out.println("DQue is Empty");
		}else if(front==rear) {
			System.out.println("Dequeue ele is:"+dQue[front]);
			front=rear=-1;
		}else if(front==n-1) {
			System.out.println("Dequeue ele is:"+dQue[front]);
			front=0;
		}else {
			System.out.println("Dequeue ele is:"+dQue[front]);
			front++;
		}
		
	}
	private static void dequeueFromRear() {
		if(front==-1 && rear==-1) {
			System.out.println("DQue is Empty");
		}else if(front==rear) {
			System.out.println("Dequeue ele is:"+dQue[rear]);
			front=rear=-1;
		}else if(rear==0) {
			System.out.println("Dequeue ele is:"+dQue[rear]);
			rear=n-1;
		}else {
			System.out.println("Dequeue ele is:"+dQue[rear]);
			rear--;
		}
	}
	private static void display() {
		int i;
		if(front==-1 && rear==-1) {
			System.out.println("DQue is Empty");
		}else {
			i=front;
			while(i!=rear) {
				System.out.println(dQue[i]);
				i=(i+1)%n;
			}
			System.out.println(dQue[i]);
		}
		
	}
	private static void getFront() {
		if(front==-1 && rear==-1) {
			System.out.println("DQue is Empty");
		}else {
			System.out.println(dQue[front]);
		}
		
	}
	private static void getRear() {
		if(front==-1 && rear==-1) {
			System.out.println("DQue is Empty");
		}else {
			System.out.println(dQue[rear]);
		}
	}



}
