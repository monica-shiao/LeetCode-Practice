/***
Tags: Dynamic_Programming
Create: 2019/9/12
Update: 2019/9/12

Problem description:

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.


Example 1:

Input: 
	"bbbab"

Output: 
	4

One possible longest palindromic subsequence is "bbbb".


Example 2:

Input:
	"cbbd"

Output:
	2

One possible longest palindromic subsequence is "bb".

***/

// Recursive DP Version (idea from )
// Runtime: 25 ms (faster than 39.09%); Memory Usage: 52.2 MB (less than 5.55%)

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        return recursive(s, 0, len - 1, new Integer[len][len]);
    }
    
    private int recursive(String s, int i, int j, Integer[][] dp) {
        // Speed up calculations
        if(dp[i][j] != null)    return dp[i][j];
        if(i > j)   return 0;
        if(i == j)  return 1;
        
        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = recursive(s, i + 1, j - 1, dp) + 2;
        }
        else {
            dp[i][j] = Math.max(recursive(s, i, j - 1, dp), recursive(s, i + 1, j, dp));
        }
        
        return dp[i][j];
    }
}



// Iterative DP Version (idea from Chadwick_521)
// Runtime: 22 ms (faster than 69.65%); Memory Usage: 47.8 MB (less than 5.55%)

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len == 0)    return 0;
        
        int[][] dp = new int[len][len];
        
        // i is start position
        for(int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            
            // j is end position
            for(int j = i + 1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}


