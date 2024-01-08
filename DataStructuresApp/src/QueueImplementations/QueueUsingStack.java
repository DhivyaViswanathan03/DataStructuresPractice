package QueueImplementations;

import java.util.Scanner;

public class QueueUsingStack {
	static int n;
	static int top1 = -1;
	static int top2 = -1;
	static int[] stack1;
	static int[] stack2;
	static int count = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter queue size:");
		n = input.nextInt();
		stack1 = new int[n];
		stack2 = new int[n];

		while (true) {
			System.out.println("1.Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.Display");
			System.out.println("4.Peek");
			System.out.println("5.Exit");
			System.out.println("Enter the choice");
			int ch = input.nextInt();
			switch (ch) {
			case 1:
				System.out.print("Enter the data");
				int data = input.nextInt();
				enqueue(data);
				break;
			case 2:
				dequeue();
				break;
			case 3:
				display();
				break;
			case 5:
				System.exit(1);
			default:
				System.out.println("Invalid choice");

			}
		}

	}

	private static void enqueue(int data) {
		push1(data);
		count++;

	}

	private static void push1(int data) {
		if (top1 == n - 1) {
			System.out.println("Stack is full");
		} else {
			top1++;
			stack1[top1] = data;

		}

	}

	private static void dequeue() {
		if (top1 == -1 && top2 == -1) {
			System.out.println("Stack is empty");
		} else {
			System.out.println("Count value is:" + count);
			for (int i = 0; i < count; i++) {
				int a = pop1();
				push2(a);
			}
			int b = pop2();
			System.out.println("Dequeue ele is:" + b);
			count--;
			for (int i = 0; i < count; i++) {
				b = pop2();
				push1(b);
			}
		}

	}

	private static int pop2() {
		return stack2[top2--];
	}

	private static void push2(int a) {
		if (top2 == n - 1) {
			System.out.println("Stack is full");
		} else {
			top2++;
			stack2[top2] = a;

		}
	}

	private static int pop1() {
		System.out.println("Top1 is:" + top1);
		return stack1[top1--];
	}

	private static void display() {
		if (top1 == -1 && top2 == -1) {
			System.out.println("Stack is empty");
		} else {
			for (int i = 0; i <= top1; i++) {
				System.out.println("Stack elements are:" + stack1[i]);
			}
		}
	}

}
