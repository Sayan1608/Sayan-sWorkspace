package com.dsa.stacks;

public class StackImplementationUsingArray {

	int[] stack;
	int maxsize;
	int top;

	public StackImplementationUsingArray(int maxsize) {

		this.maxsize = maxsize;
		stack = new int[this.maxsize];
		top = -1;

	}

	public boolean isFull() {
		if (top == maxsize - 1) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {

		if (top == -1) {
			return true;
		}
		return false;
	}

	public void push(int data) {
		if (isFull()) {
			System.out.println("Stack Overflow.");
		} else {

			stack[++top] = data;
			System.out.println(stack[top] + " inserted.");
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("No elements to Peek.");
			return -1;
		}

		return stack[top];

	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow.");
		} else {

			int x = stack[top--];

			System.out.println(x + " removed.");
		}
	}
	
	public void displayStack() {
		System.out.println("Array Elements are :: ");
		
		for(int i=top; i>=0;i--) {
			System.out.print(stack[i] + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		
		StackImplementationUsingArray stack1 = new StackImplementationUsingArray(5);
		
		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		stack1.push(40);
		stack1.push(50);
		stack1.push(60);
		
		stack1.displayStack();
		
		System.out.println(stack1.peek());
		
		stack1.pop();
		stack1.pop();
		stack1.pop();
		
		stack1.displayStack();
		
		stack1.pop();
		stack1.pop();
		stack1.pop();
		
		stack1.displayStack();
		
	}

}
