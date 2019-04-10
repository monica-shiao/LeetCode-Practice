/***
Tags: "Tree", "DFS"
Create: 2019/02/09
Update: 2019/02/09

Problem description:
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
	Input:     1         1
	          / \       / \
	         2   3     2   3

	        [1,2,3],   [1,2,3]

	Output: true

Example 2:	
	Input:     1         1
	          /           \
	         2             2

	        [1,2],     [1,null,2]

	Output: false	

Example 3:
	Input:     1         1
	          / \       / \
	         2   1     1   2

	        [1,2,1],   [1,1,2]

	Output: false
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

// My Iterative Version
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> tree = new Stack<>();
        if(p != null && q != null){
            if(p.val == q.val)  tree.push(new TreeNode[]{p, q});
            else    return false;
        }
        else if(p == null && q == null)     return true;
        else    return false;
        
        while(!tree.empty()){
            TreeNode[] tmp = tree.pop();
            
            if(tmp[0].left != null && tmp[1].left != null){
                if(!(tmp[0].left.val == tmp[1].left.val))   return false;
                else{
                    tree.push(new TreeNode[]{tmp[0].left, tmp[1].left});
                }
            }
            else{
                if(!(tmp[0].left == null && tmp[1].left == null)) return false;
            }
            
            if(tmp[0].right != null && tmp[1].right != null){
                if(!(tmp[0].right.val == tmp[1].right.val))   return false;
                else{
                    tree.push(new TreeNode[]{tmp[0].right, tmp[1].right});
                }
            }
            else{
                if(!(tmp[0].right == null && tmp[1].right == null)) return false;
            }
        }
        return true;
    }
}





// My Recursive Version
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean a;
        if(p == null || q == null){
            if(p == null && q == null)  return true;
            else    return false;
        }
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}