/***
Tags: String
Create: 2019/4/11
Update: 2019/4/11

Problem description:
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
	Input: "Let's take LeetCode contest"
	Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.
***/

// My First Version(StringBuffer & StringTokenizer)
// Runtime: 3 ms (faster than 99.11%); Memory Usage: 39.5 MB (less than 79.58%)
import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        StringTokenizer st = new StringTokenizer(s, " ");
        int flag = 0;
        
        while(st.hasMoreTokens()){
            StringBuffer tmp = new StringBuffer(st.nextToken());
            if(flag == 0){
                ans.append(tmp.reverse());
                flag = 1;
            }
            else{
                ans.append(" ");
                ans.append(tmp.reverse());
            }  
        }
        return ans.toString();
    }
}

// Simplified Version
// Runtime: 5 ms (faster than 86.51%); Memory Usage: 39.4 MB (less than 87.99%)

import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        StringTokenizer st = new StringTokenizer(s, " ");
        
        while(st.hasMoreTokens()){
            ans.append(new StringBuffer(st.nextToken()).reverse().toString() + " ");
        }
        return ans.toString().trim();
    }
}
