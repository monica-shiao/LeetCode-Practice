/***
Tags: Tree, DFS
Create: 2019/9/29
Update: 2019/9/29

Problem description:
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

	    1
	   / \
	  2   5
	 / \   \
	3   4   6


The flattened tree should look like:

	1
	 \
	  2
	   \
	    3
	     \
	      4
	       \
	        5
	         \
	          6

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


// My Second Version (Recursive)
// Runtime: 1 ms (faster than 68.36%); Memory Usage: 35.8 MB (less than 100.00%)

class Solution {
    public void flatten(TreeNode root) {
        if(root == null)    return;
        
        // Standard recursive processing
        flatten(root.left);
        flatten(root.right);

        // Save origin left & right node first.
        TreeNode left = root.left, right = root.right;

        // Renew left & right node
        root.left = null;
        root.right = left;
        
        while(root.right != null)
            root = root.right;
        // Set origin right node at the end of the right side.
        root.right = right;
    }
}


// My First Version (Iterative & Stack)
// Runtime: 2 ms (faster than 9.30%); Memory Usage: 38.1 MB (less than 56.36%)

class Solution {
    public void flatten(TreeNode root) {
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr_root = root, curr;
            stack.push(root);

            while(!stack.empty()) {
                curr = stack.pop();

                if(curr.right != null)
                    stack.push(curr.right);

                if(curr.left != null)
                    stack.push(curr.left);

                root.left = null;
                root.right = (!stack.empty()) ? stack.peek() : null;
                root = root.right;
            }    
        }
    }
}
