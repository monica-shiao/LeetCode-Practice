/***
Tags: "String"
Create: 2019/03/22
Update: 2019/03/22

Problem description:
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Example 1:
    Input: "Hello"
    Output: "hello"

Example 2:
    Input: "here"
    Output: "here"

Example 3:  
    Input: "LOVELY"
    Output: "lovely"    
***/

// StringBuffer Version
// Runtime faster than 100% and Memory Usage less than 92.41% in Java submissions
class Solution {
    public String toLowerCase(String str) {
        int i, ascii;
        StringBuffer ans = new StringBuffer("");
        
        for(i = 0; i < str.length(); i++){
            ascii = (int)str.charAt(i);
            
            if(ascii >= 65 && ascii <= 90)
                ans.append((char)(ascii+32));
            else
                ans.append((char)ascii);
            
        }
        return ans.toString();
    }
}

/*
// Version of Calling Java String toLowerCase() Method
class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
*/