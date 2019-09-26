/***
Tags: Array, Dynamic_Programming
Create: 2019/9/25
Update: 2019/9/25

Problem description:
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

	Input:
	[
	 [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	Output: 7
	Explanation: Because the path 1 -> 3 -> 1 -> 1 -> 1 minimizes the sum.
***/

// My First Version
// Runtime: 2 ms (faster than 90.12%); Memory Usage: 41.9 MB (less than 87.84%)

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length, min = 0, tmp;
        if(m == 0 || n == 0)    return 0;
        
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    if(j != 0)    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                else if(j == 0)  dp[i][j] = dp[i - 1][j] + grid[i][j];
                else {
                	// Choose above value and left value which is smaller
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}