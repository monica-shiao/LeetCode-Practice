/***
Tags: "Tree"
Create: 2019/01/30
Update: 2019/02/09

Problem description:
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2  

          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  

Output: 
	Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

Note: The merging process must start from the root nodes of both trees.

***/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Official Iterative Method
// Iterative is so hard Q__Q
// When B tree merge with A tree, if node in A tree don't have child node but the node in the same place in B tree has, copy this node of B tree to node of A tree.
// If A and B tree has child node in the same place, push them into stack. And when we pop the top elements in Stack to process, add their value together;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack < TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } 
            else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } 
            else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}



// The model that used Stack to implement BFS  
// Pop parents node of stack before find its children. And push its children in stack(left first, right second).
// Not Answer.
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        Stack<TreeNode> tree = new Stack();
        TreeNode tmp;
        tree.push(t1);

        while(!tree.empty()){
        	// Pop parents node of stack before find its children.
            tmp = tree.pop();
            System.out.println(tmp.val);
            
            if(tmp.left != null){
                tree.push(tmp.left);
            }
            if(tmp.right != null){
                tree.push(tmp.right);
            }
        }
    }
}


// My Recursive Version
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if(t1 == null)    return t2;
        if(t2 == null)    return t1;
        
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        t1.val = t1.val+t2.val;
        return t1;
    }
}