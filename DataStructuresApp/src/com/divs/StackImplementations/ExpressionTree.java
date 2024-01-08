package com.divs.StackImplementations;

import java.util.Stack;

class Node6{
	int data;
	Node6 left;
	Node6 right;
	
	Node6(int data,Node6 left,Node6 right){
		this.left=left;
		this.right=right;
		this.data=data;	
	}
	
	
}

public class ExpressionTree {

	public static void main(String[] args) {
		String postfix = "ABC*+D/";
		Node6 root=expressionTree(postfix);
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
	}

	private static void inOrder(Node6 root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print((char)root.data+" ");
			inOrder(root.right);
		}
		
	}
	
	private static void preOrder(Node6 root) {
		if(root!=null) {
			System.out.print((char)root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	
	private static void postOrder(Node6 root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print((char)root.data+" ");
			
		}
		
	}

	private static Node6 expressionTree(String postfix) {
		Node6 t1,t2,temp;
		Stack<Node6> stack=new Stack<Node6>();
		for(int i=0;i<postfix.length();i++) {
			if(!isOperator(postfix.charAt(i))){
				stack.push(new Node6(postfix.charAt(i),null,null));
			}else {
				temp=new Node6(postfix.charAt(i),null,null);
				temp.right=stack.pop();
				temp.left=stack.pop();
				stack.push(temp);
			}
		}
		
		return stack.pop();
	}

	private static boolean isOperator(char c) {
		if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^')
			return true;
		return false;
	}

}
