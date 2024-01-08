package QueueImplementations;

import java.util.Scanner;

class Node{
	int data;
	Node next;
	Node(int data,Node next){
		this.data=data;
		this.next=next;
	}
}

public class QueueUsingLinkedList {
	static Node front=null;
	static Node rear=null;
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Queue Impl using LinkedList...");
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
				enqueue();
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
	
	private static void enqueue() {
		System.out.print("Enter the data");
		int data=input.nextInt();
		Node newnode;
		newnode=new Node(data,null);
		if(front==null && rear==null) {
			front=rear=newnode;
		}else {
			rear.next=newnode;
			rear=newnode;
		}
	}
	
	private static void dequeue() {
		Node temp;
		if(front==null && rear==null) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println("Dequeue ele is:"+front.data);
			front=front.next;
			if(front==null)
			rear=null;
		}
	}

	private static void peek() {
		if(front==null && rear==null) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println(front.data);
		}
	}

	private static void display() {
		Node temp;
		if(front==null && rear==null) {
			System.out.println("Queue is Empty");
		}else {
			temp=front;
			while(temp!=null) {
				System.out.println(temp.data);
				temp=temp.next;
			}
		}
	}


}
