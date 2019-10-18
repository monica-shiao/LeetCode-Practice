/***
Tags: Tree
Create: 2019/10/8
Update: 2019/10/17

Problem description:
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:


Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7

	Target = 9

	Output: True


Example 2:

	Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7

	Target = 28

	Output: False
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


// My Second Version (Queue + HashSet)
// Runtime: 5 ms (faster than 32.56%); Memory Usage: 41.9 MB (less than 71.43%)

class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)    return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        TreeNode tmp_node;
        
        q.offer(root);
        
        while(q.size() > 0) {
            tmp_node = q.poll();
            
            if(tmp_node.left != null)   q.offer(tmp_node.left);
            if(tmp_node.right != null)  q.offer(tmp_node.right);

            if(set.contains(k - tmp_node.val))    return true;
            else    set.add(tmp_node.val);
        }
        return false;
    }
}



// Official Version
// Runtime: 4 ms (faster than 72.98%); Memory Usage: 42.4 MB (less than 67.86%)

class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)    return false;
        
        Set <Integer> set = new HashSet<>();

        return search(root, k, set);
    }
    
    public boolean search(TreeNode root, int t, Set<Integer> set) {
        if(root == null)    return false;
        
        if(set.contains(t - root.val))   return true;
        set.add(root.val);

        return search(root.left, t, set) || search(root.right, t, set);
    }
}


// My First Version
// Runtime: 10 ms (faster than 8.78%); Memory Usage: 42.5 MB (less than 67.86%)

class Solution {
    public Queue<TreeNode> q = new LinkedList<>();
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)    return false;
        boolean is_get;
        TreeNode tmp_node;
        
        q.offer(root);
        
        while(q.size() > 0) {
            tmp_node = q.poll();
            
            if(tmp_node.left != null)   q.offer(tmp_node.left);
            if(tmp_node.right != null)  q.offer(tmp_node.right);
        
            // Search from the subtree below this node
            is_get = search(k - tmp_node.val);
            if(is_get)    return true;
        }
        return false;
    }
    
    public boolean search(int t) {
        // Clone the origin queue to find the node that below the current node
        Queue<TreeNode> tmp_q = new LinkedList<>(q);
        TreeNode tmp_n;
        
        while(tmp_q.size() > 0) {
            tmp_n = tmp_q.poll();
            
            if(tmp_n.val == t)  return true;
            else {
                if(tmp_n.left != null)  tmp_q.offer(tmp_n.left);
                if(tmp_n.right != null)  tmp_q.offer(tmp_n.right);
            }
        }
        return false;
    }
}
