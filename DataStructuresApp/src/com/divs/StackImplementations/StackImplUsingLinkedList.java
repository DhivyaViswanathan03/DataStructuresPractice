package com.divs.StackImplementations;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class StackImplUsingLinkedList {
	static Node top = null;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("1.Push");
			System.out.println("2.Pop");
			System.out.println("3.Peek");
			System.out.println("4.Display");
			System.out.println("Enter Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the no of data u want to push");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					System.out.println("Enter the data");
					int data = sc.nextInt();
					Push(data);
				}

				break;
			case 2:
				Pop();
				break;
			case 3:
				Peek();
				break;
			case 4:
				Display();
				break;
			default:
				System.out.println("Invalid choice");
			}

		} while (choice != 0);

	}

	private static void Display() {
		Node temp;
		if (top == null) {
			System.out.println("No node in the list");
		} else {
			temp = top;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}

	}

	private static void Peek() {
		if(top==null) {
			System.out.println("No node in the list");
		}else {
		System.out.println(top.data);
		}
	}

	private static void Pop() {
		Node temp;
		if(top==null) {
			System.out.println("No node in the list");
		}else {
			temp=top;
			top=temp.next;
			temp=null;
		}

	}

	private static void Push(int data) {
		Node newnode;
		newnode = new Node(data, null);
		newnode.next = top;
		top = newnode;
	}

}
