/***
Tags: Tree
Create: 2019/9/4
Update: 2019/9/4

Problem description:
Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

			1
		/	|   \
	  3		2	  4
     / \
	5	6


Return its preorder traversal as: [1,3,5,6,2,4].


Note:

Recursive solution is trivial, could you do it iteratively?

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

// My Second Version (Itertively)
// Runtime: 4 ms (faster than 16.06%); Memory Usage: 46.2 MB (less than 63.42%%)
class Solution {
    public List<Integer> preorder(Node root) {
        if(root == null)    return new LinkedList<Integer>();
        
        List<Integer> ans = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node tmp;
            
        while(!stack.empty()) {
            tmp = stack.pop();
            ans.add(tmp.val);
            
            for(int i = tmp.children.size() - 1; i >= 0; i--) {
                stack.push(tmp.children.get(i));
            }
        }
        return ans;
    }
}

// My First Version (Recursive)
// Runtime: 1 ms (faster than 100.00%); Memory Usage: 44.7 MB (less than 95.12%)

class Solution {
    List<Integer> ans = new LinkedList<>();
    
    public List<Integer> preorder(Node root) {
        recursive(root);
        
        return ans;
    }
    
    public Node recursive(Node root) {
        if(root == null)    return root;
        
        ans.add(root.val);
        
        for(int i = 0; i < root.children.size(); i++) {
            if(root.children.get(i) != null)    
                recursive(root.children.get(i));
        }
        
        return root;
    }
}