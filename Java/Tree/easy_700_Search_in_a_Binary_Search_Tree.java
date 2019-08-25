/***
Tags: Tree
Create: 2019/8/25
Update: 2019/8/25

Problem description:
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2


You should return this subtree:


      2     
     / \   
    1   3


In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as[], not null.

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
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 38.4 MB (less than 100.00%)

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        while(root != null) {
            if(val < root.val)    root = root.left;
            else if(val == root.val)    return root;
            else   root = root.right;
        }
        return null;
    }
}
