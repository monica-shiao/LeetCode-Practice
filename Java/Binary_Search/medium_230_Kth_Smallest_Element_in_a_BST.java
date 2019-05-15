/***
Tags: Binary_Search, Tree
Create: 2019/5/14
Update: 2019/5/14

Problem description:
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 <= k <= BST's total elements.

Example 1:
  Input: root = [3,1,4,null,2], k = 1
     3
    / \
   1   4
    \
    2
  Output: 1

Example 2:
  Input: root = [5,3,6,2,4,null,null,1], k = 3
         5
        / \
       3   6
      / \
     2   4
    /
   1
  Output: 3


Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

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

// My First Version (Recursive, inorder traversal)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 36.8 MB (less than 93.27%)

class Solution {
    int cnt = 0;
    int[] ans;
    
    public int kthSmallest(TreeNode root, int k) {
        ans = new int[k];
        recursive(root, k);
        return ans[k - 1];
    }
    
    public TreeNode recursive(TreeNode root, int k) {
        if(root != null){
            recursive(root.left, k);
            
            if(cnt >= k)    return null;
            
            ans[cnt++] = root.val;
            recursive(root.right, k);
        }
        return root;
    }
    
}

// Officail Version (Iterative, Linked List)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 36.2 MB (less than 99.20%)

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0)  return root.val;
            root = root.right;
           
        }
    }
}