/***
Tags: "String" "Hash Table" "Two Pointer" "Sliding Window"
Create: 2019/4/12
Update: 2019/4/12

Problem description:
Given a string, find the length of the longest substring without repeating characters.

Example 1:
	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 

Example 2:
	Input: "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.

Example 3:
	Input: "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3. 
	             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

***/

// Official Version (ASCII)
// Runtime: 2 ms (faster than 99.93%); Memory Usage: 38.8 MB(less than 28.53%)

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}

// My First Version (ASCII)
// Runtime: 6 ms (faster than 96.94%); Memory Usage: 37.4 MB(less than 52.86%)
Memory Usage: 39.4 MB, less than 19.28%
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] ascii = new int[128];
        int p = 0, max = 0, ascii_pos, i, j, tmp_max = 0;
        
        for(i = 0; i < s.length(); i++){
            tmp_max = 0;
            Arrays.fill(ascii, 0);
            
            for(j = i; j < s.length(); j++){
                ascii_pos = (int)s.charAt(j);
                
                if(ascii[ascii_pos] == 0){
                    ascii[ascii_pos] += 1;
                    tmp_max += 1;
                }
                else    break;   
            }
            
            if(tmp_max > max)   max = tmp_max;
            if(j == s.length())    break;
            
        }
        return max;
    }
}