package StackImplementations;

import java.util.Stack;

public class PrefixToInfix04 {

	public static void main(String[] args) {
		//String str="ab+ef/*";
		//String str="abc++";
		//String str="ab*c+";
		String str="*+ab|ef";
		String s=reverseString(str);
		System.out.println("Prefix exp is:"+s);
		System.out.println("Infix exp is:"+prefixToInfix(s));
	}
	private static String reverseString(String str) {
		String s="";
		for(int i=str.length()-1;i>=0;i--) {
			s=s+str.charAt(i);
		}
		return s;
		
	}

	private static String prefixToInfix(String str) {
		Stack<String> stack=new Stack<String>();
		for(int i=0;i<str.length();i++) {
			if(isOperand(str.charAt(i))) {
				stack.push(str.charAt(i)+"");
			}else {
				if(!stack.isEmpty()) {
					String op2=stack.peek();
					stack.pop();
					String op1=stack.peek();
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