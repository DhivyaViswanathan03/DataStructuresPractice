package com.divs.LinkedListImplementations;

import java.util.Scanner;

class Node {
	int data;
	Node next;
	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class SinglyLinkedListOperations {
	static Node head ,temp= null;
	static Scanner sc = new Scanner(System.in);
	static int count=0;
	public static void main(String[] args) {
		int ch;
		while (true) {
			System.out.println("1.Append");
			System.out.println("2.InsertAtBeginning");
			System.out.println("3.InsertAtEnd");
			System.out.println("4.InsertAfterGivenPosition");
			System.out.println("5.DeleteAtBeginning");
			System.out.println("6.DeleteAtEnd");
			System.out.println("7.DeleteAtGivenPos");
			System.out.println("8.Length");
			System.out.println("9.Reverse");
			System.out.println("10.Display");
			System.out.println("11.Quit");
			System.out.print("Enter the choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				append();
				break;
			case 2:
				insertAtBeginning();
				break;
			case 3:
				insertAtEnd();
				break;
			case 4:
				insertAfterGivenPostion();
				break;
			case 5:
				deleteAtBeginning();
				break;
			case 6:
				deleteAtEnd();
				break;
			case 7:
				deleteAtGivenPos();
				break;
			case 8:
				getLength();
				break;
			case 9:
				reverseList();
				break;
			case 10:
				display();
				break;
			case 11:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice \n");
			}
		}
	}

	

	private static void append() {
		int ele;
		Node newnode;
		System.out.println("Enter the data");
		ele = sc.nextInt();
		newnode = new Node(ele, null);
		if (head == null) {
			head = temp = newnode;
		} else {
			temp.next = newnode;
			temp = newnode;
		}

	}
	
	private static void insertAtBeginning() {
		int ele;
		Node newnode;
		System.out.println("Enter the data");
		ele = sc.nextInt();
		newnode = new Node(ele, null);
		if (head == null) {
			head = temp = newnode;
		}else {
			newnode.next=head;
			head=newnode;
		}
		}
	
	private static void insertAtEnd() {
		int ele;
		Node newnode;
		System.out.println("Enter the data");
		ele = sc.nextInt();
		newnode = new Node(ele, null);
		temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newnode;
	}
	
	private static void insertAfterGivenPostion() {
		int ele;
		Node newnode;
		System.out.println("Length of the node is :"+count);
		System.out.println("Enter the position");
		int pos=sc.nextInt();
		int i=1;
		if(pos>count) {
			System.out.println("Invalid Position");
		}else {
			System.out.println("Enter the data");
			ele = sc.nextInt();
			newnode = new Node(ele, null);
			temp=head;
			while(i<pos) {
				temp=temp.next;
				i++;
			}
			newnode.next=temp.next;
			temp.next=newnode;
		}
	}
	
	private static void deleteAtBeginning() {
		if(head==null) {
			System.out.println("No node in the list for deletion");
		}else {
			temp=head;
			head=head.next;
		}
		
	}
	private static void deleteAtEnd() {
		Node prevNode=null;
		temp=head;
		while(temp.next!=null) {
			prevNode=temp;
			temp=temp.next;
		}
		if(head==temp) {
			head=null;
		}else {
			prevNode.next=null;
		}
	}
	
	private static void deleteAtGivenPos() {
		Node nextNode;
		System.out.println("Enter the pos");
		int pos=sc.nextInt();
		int i=1;
		if(pos>count) {
			System.out.println("Invalid position");
		}else {
			temp=head;
			while(i<pos-1) {
				temp=temp.next;
				i++;
			}
			nextNode=temp.next;
			temp.next=nextNode.next;
		}
	}

	private static void getLength() {
		Node temp;
		temp=head;
		int counter=0;
		if(head==null) {
			System.out.println("No node in the List");
		}else {
			while(temp!=null) {
				temp=temp.next;
				counter++;
			}
		}
		System.out.println("Node length is:"+counter);
	}
	
	private static void reverseList() {
		Node prevNode,nextNode,currentNode;
		nextNode=currentNode=head;
		prevNode=null;
		while(nextNode!=null) {
			nextNode=nextNode.next;
			currentNode.next=prevNode;
			prevNode=currentNode;
			currentNode=nextNode;
		}
		head=prevNode;
	}
	
	private static void display() {
		Node temp = null;
		temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
			count++;
		}
	}
}
