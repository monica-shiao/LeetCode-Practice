
/***
Tags: "Tree", "DFS", "BFS"
Create: 2019/01/29
Update: 2019/01/30

Problem description:

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3

Note:
    Bonus points if you could solve it both recursively and iteratively.

***/


/***
* Version of Recursive + DFS
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
// My Version
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Prepare for : []
        if(root == null)    return true;
        
        // Compare left and right sides of tree (less time consuming than all tree compare twice times)
        else if(root.left != null && root.right != null){
            if(root.left.val != root.right.val)     return false;
            else    return compare(root.left, root.right); 
        }
        // Prepare for : [x]
        else{
            // symmetric
            if(root.left == null && root.right == null)    return true;
            // unsymmetric
            else    return false;
        }
    }
    
    public boolean compare(TreeNode left_node, TreeNode right_node){
        // Check for no child
        if(left_node == null || right_node == null){
            if(left_node == null && right_node == null)     return true;
            else    return false;
        }

        // DFS from left is compared with DFS from right.(Checking value during the progress of DFS.)
        return compare(left_node.left, right_node.right) 
            && compare(left_node.right, right_node.left) 
            && (left_node.val == right_node.val);
    }
}

// Official Version (Slower, but beautifel)
/*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Compare all tree from left and right.
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
}
*/



/***
* Version of Iterative + BFS
***/
// Official Version (It's great.)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

// My Version (Not well)
// I divided every level and stored in array to check it's symmetric.(But in official, actually don't divide level that also is ok in result.)
/*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        int nodeCount = 0, i, cnt;
        TreeNode node, Null = new TreeNode(Integer.MIN_VALUE);
        
        if(root == null)    return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(true){
            // number of nodes at current level 
            nodeCount = q.size();
            
            if(nodeCount == 0)  return true;
            
            int[] array = new int[nodeCount]; 
            cnt = 0;
            
            // Store value of each node in array
            for(TreeNode element : q){
                array[cnt++] = element.val;
            }
            
            // check whether it is a mirror of this level
            for(i = 0; i < cnt/2; i++){
                if(array[i] != array[(nodeCount-1) - i])
                    return false;
            }
            
            // Get children nodes in next level
            while(nodeCount > 0){
                node = q.poll();
                
                if(node.val == Integer.MIN_VALUE){
                    --nodeCount;
                    continue;
                }
                
                if(node.left != null)
                    q.offer(node.left);
                else
                    q.offer(Null);
                
                
                if(node.right != null)
                    q.offer(node.right);
                else
                    q.offer(Null);
                
                --nodeCount;
            }
        }
    }
}*/
