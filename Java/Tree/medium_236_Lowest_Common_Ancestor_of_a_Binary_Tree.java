/***
Tags: Tree
Create: 2019/9/29
Update: 2019/9/29

Problem description:
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes pand qas the lowest node in T that has both pand qas descendants (where we allow a node to be a descendant of itself).&rdquo;

Given the following binary tree: root =[3,5,1,6,2,0,8,null,null,7,4]



Example 1:

	Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
	Output: 3
	Explanation: The LCA of nodes 5 and 1 is 3.


Example 2:

	Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
	Output: 5
	Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Note:

	All of the nodes' values will be unique.
	p and q are different and both values willexist in the binary tree.

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
// Runtime: 6 ms (faster than 70.06%); Memory Usage: 35.6 MB (less than 5.55%)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)    return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If we find left & right node at the same time, meaning the LCA is their parent (current root)
        if(left != null && right != null)    return root;
        else    return (left != null) ? left : right;
    }
}
