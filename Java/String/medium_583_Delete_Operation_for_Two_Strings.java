/***
Tags: String, Dynamic_Programming
Create: 2019/9/13
Update: 2019/9/13

Problem description:

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.


Example 1:
	Input: "sea", "eat"
	Output: 2
	Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".



Note:
	The length of given words won't exceed 500.
	Characters in given words can only be lower-case letters.
***/


// My First DP DP Version (Iterative, concept same as #1143 question)
// Runtime: 5 ms (faster than 93.71%); Memory Usage: 36.4 MB (less than 100.00%)

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return (m + n) - 2 * dp[m][n];
    }
}


// My Second DP Version (Recursive)
// Runtime: 8 ms (faster than 50.16%); Memory Usage: 36.3 MB (less than 100.00%)

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        
        return (m + n) - 2 * recursive(new Integer[m + 1][n + 1], m, n, word1, word2);
    }
    
    public int recursive(Integer[][] dp, int i, int j, String word1, String word2) {
        
        if(i == 0 || j == 0)    return 0;
        
        if(dp[i][j] != null)    return dp[i][j];
        
        if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
            dp[i][j] = recursive(dp, i - 1, j - 1, word1, word2) + 1;
        }
        else {
            dp[i][j] = Math.max(recursive(dp, i, j - 1, word1, word2), recursive(dp, i - 1, j, word1, word2));
        }
        return dp[i][j];
    }
}
