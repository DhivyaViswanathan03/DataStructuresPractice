package StackImplementations;

import java.util.Stack;

public class EvaluationOfPreix05 {

	public static void main(String[] args) {
		String str = "+ 9 * 12 6";
		//String str="- / * 20 * 50 + 3 6 300 2";
		System.out.println("Prefix exp is:" + str);
//		 System.out.println("Infix exp is:"+evaluationOfPrefixSingleDigit(str));
		System.out.println("final output is:" + evaluationOfPrefixDoubleDigit(str));
	}

	private static boolean isOperand(char c) {
		if (c >= 48 && c <= 57)
			return true;
		else
			return false;
	}

//This implementation works only for single digit operands
	private static Double evaluationOfPrefixSingleDigit(String str) {
		Stack<Double> stack = new Stack<Double>();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (isOperand(str.charAt(i))) {
				System.out.println(str.charAt(i));
				stack.push((double) str.charAt(i) - 48);
			} else {
				double op1 = stack.peek();
				System.out.println("Op1 is :" + op1);
				stack.pop();
				double op2 = stack.peek();
				System.out.println("Op2 is :" + op2);
				stack.pop();
				switch (str.charAt(i)) {
				case '+':
					stack.push(op1 + op2);
					break;
				case '-':
					stack.push(op1 - op2);
					break;
				case '*':
					stack.push(op1 * op2);
					break;
				case '/':
					stack.push(op1 / op2);
					break;
				case '^':
					stack.push(Math.pow(op1, op2));
					break;
				}
			}
		}

		return stack.peek();
	}

//Multi-digit operands can be implemented 
//if some character-like space is used to separate the operands and operators.
	private static Double evaluationOfPrefixDoubleDigit(String str) {
		Stack<Double> stack = new Stack<Double>();
		for (int i = str.length() - 1; i>= 0; i--) {
			char c=str.charAt(i);
			if (str.charAt(i) == ' ')
				continue;

			if (c == '*' || c == '/' || c == '^' || c == '+' || c == '-') {
				double op1 = stack.peek();
				stack.pop();
				double op2 = stack.peek();
				stack.pop();
				switch (c) {
				case '+':
					stack.push(op1 + op2);
					break;
				case '-':
					stack.push(op1 - op2);
					break;
				case '*':
					stack.push(op1 * op2);
					break;
				case '/':
					stack.push(op1 / op2);
					break;
				case '^':
					stack.push(Math.pow(op1, op2));
					break;
				}
			}else {
				StringBuffer temp=new StringBuffer();
				while(isOperand(c)) {
					temp.append(c);
					i--;
					c=str.charAt(i);
				}
				i++;
				double num = Double.parseDouble(temp.reverse().toString());
				stack.push(num);
				System.out.println(stack.peek());
			}
		}

		return stack.peek();
	}

}