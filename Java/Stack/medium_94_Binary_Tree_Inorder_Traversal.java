/***
Tags: "Tree", "Stack", "Hash Table"
Create: 2019/02/18
Update: 2019/02/18

Problem description:
Given a binary tree, return the inorder traversal of its nodes' values.

Example:
	Input: [1,null,2,3]
	   1
	    \
	     2
	    /
	   3

	Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively?

*** Only have Interative Version now.
***/

// Official Interative Version (using stack)
// Don't have my version QQ. Keep studying.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || !stack.empty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}



