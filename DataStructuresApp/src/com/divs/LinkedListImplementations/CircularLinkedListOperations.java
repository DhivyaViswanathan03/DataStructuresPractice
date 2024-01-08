package com.divs.LinkedListImplementations;

import java.util.Scanner;

class Node2 {
	int data;
	Node2 next;

	Node2(int data, Node2 next) {
		this.data = data;
		this.next = next;
	}
}

public class CircularLinkedListOperations {
	static Node2 head, tail=null, temp=null;
	static Scanner sc = new Scanner(System.in);
	static int count = 0;

	public static void main(String[] args) {
		int ch,length=0;
		while (true) {
			System.out.println("1.Append");
			System.out.println("2.MaintainHeadAndTail");
			System.out.println("3.MaintainOnlyTail");
			System.out.println("4.InsertAtBeginning");
			System.out.println("5.InsertAtEnd");
			System.out.println("6.InsertAtPosition");
			System.out.println("7.InsertAfterGivenPosition");
			System.out.println("8.DeleteAtBeginning");
			System.out.println("9.DeleteAtEnd");
			System.out.println("10.DeleteAtGivenPos");
			System.out.println("11.Length");
			System.out.println("12.Reverse");
			System.out.println("13.Display");
			System.out.println("14.Quit");
			System.out.print("Enter the choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				append();
				break;
			case 2:
				maintainHeadAndTail();
				break;
			case 3:
				maintainOnlyTail();
				break;
			case 4:
				insertAtBeginning();
				break;
			case 5:
				insertAtEnd();
				break;
			case 6:
				insertAtPostion();
				break;
			case 7:
				insertAfterGivenPostion();
				break;
			case 8:
				deleteAtBeginning();
				break;
			case 9:
				deleteAtEnd();
				break;
			case 10:
				deleteAtGivenPos();
				break;
			case 11:
				length=getLength();
				System.out.println("Node length is :"+length);
				break;
			case 12:
				reverseList();
				break;
			case 13:
				//display();
				displayIfOnlyTail();
				break;
			case 14:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice \n");
			}
		}
	}

	private static void append() {
		Node2 newnode;
		System.out.println("Enter data");
		int data=sc.nextInt();
		newnode=new Node2(data,null);
		if(head==null) {
			temp=head=newnode;
		}else {
			temp.next=newnode;
			temp=newnode;
			
		}
		temp.next=head;

		
	}

	private static void maintainHeadAndTail() {
		Node2 newnode;
		System.out.println("Enter data");
		int data=sc.nextInt();
		newnode=new Node2(data,null);
		if(head==null) {
			head=tail=newnode;
			tail.next=head;
		}else {
			tail.next=newnode;
			tail=newnode;
			tail.next=head;
		}
		System.out.println("Tail next is:"+tail.next.data);
		System.out.println("Head data is:"+head.data);

	}
	

	private static void maintainOnlyTail() {
		Node2 newnode;
		System.out.println("Enter data");
		int data=sc.nextInt();
		newnode=new Node2(data,null);
		if(tail==null) {
			tail=newnode;
			tail.next=newnode;
		}else {
			newnode.next=tail.next;
			tail.next=newnode;
			tail=newnode;
		}
		System.out.println("Tail next is:"+tail.next.data);

	}


	private static void insertAtBeginning() {
		Node2 newnode;
		System.out.println("Enter the data:");
		int data=sc.nextInt();
		newnode=new Node2(data,null);
		if(tail==null) {
			tail=newnode;
			tail.next=newnode;
		}else {
			newnode.next=tail.next;
			tail.next=newnode;
		}
		System.out.println("The first Node data is:"+tail.next.data);
		
	}

	private static void insertAtEnd() {
		Node2 newnode;
		System.out.println("Enter the data:");
		int data=sc.nextInt();
		newnode=new Node2(data,null);
		if(tail==null) {
			tail=newnode;
			tail.next=newnode;
		}else {
			newnode.next=tail.next;
			tail.next=newnode;
			tail=newnode;
		}
		System.out.println("The first Node data is:"+tail.next.data);
	}

	private static void insertAtPostion() {
		int pos,i=1;
		Node2 temp,newnode;
		System.out.println("Enter the position");
		pos=sc.nextInt();
		if(pos<0 || pos>getLength()) {
			System.out.println("Invalid position..");
		}else if(pos==1) {
			insertAtBeginning();
		}else if(pos==getLength()+1) {
			insertAtEnd();
		}else {
			System.out.println("Enter the data");
			int data=sc.nextInt();
			newnode=new Node2(data,null);
			if(tail==null) {
				System.out.println("Node node in the list");
			}else {
				temp=tail.next;
				while(i<pos-1) {
					temp=temp.next;
					i++;
				}
				newnode.next=temp.next;
				temp.next=newnode;
			}
		}
		
	}

	private static void insertAfterGivenPostion() {
		
	}

	private static void deleteAtBeginning() {
		Node2 temp=null;
		if(tail==null) {
			System.out.println("No node in the list");
		}else if(tail.next==tail) {
			tail=null;
		}else {
			temp=tail.next;
			tail.next=temp.next;
		    temp.next=null;
		}
		
	}

	private static void deleteAtEnd() {
		Node2 temp=null,nextnode;
		if(tail==null) {
			System.out.println("No node in the list");
		}else if(tail.next==tail) {
			tail=null;
		}else {
			temp=tail.next;
			while(temp.next!=tail) {
				temp=temp.next;
			}
			nextnode=temp.next;
			temp.next=tail.next;
			tail=temp;
			nextnode.next=null;
		}

	}

	private static void deleteAtGivenPos() {
		Node2 temp,previous = null;
		int i=1,pos;
		System.out.println("Enter position");
		pos=sc.nextInt();
		if(pos<0 || pos>getLength()) {
			System.out.println("Invalid position");
		}else if(pos==1) {
			deleteAtBeginning();
		}else if(pos==getLength()) {
			deleteAtEnd();
		}else {
			temp=tail.next;
			while(i<pos) {
				previous=temp;
				temp=temp.next;
				i++;
			}
			previous.next=temp.next;
			temp.next=null;
		}

	}

	private static int getLength() {
		int counter = 0;
		Node2 temp=null;
		if(tail==null) {
			return 0;
		}else {
			temp=tail.next;
			while(temp.next!=tail.next) {
				temp=temp.next;
				counter++;
			}
			counter++;
		}
		return counter;
	}

	private static void reverseList() {
		Node2 current,prevnode,nextnode;
		if(tail==null) {
			System.out.println("No node in the list");
		}else if(tail.next==tail) {
			System.out.println(tail.data);
		}else {
			current=tail.next;
			nextnode=current.next;
			while(current!=tail) {
				prevnode=current;
				current=nextnode;
				nextnode=current.next;
				current.next=prevnode;
			}
			nextnode.next=tail;
			tail=nextnode;
		}

	}

	private static void display() {
		Node2 temp=null;
		if(head==null) {
			System.out.println("No node in the list");
		}else {
			temp=head;
			while(temp.next!=head) {
				System.out.println(temp.data);
				temp=temp.next;
			}
			System.out.println(temp.data);
		}
	}
		
		private static void displayIfOnlyTail() {
			Node2 temp=null;
			if(tail==null) {
				System.out.println("No node in the list");
			}else if(tail.next==tail){
				System.out.println(tail.data);
			}else {
				temp=tail.next;
				while(temp.next.data!=tail.next.data) {
					System.out.println(temp.data);
					temp=temp.next;	
				}
				System.out.println(temp.data);
			}

           }
}
