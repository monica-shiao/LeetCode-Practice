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


// Version of Divide & Conquer 
class Solution {
     public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            String ans = Divide_Conquer(strs, 0, strs.length-1);
        return ans;
    }
    
    String Divide_Conquer(String[] strs, int left_num, int right_num){
        if(left_num >= right_num)   return strs[left_num];
        
        int mid = (right_num + left_num)/2;
        String left = Divide_Conquer(strs, left_num, mid);
        String right = Divide_Conquer(strs, mid + 1, right_num);

        while(right.indexOf(left) != 0){ 
            left = left.substring(0, left.length() - 1);
        }
        
        return left;
    }
}

// My Version (Same as Official Version of Vertical scanning)
// Time complexity : O(S), where S is the sum of all characters in all strings.
// Only used constant extra space.
/*
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
}*/

// Official Version of Horizontal scanning
// Time and space complexity is same as above.
/*
class Solution {
     public String longestCommonPrefix(String[] strs) {
         if (strs.length == 0) return "";
         String ans = strs[0];
         
         for(int i = 1; i < strs.length; i++){
            // If entire ans is not in strs[i], reduce one charactor from the back of ans. (strs[i].indexOf("") is 0) 
             while(strs[i].indexOf(ans) != 0){
                ans = ans.substring(0, ans.length()-1);
             }
         }
        return ans;
    }
}*/