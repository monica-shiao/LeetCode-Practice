/***
Tags: Tree DFS
Create: 2019/4/23
Update: 2019/4/23

Problem description:
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:


Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

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


// Reference: https://www.cnblogs.com/springfor/p/3879823.html
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.8 MB (less than 55.81%)

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int left, int right){
        if(left > right)    return null;
        
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = buildTree(nums, left, mid - 1);
        node.right = buildTree(nums, mid + 1, right);
        
        return node;
    }
}

