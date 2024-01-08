package com.divs.StackImplementations;

import java.util.Stack;

public class InfixToPrefix02 {

	public static void main(String[] args) {
		//String str="a+b*(c^d-e)^(f+g*h)-i";
		//String str="A+B*C+D";
		String str="K+L-M*N+(O^P)*W|U|V*T+Q";
		System.out.println(reverseString(str));
		String result=infixToPrefix(reverseString(str));
		System.out.println(result);
		System.out.println("Prefix Expression is:"+reverseString(result));

	}

	private static String reverseString(String str) {
		String s="";
		for(int i=str.length()-1;i>=0;i--) {
			s=s+str.charAt(i);
		}
		return s;
		
	}

	private static String infixToPrefix(String str) {
		Stack<Character> stack=new Stack<Character>();
		String result="";
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				result=result+c;
			}else if(c==')') {
				stack.push(c);
			}else if(c=='(') {
				while(!stack.isEmpty() && stack.peek()!=')') {
					result=result+stack.peek();
					stack.pop();
				}
				stack.pop();
			}else {
				while(!stack.isEmpty()&& prec(c)<prec(stack.peek())) {
					result=result+stack.peek();
					stack.pop();
				}
				if(!stack.isEmpty() && prec(c)==prec(stack.peek())) {
					stack.push(c);
				}else {
					stack.push(c);
				}
				
			}
			
		}
		while(!stack.isEmpty()) {
			if(stack.peek()==')')
				return "Invalid expression";
			result=result+stack.peek();
			stack.pop();
		}
		return result;
		
	}

	private static int prec(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '|':
			return 2;
		case '^':
			return 3;
			}
		return -1;
	}

}
