/***
Tags: Tree, DFS (Linked-List, Recursion) 
Create: 2019/4/30
Update: 2019/4/30

Problem description:
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.


Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
/        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
           \
            7
             \
              8
               \
                 9  

Note:


	The number of nodes in the given tree will be between 1 and 100.
	Each node will have a unique integer value from 0 to 1000.


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

// My Second Version (In-place version)
// Runtime: 2 ms (faster than 99.97%); Memory Usage: 38.4 MB (less than 98.47%)

class Solution {
    TreeNode head, curr, node, tmp;
    int flag = 0;
    
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return head;
    }
    
    public TreeNode inOrder(TreeNode root){
        if(root == null)    return root; 
        
        tmp = inOrder(root.left);
        
        if(flag == 0){
            node = new TreeNode(root.val);
            head = node;
            curr = node;
            flag = 1;
        }
        else{
            curr.right = new TreeNode(root.val);
            curr = curr.right;
        }
        
        tmp = inOrder(root.right);
        
        return tmp;
    }
}


// My First Version (Recursion, Queue and Linked List)
// Runtime: 3 ms (faster than 80.48%); Memory Usage: 45.9 MB (less than 41.38%)

class Solution {
    Queue<Integer> orderNodes = new LinkedList<>();
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = inOrder(root);
        
        if(orderNodes.peek() != null){
            node  = new TreeNode(orderNodes.poll());
        }
        
        TreeNode head = node;
        TreeNode curr = node;
        
        while(orderNodes.peek() != null){
            curr.right = new TreeNode(orderNodes.poll());
            curr = curr.right;
        }
        return head;
    }
    
    public TreeNode inOrder(TreeNode root){
        if(root == null)    return root; 
        
        TreeNode tmp = inOrder(root.left);
        orderNodes.add(root.val);
        tmp = inOrder(root.right);
        
        return tmp;
    }
}
