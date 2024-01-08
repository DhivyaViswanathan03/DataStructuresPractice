package com.divs.LinkedListImplementations;

import java.util.Scanner;

class Node1 {
	int data;
	Node1 next;
	Node1 prev;

	Node1(int data, Node1 next, Node1 prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}

public class DoublyLinkedListOperations {
	static Node1 head, tail, temp;
	static Scanner sc = new Scanner(System.in);
	static int count = 0;

	public static void main(String[] args) {
		int ch;
		while (true) {
			System.out.println("1.Append");
			System.out.println("2.MaintainTail");
			System.out.println("3.InsertAtBeginning");
			System.out.println("4.InsertAtEnd");
			System.out.println("5.InsertAtPosition");
			System.out.println("6.InsertAfterGivenPosition");
			System.out.println("7.DeleteAtBeginning");
			System.out.println("8.DeleteAtEnd");
			System.out.println("9.DeleteAtGivenPos");
			System.out.println("10.Length");
			System.out.println("11.Reverse");
			System.out.println("12.Display");
			System.out.println("13.Quit");
			System.out.print("Enter the choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				append();
				break;
			case 2:
				maintainTail();
				break;
			case 3:
				insertAtBeginning();
				break;
			case 4:
				insertAtEnd();
				break;
			case 5:
				insertAtPostion();
				break;
			case 6:
				insertAfterGivenPostion();
				break;
			case 7:
				deleteAtBeginning();
				break;
			case 8:
				deleteAtEnd();
				break;
			case 9:
				deleteAtGivenPos();
				break;
			case 10:
				getLength();
				break;
			case 11:
				reverseList();
				break;
			case 12:
				display();
				break;
			case 13:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice \n");
			}
		}
	}

	private static void append() {
		Node1 newnode;
		System.out.println("Enter the data");
		int data = sc.nextInt();
		newnode = new Node1(data, null, null);
		if (head == null) {
			head = temp = newnode;
		} else {
			temp.next = newnode;
			newnode.prev = temp;
			temp = newnode;
		}
	}

	private static void maintainTail() {
		Node1 newnode;
		System.out.println("Enter the data");
		int data = sc.nextInt();
		newnode = new Node1(data, null, null);
		if (head == null) {
			head = tail = newnode;
		} else {
			tail.next = newnode;
			newnode.prev = tail;
			tail = newnode;
		}

	}

	private static void insertAtBeginning() {
		Node1 newnode;
		System.out.println("Enter the data");
		int data = sc.nextInt();
		newnode = new Node1(data, null, null);
		if (head == null) {
			head = tail = newnode;
		} else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
	}

	private static void insertAtEnd() {
		Node1 newnode;
		System.out.println("Enter the data");
		int data = sc.nextInt();
		newnode = new Node1(data, null, null);
		tail.next = newnode;
		newnode.prev = tail;
		tail = newnode;
	}

	private static void insertAtPostion() {
		Node1 newnode;
		int i=1;
		System.out.println("Enter the position");
		int pos=sc.nextInt();
		if(pos<1 && pos>getLength()) {
			System.out.println("Invalid position");	
		}else if(pos==1) {
			insertAtBeginning();
		}else {
			temp=head;
			while(i<pos-1) {
				temp=temp.next;
				i++;
			}
			System.out.println("Enter the data");
			int data = sc.nextInt();
			newnode = new Node1(data, null, null);
			newnode.next=temp.next;
			newnode.prev=temp;
			temp.next=newnode;
			newnode.next.prev=newnode;
		}
	}

	private static void insertAfterGivenPostion() {
		Node1 newnode;
		int i=1;
		System.out.println("Enter the position");
		int pos=sc.nextInt();
		if(pos<1 && pos>getLength()) {
			System.out.println("Invalid position");	
		}else if(pos==getLength()){
			insertAtEnd();
		}
		else {
			temp=head;
			while(i<pos) {
				temp=temp.next;
				i++;
			}
			System.out.println("Enter the data");
			int data = sc.nextInt();
			newnode = new Node1(data, null, null);
			newnode.next=temp.next;
			newnode.prev=temp;
			temp.next=newnode;
			newnode.next.prev=newnode;

		}
	}

	private static void deleteAtBeginning() {
		Node1 temp;
		if(head==null) {
			System.out.println("There s node in the list");
		}else {
			temp=head;
			head=temp.next;
			head.prev=null;
			temp.next=null;
			
		}

	}

	private static void deleteAtEnd() {
		Node1 temp;
		if(tail==null) {
			System.out.println("No node in the list");
		}else {
			temp=tail;
			tail=temp.prev;
			tail.next=null;
			temp.prev=null;
		}

	}

	private static void deleteAtGivenPos() {
		Node1 temp;
		int i=1;
		System.out.println("Enter the pos");
		int pos=sc.nextInt();
		if(pos==1) {
			deleteAtBeginning();
		}else if(pos==getLength()) {
			deleteAtEnd();
		}else {
			temp=head;
			while(i<pos) {
				temp=temp.next;
				i++;
			}
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
		}

	}

	private static int getLength() {
		Node1 temp;
		temp = head;
		int counter = 0;
		if (head == null) {
			System.out.println("No node in the List");
		} else {
			while (temp != null) {
				temp = temp.next;
				counter++;
			}
		}
		return counter;
	}

	private static void reverseList() {
		Node1 currentNode,nextNode;
		currentNode=nextNode=head;
		if(head==null) {
			System.out.println("No node in the list");
		}else {
			while(nextNode!=null) {
				nextNode=nextNode.next;
				currentNode.next=currentNode.prev;
				currentNode.prev=nextNode;
				currentNode=nextNode;
			}
			System.out.println("Before swapping");
			System.out.println("Head value is :" +head.data);
			System.out.println("Tail value is :" +tail.data);
			currentNode=head;
			head=tail;
			tail=currentNode;
			System.out.println("After swapping");
			System.out.println("Head value is :" +head.data);
			System.out.println("Tail value is :" +tail.data);
		}
	}

	private static void display() {
		Node1 temp = null;
		if (head == null) {
			System.out.println("No node in the list");
		} else {
			temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
}
