package com.divs.StackImplementations;

import java.util.Scanner;

public class StackImplUsingArray {
	static int top = -1;
	static int stack[]=new int[5];
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
			switch(choice) {
			case 1: Push();
			        break;
			case 2: Pop();
	                break;
			case 3: Peek();
	                break;
			case 4: Display();
	                break;
	                default:System.out.println("Invalid choice");
			}

		} while (choice != 0);

	}

	private static void Display() {
		System.out.println("Stack elements are:");
		for(int i=top;i>=0;i--) {
			System.out.println(stack[i]);
		}
	}

	private static void Peek() {
		if(top==-1) {
			System.out.println("Stack is underflow..");
		}else {
			System.out.println("Top element in stack is "+stack[top]);
		}
		
	}

	private static void Pop() {
		int item;
		if(top==-1) {
			System.out.println("Stack is underflow..");
		}else {
			item=stack[top];
			System.out.println("Pop item is :"+item);
			top--;
		}
		
	}

	private static void Push() {
		if(top==stack.length-1) {
			System.out.println("Stack is overflow...");
		}else {
			System.out.println("Enter the element to push");
			int ele=sc.nextInt();
			top++;
			stack[top]=ele;
		}
		
	}

}
