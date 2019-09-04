/***
Tags: Tree, BFS
Create: 2019/9/4
Update: 2019/9/4

Problem description:
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:

			1
		/	|   \
	  3		2	  4
     / \
	5	6


We should return its level order traversal:


[
     [1],
     [3,2,4],
     [5,6]
]


Note:
	The depth of the tree is at most 1000.
	The total number of nodes is at most 5000.

***/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// My First Version
// Runtime: 3 ms (faster than 76.19%); Memory Usage: 48.4 MB (less than 45.00%)

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        
        if(root == null)    return ans; 
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            int size = q.size();
            
            while(size > 0) {
                Node curr = q.poll();
                tmp.add(curr.val);
                
                for(Node child : curr.children) {
                    q.offer(child);
                }
                --size;
            }
            ans.add(tmp);
        }
        return ans;
    }
}