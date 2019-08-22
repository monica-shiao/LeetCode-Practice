/***
Tags: BFS, Tree
Create: 2019/8/21
Update: 2019/8/21

Problem description:
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).


For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7



return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]


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


// My First Version (BFS, Queue)
// Runtime: 1 ms (faster than 89.67%); Memory Usage: 36.5 MB (less than 100.00%)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int cnt, i;
        TreeNode tmp_node;
        
        if(root == null)    return ans;
        
        q.offer(root);
        
        while(true){
            cnt = q.size();
            if(cnt == 0)    return ans;
            
            List<Integer> tmp = new ArrayList<>();
            
            for(i = 0; i < cnt; i++) {
                tmp_node = q.poll();
                tmp.add(tmp_node.val);
                
                if(tmp_node.left != null)   q.offer(tmp_node.left);
                if(tmp_node.right != null)  q.offer(tmp_node.right);
            }
            ans.add(tmp);
        }
    }
}




