package com.gradedLab3.prob1;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public boolean isBalanced(String exp) {

		Stack<Character> bStack = new Stack<Character>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				bStack.push(ch);
				continue;
			}

//			System.out.println("top ->" + bStack.peek());

			if (ch == ')') {
				if (!bStack.isEmpty() && bStack.peek() == '(') {
					bStack.pop();
				} else {
					return false;
				}
			} else if (!bStack.isEmpty() && ch == '}') {
				if (bStack.peek() == '{') {
					bStack.pop();
				} else {
					return false;
				}
			} else if (!bStack.isEmpty() && ch == ']') {
				if (bStack.peek() == '[') {
					bStack.pop();
				} else {
					return false;
				}
			}

//			System.out.println("top ->" + bStack.peek());

		}

		if (bStack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println("\n\nWelcome to Brackets Balancing Checker-------------");
		BalancedBrackets bb = new BalancedBrackets();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the expression : ");
		String exp = in.nextLine();
		boolean isBalanced = bb.isBalanced(exp);

		if (isBalanced) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		
		in.close();
	}

}
