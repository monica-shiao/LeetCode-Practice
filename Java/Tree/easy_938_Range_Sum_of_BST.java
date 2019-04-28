/***
Tags: Tree, Recursion
Create: 2019/4/28
Update: 2019/4/28

Problem description:
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

Example 1:
	Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
	Output: 32


Example 2:
	Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
	Output: 23

Note:

	The number of nodes in the tree is at most 10000.
	The final answer is guaranteed to be less than 2^31.

 **
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 **

***/

// My Third Version (BFS -> Iteration)
// Runtime: 1 ms (faster than 81.92%); Memory Usage: 44.8 MB (less than 95.64%)

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode tmp;
        int ans = 0, cnt;
        
        if(root != null){
            q.offer(root);
            while(q.size() != 0){
                cnt = q.size();
                while(cnt != 0){
                    tmp = q.poll();
                    if(L <= tmp.val && tmp.val <= R)    ans += tmp.val;
                    if(L < tmp.val && tmp.left != null)    q.offer(tmp.left);
                    if(tmp.val < R && tmp.right != null)    q.offer(tmp.right);
                    --cnt;
                }
            }
        } 
        return ans;
    } 
}


// Based on Official Version (BST)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 49.9 MB (less than 5.13%)
class Solution {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root != null){
            if(L <= root.val && root.val <= R)   
                ans += root.val;
            if(L < root.val)
                rangeSumBST(root.left, L, R);
            if(root.val < R)
                rangeSumBST(root.right, L, R);
        }
        return ans;
    } 
}

// My First Version (Suitable for many kinds of Trees)
// Runtime: 1 ms (faster than 81.92%); Memory Usage: 49.8 MB (less than 5.13%)
/*
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        
        if(root == null)    return 0;
        
        if(L <= root.val && root.val <= R)
            ans = root.val;
        
        ans += rangeSumBST(root.left, L, R);
        ans += rangeSumBST(root.right, L, R);

        return ans;
        
    }
}*/

