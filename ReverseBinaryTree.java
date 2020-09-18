/*

	Reverse a binary tree
		 j					j
		/ \				   / \
	   /   \			  /   \
	  d	    p			 p	   d
	 / \   / \			/ \	  / \
	a   b o   r 	   r   o b   a
	
	Code to replicate the mirror image or a binary tree
	
*/


import java.util.*;
import java.io.*;

class ReverseBinaryTree {
	
	static class Node{
		char data;
		Node left,right;
	};

	static Node reverseTreePathUtil(Node root, int level, Stack<Character> s){
		
		if(root == null){
			return null;
		}
		
    root.data = s.pop();
		reverseTreePathUtil(root.left, level+1, s);
		reverseTreePathUtil(root.right, level+1, s);
		
		return null;
		
	}
	
	static void reverseTreePath(Node root){
		
		if(root == null){
			return;
		}
		
		Stack<Character> s = new Stack<Character>();
		postordertraverse(root,s);
		reverseTreePathUtil(root, 0, s);

	};
	
	static void postordertraverse(Node root, Stack<Character> s){
		
		if(root == null){
			return;
		}
		
 	  postordertraverse(root.left,s);
		postordertraverse(root.right,s);
		s.push(root.data);
		System.out.print( root.data + " ");
      

		return;
		
	}
	
  static void inorder(Node root)  
  {   
    if (root != null) {  
        inorder(root.left);  
        System.out.print( root.data + " ");
          
        inorder(root.right);  
    }
    
  }  

  // Utility function to create a new tree node  
 static Node newNode(char ltr)  
  {  
    Node temp = new Node();  
    temp.data = ltr;  
    temp.left = temp.right = null;  
    return temp;  
  }  
    
	public static void main(String args[]){
		
		Node root = newNode('J');
		root.left = newNode('d');
		root.right = newNode('p');
		root.left.left = newNode('a');
		root.left.right = newNode('b');
		root.right.left = newNode('o');
		root.right.right = newNode('r');
		System.out.println(" Post Order Traversal is : ");
		reverseTreePath(root);
		System.out.println(" In order traversal is : ");
		inorder(root);

   
	}
}