/***
Tags: Array
Create: 2019/8/16
Update: 2019/8/16

Problem description:
Given a non-negative integernumRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:


Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


***/


// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 33.9 MB (less than 7.23%)

/*
 | 0  1  2  3    (j)
----------------
0| 1
1| 1  1
2| 1  2  1
3| 1  3  3  1

(i)
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(numRows == 0)    return ans;
        
        ArrayList<Integer> cur = new ArrayList<>();
        // i = 0 -> [1]
        cur.add(1);
        ans.add(cur);
        
        for(int i = 1; i < numRows; i++) {
            cur = (ArrayList<Integer>)cur.clone();
            cur.clear();
            cur.add(1);
            
            if(i >= 2) {
                for(int j = 1; j < i; j++) {
                    cur.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }
}

