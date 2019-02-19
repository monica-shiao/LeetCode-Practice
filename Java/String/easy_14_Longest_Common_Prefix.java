/***
Tags: "String"
Create: 2019/02/19
Update: 2019/02/19

Problem description:
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
    Input: ["flower","flow","flight"]
    Output: "fl"

Example 2:
    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

Note:
All given inputs are in lowercase letters a-z.

***/


// My Version (Same as Official Version of Vertical scanning)
// Time complexity : O(S), where S is the sum of all characters in all strings.
// Only used constant extra space.
class Solution {
     public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = "";
        char tmp;
         
        for(int i = 0; i < strs[0].length(); i++){
            tmp = strs[0].charAt(i);
            
            for(int j = 1; j < strs.length; j++){
                // Avoid strs[j] shorter than the first string.
                if(i > strs[j].length()-1 || strs[j].charAt(i) != tmp)   return ans;
            }

            ans += String.valueOf(tmp);
        }
        return ans;
    }
}