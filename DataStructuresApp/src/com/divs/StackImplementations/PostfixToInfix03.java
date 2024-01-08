package com.divs.StackImplementations;

import java.util.Stack;

public class PostfixToInfix03 {

	public static void main(String[] args) {
		//String str="ab+ef/*";
		//String str="abc++";
		//String str="ab*c+";
		String str="a";
		System.out.println("Postfix exp is:"+str);
		System.out.println("Infix exp is:"+postfixToInfix(str));
	}


	private static String postfixToInfix(String str) {
		Stack<String> stack=new Stack<String>();
		for(int i=0;i<str.length();i++) {
			if(isOperand(str.charAt(i))) {
				stack.push(str.charAt(i)+"");
			}else {
				if(!stack.isEmpty()) {
					String op1=stack.peek();
					stack.pop();
					String op2=stack.peek();
					stack.pop();
					stack.push("("+op2+str.charAt(i)+op1+")");
				}
			}
		
	}
		return stack.peek();



}


	private static boolean isOperand(char x) {
		return ((x>='a' && x<='z')||(x>='A' && x<='Z'));
	}
}