package com.gradedLab3.prob2;

import java.util.ArrayList;
import java.util.Scanner;

public class SumPairBST {
	static Scanner in = new Scanner(System.in);
	static ArrayList<Integer> bstList = new ArrayList<Integer>();

	static class Node {
		int key;
		Node left;
		Node right;
	}

	static Node newNode(Node node, int data) {
		node = new Node();
		node.key = data;
		node.left = null;
		node.right = null;
		return node;
	}

	public Node insert(Node root, int data) {
		if (root == null) {
			root = newNode(root, data);
		} else if (data < root.key) {
			root.left = insert(root.left, data);
		} else if (data > root.key) {
			root.right = insert(root.right, data);
		} else {
			System.out.println("Value already present!");
		}
		return root;
	}

	public boolean haveSumPair(int sum) {

		int sumHalf = sum / 2;
		int indexOf = 0;

		for (int val : bstList) {
			if (val > sumHalf) {
				indexOf = bstList.indexOf(val);
				break;
			}
		}

		int checkSum = bstList.get(indexOf);
//		System.out.println("checksum : " + checkSum);

		while (indexOf > 0) {
			indexOf--;
			if (checkSum + bstList.get(indexOf) == sum) {
				System.out.println(bstList.get(indexOf) + " + " + checkSum + " = " + sum);
				return true;
			}
		}
		
		return false;

	}

	public void inOrderTraversal(Node root) {

		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.key + " ");
		bstList.add(root.key);
		inOrderTraversal(root.right);

	}

	public static void main(String[] args) {
		SumPairBST bst = new SumPairBST();

		System.out.print("Enter the number of values to insert in BST :: ");
		int n = in.nextInt();
		Node root = null;

		for (int i = 1; i <= n; i++) {
			System.out.print("Enter value " + i + " : ");
			root = bst.insert(root, in.nextInt());
		}
		System.out.println("\nInorder Traversal : ");
		bst.inOrderTraversal(root);
		System.out.println();
		System.out.print("Enter the check sum :  ");
		int sum = in.nextInt(); 
		
		if(bst.haveSumPair(sum))
			System.out.println("Nodes are found.");
		else
			System.out.println("Could not find nodes");
	}

}
