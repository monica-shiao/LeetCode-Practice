/***
Tags: String, Dynamic Programming
Create: 2019/9/8
Update: 2019/9/11

Problem description:
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
	Input: "abc"
	Output: 3
	Explanation: Three palindromic strings: "a", "b", "c".


Example 2:
	Input: "aaa"
	Output: 6
	Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Note:
	
The input string length won't exceed 1000.

***/

// My DP Version (idea from GraceMeng)
// Runtime: 5 ms (faster than 44.61%); Memory Usage: 35.8 MB (less than 59.49%)


class Solution {
    public int countSubstrings(String s) {
        int len = s.length(), i, dist, j, cnt = 0; 
        boolean[][] state = new boolean[len][len];
        
        // All individual character are true
        for(i = 0; i < len; i++){
            state[i][i] = true;
            ++cnt;
        }
        
        // i is position of index node 
        for(i = len - 1; i >= 0; i--) {
        	//dist is the distance that behind the index node
            for(dist = 1; dist < len - i; dist++) {
                j = dist + i;
                
                // check substrings of length 1 
                if(dist == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        state[i][j] = true;
                        ++cnt;
                    }
                }
                else {
                    if(state[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                        state[i][j] = true;
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }
}



