/***
Tags: Tree, DFS
Create: 2019/9/29
Update: 2019/9/29

Problem description:
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.


Example 1:

	    2
	   / \
	  1   3

	Input:[2,1,3]
	Output: true


Example 2:

	    5
	   / \
	  1   4
	    / \
	   3   6

	Input: [5,1,4,null,null,3,6]
	Output: false
	Explanation: The root node's value is 5 but its right child's value is 4.

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


// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 39.4 MB (less than 80.47%)

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        
        TreeNode left = root.left, right = root.right;
        if(left != null) {
            if(left.val >= root.val)    return false;
            else {
            	// Check subtrees also is BFS tree
                while(left.right != null) {
                    if(left.right.val >= root.val)     return false;
                    left = left.right;
                }
            }
        }
        
        if(right != null) {
            if(right.val <= root.val)    return false;
            else {
            	// Check subtrees also is BFS tree
                while(right.left != null) {
                    if(right.left.val <= root.val)     return false;
                    right = right.left;
                }
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}

