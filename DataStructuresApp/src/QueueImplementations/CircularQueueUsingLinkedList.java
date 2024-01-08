package QueueImplementations;

import java.util.Scanner;

class Node1 {
	int data;
	Node1 next;

	Node1(int data, Node1 next) {
		this.data = data;
		this.next = next;
	}
}

public class CircularQueueUsingLinkedList {
	static Node1 front = null;
	static Node1 rear = null;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Circular Queue Impl using LinkedList...");
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
		int data = input.nextInt();
		Node1 newnode;
		newnode = new Node1(data, null);
		if (front == null && rear == null) {
			front = rear = newnode;
			rear.next = front;
		} else {
			rear.next = newnode;
			rear = newnode;
			rear.next = front;
		}
	}

	private static void dequeue() {
		if (front == null && rear == null) {
			System.out.println("Queue is Empty");
		} else if(front==rear) {
			System.out.println("Dequeue ele is:"+front.data);
			front=null;
			rear=null;
		}
		else {
			System.out.println("Dequeue ele is:" + front.data);
			front = front.next;
			rear.next = front;
		}
	}

	private static void peek() {
		if (front == null && rear == null) {
			System.out.println("Queue is Empty");
		} else {
			System.out.println(front.data);
		}
	}

	private static void display() {
		Node1 temp;
		if (front == null && rear == null) {
			System.out.println("Queue is Empty");
		} else {
			temp = front;
			while (temp.next != front) {
				System.out.println(temp.data);
				temp = temp.next;
			}
			System.out.println(temp.data);
		}
	}

}
