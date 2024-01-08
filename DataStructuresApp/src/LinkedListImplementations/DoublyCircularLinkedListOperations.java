package LinkedListImplementations;

import java.util.Scanner;

class Node3 {
	int data;
	Node3 next;
	Node3 prev;

	Node3(int data, Node3 next,Node3 prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}

public class DoublyCircularLinkedListOperations {
	static Node3 head, tail, temp;
	static Scanner sc = new Scanner(System.in);
	

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
				display();
				//displayIfOnlyTail();
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
		

		
	}

	private static void maintainHeadAndTail() {
		Node3 newnode;
		System.out.println("Enter data");
		int data=sc.nextInt();
		newnode=new Node3(data,null,null);
		if(tail==null) {
			head=tail=newnode;
			newnode.next=head;
			newnode.prev=tail;
			
		}else {
			tail.next=newnode;
			newnode.prev=tail;
			newnode.next=head;
			head.prev=newnode;
			tail=newnode;
		}

	}
	

	private static void maintainOnlyTail() {
		

	}


	private static void insertAtBeginning() {
		Node3 newnode;
		System.out.println("Enter data");
		int data=sc.nextInt();
		newnode=new Node3(data,null,null);
		if(head==null) {
			head=tail=newnode;
			newnode.next=head;
			newnode.prev=tail;
		}else {
			newnode.next=head;
			newnode.prev=tail;
			head.prev=newnode;
			head=newnode;
			tail.next=newnode;
		}
	}

	private static void insertAtEnd() {
		Node3 newnode;
		System.out.println("Enter data");
		int data=sc.nextInt();
		newnode=new Node3(data,null,null);
		if(head==null) {
			head=tail=newnode;
			newnode.next=head;
			newnode.prev=tail;
		}else {
			newnode.next=tail.next;
			newnode.prev=tail;
			tail.next=newnode;
			tail=newnode;
			head.prev=tail;
		}
	}

	private static void insertAtPostion() {
		int pos,i=1;
		Node3 newnode;
		System.out.println("Enter position");
		pos=sc.nextInt();
		System.out.print("Length of the node is:"+getLength());
		System.out.println();
		if(pos<0 || pos>getLength()) {
			System.out.println("Invalid position");
		}else if(pos==1) {
			insertAtBeginning();
		}else if(pos==getLength()) {
			insertAtEnd();
		}else {
			System.out.println("Enter data");
			int data =sc.nextInt();
			newnode=new Node3(data, null, null);
			temp=tail.next;
			while(i<pos-1) {
				temp=temp.next;
				i++;
			}
			newnode.next=temp.next;
			temp.next=newnode;
			newnode.prev=temp;
			newnode.next.prev=newnode;	
		}
		
		
	}

	private static void insertAfterGivenPostion() {
		
	}

	private static void deleteAtBeginning() {
		Node3 temp;
		if(head==null) {
			System.out.println("No node in the list");
		}else if(head.next==head) {
			head=null;
			tail=null;	
		}else {
			temp=head;
			head=temp.next;
			head.prev=tail;
			tail.next=head;
			temp.next=null;
			temp.prev=null;
		}
		
		
	}

	private static void deleteAtEnd() {
		Node3 temp;
		if(head==null) {
			System.out.println("No node in the list");
		}else if(head.next==head) {
			head=null;
			tail=null;	
		}else {
			temp=tail;
			temp.prev.next=head;
			head.prev=temp.prev;
			tail=temp.prev;
			temp.next=null;
			temp.prev=null;
		}

	}

	private static void deleteAtGivenPos() {
		int pos,i=1;
		Node3 temp;
		System.out.println("Enter pos");
		pos=sc.nextInt();
		if(pos<0 || pos>getLength()) {
			System.out.println("Invalid position");
		}else if(pos==1) {
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
			temp.next=null;
			temp.prev=null;
		}
	}

	private static int getLength() {
		Node3 temp;
		int counter=0;
		if(tail==null) {
			System.out.println("No node in the list");
		}else {
			temp=tail.next;
			while(temp.next!=head) {
				counter++;
				temp=temp.next;
			}
			counter++;
		}
		return counter;
		
	}
		
	

	private static void reverseList() {
		
	}

	private static void display() {
	Node3 temp;
	if(tail==null) {
		System.out.println("No node in the list");
	}else {
		temp=tail.next;
		while(temp.next!=head) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
	}
		
		private static void displayIfOnlyTail() {
			
}
}
