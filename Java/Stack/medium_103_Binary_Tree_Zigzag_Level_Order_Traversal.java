/***
Tags: Tree, BFS, Stack
Create: 2019/8/25
Update: 2019/8/25

Problem description:
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).


For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7



return its zigzag level order traversal as:

[
  [3],
  [20,9],
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

// My First Version
// Runtime: 1 ms (faster than 95.62%); Memory Usage: 36 MB (less than 99.04%)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // Save all nodes in queue.
        Queue<TreeNode> q = new LinkedList<>();
        // Use stack to reverse nodes in odd level.
        Stack<Integer> stack = new Stack<>();
        TreeNode tmp_node;
        int cnt = 0, size = 0;
        
        if(root == null)    return ans;
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            size = q.size();
            
            // Save all nodes of next level to the queue.
            while(size-- > 0) {
                tmp_node = q.poll();
                if(tmp_node.left != null)    q.offer(tmp_node.left);
                if(tmp_node.right != null)    q.offer(tmp_node.right);
                
                // If there are nodes in odd level, we save it to stack that in order to reversing them before save to the List 
                if(cnt % 2 == 1)    stack.push(tmp_node.val);
                else    level.add(tmp_node.val);
            }
            
            if(cnt % 2 == 1) 
                while(!stack.empty())
                    level.add(stack.pop());
            
            ans.add(level);
            ++cnt;
        }
        return ans;
    }
}


// Modified Version(idea By caikehe)
// same efficiency
// Collections.reverse (without stack)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // Save all nodes in queue.
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode tmp_node;
        int cnt = 0, size = 0;
        
        if(root == null)    return ans;
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            size = q.size();
            
            // Save all nodes of next level to the queue.
            while(size-- > 0) {
                tmp_node = q.poll();
                if(tmp_node.left != null)    q.offer(tmp_node.left);
                if(tmp_node.right != null)    q.offer(tmp_node.right);

                level.add(tmp_node.val);
            }
            
            if(cnt % 2 == 1)    Collections.reverse(level);
            
            ans.add(level);
            ++cnt;
        }
        return ans;
    }
}

