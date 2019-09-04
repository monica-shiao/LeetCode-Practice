/***
Tags: Tree
Create: 2019/9/4
Update: 2019/9/4

Problem description:
Invert a binary tree.

Example:

Input:


     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:


     4
   /   \
  7     2
 / \   / \
9   6 3   1

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


// My First Version (Same as official)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 34.3 MB (less than 100.00%)

class Solution {
    TreeNode ans;
    public TreeNode invertTree(TreeNode root) {
        if(root == null)    return null;
        
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        
        return root;
    }
}
