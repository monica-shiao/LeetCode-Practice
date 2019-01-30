/***
Tags: "Tree", "DFS", "BFS"(Myself)
Create: 2019/01/29
Update: 2019/01/29

Problem description:
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

***/

// Official solution 
// Recursion + Depth First Search
// Time complexity : O(N), where N is the number of nodes.
// Space complexity : In the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N). 
//                    But in the best case (the tree is completely balanced), the height of the tree would be \log(N)log(N). Therefore, the space complexity in this case would be O(log(N)). 

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
    public int maxDepth(TreeNode root) {
        int height=0;
        if(root ==  null)   
            return 0;

        else
            return java.lang.Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}

// Queue Version
// Queue + Breadth First Search
// Concept from GeeksforGeeks
/*
Concept is level by level. Whenever move down to a level, increment height by 1.
nodeCount: store the number of nodes at current level.

    1(root)
   / \
  2   3
 / \
4   5 

Step 1: (nodeCount=1  Level1:height+1)
    queue = {1}
    // pop 1;
    // add 2, 3 

Step 2-1: (nodeCount=2, Level2:height+1)
    queue = {2, 3}
    // pop 2
    // add 4, 5

Step 2-2: (nodeCount=1)
    queue = {3, 4, 5}
    // pop 3

Step 3-1: (nodeCount=2, Level3:height+1)
    queue = {4, 5}
    // pop 4

Step 3-2: (nodeCount=1)
    queue = {5}
    // pop 5

Step 4: (All nodes in tree are found)
    return height
*/ 
    
/*
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // Initialize queue & variables.
        int height = 0, nodeCount = 0;
        TreeNode node;
        
        if(root == null)    return 0;
        q.offer(root);
        
        while(true){
            // Processing each level in the tree.
            nodeCount = q.size();

            if(nodeCount == 0)  return height;
            
            ++height;
            
            // Numbers of nodes in Current level. Add all children nodes of each node into queue.
            while(nodeCount > 0){
                // Find first element,and pop it after saving.
                node = q.poll();
                
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }

                --nodeCount;
            }
        }
    }
}*/


// My Version
// Like Official version: Recursion + DFS
/*
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        else{
            int leftleave = 1 + maxDepth(root.left);
            int rightleave = 1 + maxDepth(root.right);
            return (leftleave >= rightleave) ? leftleave : rightleave;
        }
    }
}*/