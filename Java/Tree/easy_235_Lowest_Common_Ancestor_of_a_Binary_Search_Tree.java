/***
Tags: Tree
Create: 2019/9/30
Update: 2019/9/30

Problem description:
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes p and qas the lowest node in T that has both p and qas descendants (where we allow a node to be a descendant of itself).&rdquo;

Given binary search tree: root =[6,2,8,0,4,7,9,null,null,3,5]



Example 1:

	Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
	Output: 6
	Explanation: The LCA of nodes 2 and 8 is 6.


Example 2:

	Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
	Output: 2
	Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


Note:

	All of the nodes' values will be unique.
	p and q are different and both values willexist in the BST.

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



// Second Version(Idea from https://www.hrwhisper.me/algorithm-lowest-common-ancestor-of-a-binary-tree/)
// Runtime: 4 ms (faster than 100.00%); Memory Usage: 35.8 MB (less than 5.10%)

class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return root;
        
        if(p.val > q.val)   
            return lowestCommonAncestor(root, q, p);
        
        // Three situation: First, p is on the left side of root, and q is on the right side of root;
        if(p.val <= root.val && root.val <= q.val)    return root;
        
        // p(smaller than q) is on the right side of the root (bigger than root)
        else if(root.val < p.val)    
            return lowestCommonAncestor(root.right, p, q);
        
        // q < root -> q is on the left side of the root (smaller than root)
        else   
        	return lowestCommonAncestor(root.left, p, q);
    }
}


// My First Version (DFS)
// Runtime: 5 ms (faster than 21.87%); Memory Usage: 36.6 MB (less than 5.10%)

class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return root;
        TreeNode small = (p.val <= q.val) ? p : q;
        TreeNode big = (p.val <= q.val) ? q : p;
        
        if(small.val <= root.val && root.val <= big.val) {
            TreeNode rigth_leaf = root, left_leaf = root;
            // The end of right side must bigger or equal than value of big node
            while(rigth_leaf.right != null)    
                rigth_leaf = rigth_leaf.right;
            
            // The end of left side must smaller or equal than value of small node
            while(left_leaf.left != null)    
                left_leaf = left_leaf.left;
            
            // Satisfying the above two rules means that root is the closest LCA node.
            if(rigth_leaf.val >= q.val && left_leaf.val <= small.val)    ans = root;
        }
        
        lowestCommonAncestor(root.left, small, big);
        lowestCommonAncestor(root.right, small, big);
        
        return ans;
    }
}

