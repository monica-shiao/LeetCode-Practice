/***
Tags: Dynamic_Programming
Create: 2019/9/14
Update: 2019/9/14

Problem description:
Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
	Input: s1 = "sea", s2 = "eat"
	Output: 231
	Explanation: 
		Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
		Deleting "t" from "eat" adds 116 to the sum.
		At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.


Example 2:
	Input: s1 = "delete", s2 = "leet"
	Output: 403
	Explanation: 
		Deleting "dee" from "delete" to turn the string into "let",adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
		At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
		If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.

Note:
	0 < s1.length, s2.length <= 1000.
	All elements of each string will have an ASCII value in [97, 122]. 

***/


// My First Version
// Runtime: 22 ms (faster than 17.21%); Memory Usage: 38.8 MB (less than 20.00%)

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length(), i, j, tmp_i, tmp_j, total = 0;
        int[][] dp = new int[m + 1][n + 1];
        int[][] ascii = new int[m + 1][n + 1];
        
        for(i = 1; i <= m; i++) {
            total += (int)s1.charAt(i - 1);
            for(j = 1; j <= n; j++) {
                if(i == 1)    total += (int)s2.charAt(j - 1);
                
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ascii[i][j] = ascii[i - 1][j - 1] + (int)s1.charAt(i - 1);
                }
                else {
                    if(dp[i][j - 1] == dp[i - 1][j]) {
                        dp[i][j] = dp[i][j - 1];
                        // If the length of substring is equal, choose the larger ascii code (cause finally be minus will become minimum answer)
                        ascii[i][j] = Math.max(ascii[i][j - 1], ascii[i - 1][j]);
                    }
                    else {
                        tmp_i = (dp[i][j - 1] > dp[i - 1][j]) ? i : i - 1;
                        tmp_j = (dp[i][j - 1] > dp[i - 1][j]) ? j - 1 : j;

                        dp[i][j] = dp[tmp_i][tmp_j];
                        ascii[i][j] = ascii[tmp_i][tmp_j];
                    }
                }
            }
        }
        
        return total - ascii[m][n] * 2;
    }
}
