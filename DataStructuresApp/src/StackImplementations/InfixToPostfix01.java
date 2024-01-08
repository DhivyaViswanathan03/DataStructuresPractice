package StackImplementations;

import java.util.Queue;
import java.util.Stack;

public class InfixToPostfix01 {

	public static void main(String[] args) {
		//String str="a+b*(c^d-e)^(f+g*h)-i";
		//String str="A+B*C+D";
		String str="((A+B)–C*(D/E))+F";
		System.out.println(infixToPostfix(str));

	}

	private static String infixToPostfix(String str) {
		Stack<Character> stack=new Stack<Character>();
		String result="";
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				result=result+c;
			}else if(c=='(') {
				stack.push(c);
			}else if(c==')') {
				while(!stack.isEmpty() && stack.peek()!='(') {
					result=result+stack.peek();
					stack.pop();
				}
				System.out.println("Result is:"+result);
				stack.pop();
			}else {
				while(!stack.isEmpty()&& stack.peek()!='('
						&& prec(c)<=prec(stack.peek())) {
					result=result+stack.peek();
					stack.pop();
				}
				stack.push(c);
			}
			
		}
		while(!stack.isEmpty()) {
			if(stack.peek()=='(')
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
		case '/':
			return 2;
		case '^':
			return 3;
			}
		return -1;
	}

}
