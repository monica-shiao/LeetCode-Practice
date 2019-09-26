/***
Tags: Array, Dynamic_Programming
Create: 2019/9/25
Update: 2019/9/25

Problem description:
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?


An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

	Input:
	[
	 [0,0,0],
	 [0,1,0],
	 [0,0,0]
	]
	Output: 2
	Explanation:
	There is one obstacle in the middle of the 3x3 grid above.
	There are two ways to reach the bottom-right corner:
	1. Right -> Right -> Down -> Down
	2. Down -> Down -> Right -> Right


***/

// My First Version (Double Array & DP)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 40.5 MB (less than 35.38%)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        if(m == 0 || n == 0 || obstacleGrid[0][0] == 1)    return 0;
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1)    dp[i][j] = 0;
                else {
                	// dp[0][j] inherits its left value
                    if(i == 0) {
                        if(j == 0)    continue;
                        else    dp[i][j] = dp[i][j - 1];
                    }  
                    // dp[i][0] inherits the value that above it
                    else if(j == 0)    dp[i][j] = dp[i - 1][j];
                    else    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}


// My Second Version (Single Array & DP)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 39.2 MB (less than 64.61%)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        if(m == 0 || n == 0 || obstacleGrid[0][0] == 1)    return 0;
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1)    dp[j] = 0;
                else {
                    if(i == 0) {
                        if(j == 0)    continue;
                        else    dp[j] = dp[j - 1];
                    }  
                    else if(j == 0)    dp[j] = dp[j];
                    else    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}