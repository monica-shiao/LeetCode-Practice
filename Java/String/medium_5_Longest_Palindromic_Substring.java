/***
Tags: String, Dynamic_Programming
Create: 2019/9/11
Update: 2019/9/11

Problem description:
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
	Input: "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.


Example 2:
	Input: "cbbd"
	Output: "bb"

***/


// My Second DP Version (idea from jeantimex)
// Runtime: 37 ms (faster than 41.65%); Memory Usage: 39 MB (less than 23.39%)

class Solution {
    public String longestPalindrome(String s) {
      int n = s.length();
      String res = "";

      boolean[][] dp = new boolean[n][n];

      // i is start character
      for (int i = n - 1; i >= 0; i--) {
      	// j is end character
        for (int j = i; j < n; j++) {
	        // j - i < 3 means (length of middle substring = 1) without start and end character.
			if(s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])){
				dp[i][j] = true;
				if(j - i + 1 > res.length()) {
			      res = s.substring(i, j + 1);
				}
        	}
        }
      }
      return res;
    }
}  


// My DP Version
// Runtime: 38 ms (faster than 40.60%); Memory Usage: 37.7 MB (less than 54.44%)

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0)     return "";
        
        int len = s.length(), i, j, dist, ans_len = 0, ans_i = 0, ans_j = 0;
        boolean[][] state = new boolean[len][len];
        
        for(i = 0; i < len; i++) {
            state[i][i] = true;
        }
        
        for(i = len - 1; i >= 0; i--) {
            for(dist = 1; dist < len - i; dist++) {
                j = i + dist;
                
                if(dist == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        state[i][j] = true;
                        if(dist > ans_len){
                            ans_len = dist;
                            ans_i = i;
                            ans_j = j;
                        }
                    }
                }
                else {
                    // i + 1 -> index + 1; j - 1 -> dist - 1
                    if(state[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        state[i][j] = true;
                        if(dist > ans_len){
                            ans_len = dist;
                            ans_i = i;
                            ans_j = j;
                        }
                    }
                }
            }
        }
        return s.substring(ans_i, ans_j + 1);  
    }
}   

