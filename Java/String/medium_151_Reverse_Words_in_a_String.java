/***
Tags: "String"
Create: 2019/04/11
Update: 2019/04/11

Problem description:
Given an input string, reverse the string word by word.
 

Example 1:
	Input: "the sky is blue"
	Output: "blue is sky the"

Example 2:
	Input: "  hello world!  "
	Output: "world! hello"
	Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
	Input: "a good   example"
	Output: "example good a"
	Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
	 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Follow up:
For C programmers, try to solve it in-place in O(1) extra space.

***/

// My Third Version (idea from PritiGolegaonkar)
// Runtime: 1 ms (faster than 99.95%); Memory Usage: 37.4 MB (less than 93.05%)

class Solution {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        String[] tmp = s.split(" ");
        int len = tmp.length - 1;
        
        for(int i = len; i >= 0; i--){
            if(!tmp[i].trim().equals("")){
                if(i != len)    ans.append(" ");
                ans.append(tmp[i]);
            }
        }
        return ans.toString();
    }
}



// My First Version (StringBuffer & StringTokenizer)
// Runtime: 2 ms (faster than 91.85%); Memory Usage: 39.6 MB (less than 22.99%)

import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        StringTokenizer st = new StringTokenizer(s, " ");
        
        while(st.hasMoreTokens()){
            ans.append(new StringBuffer(st.nextToken()).reverse().toString() + " ");
        }

        return ans.reverse().toString().trim();
    }
}

// My Second Version (StringBuffer & String, idea from jay91)
// Runtime: 2 ms (faster than 91.85%); Memory Usage: 39.9 MB (less than 20.29%)
class Solution {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        String[] tmp = s.split(" ");
        for(int i = tmp.length-1; i >= 0; i--){
            if(!tmp[i].trim().equals("")){
                ans.append(tmp[i]+" ");
            }
        }
        return ans.toString().trim();
    }
}


