/***
Tags: "String" "Two Pointer"
Create: 2019/02/25
Update: 2019/02/28

Problem description:
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

	Example 1:
	Input: "A man, a plan, a canal: Panama"
	Output: true

Example 2:
	Input: "race a car"
	Output: false
***/

// My First Version (StringBuffer)
// I think that is fast enough :)
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer str1 = new StringBuffer("");
        int ascii;
        
        for(int i = 0; i < s.length(); i++){
            ascii = (int)s.charAt(i);
            
            if((48 <= ascii && ascii <= 57) || (65 <= ascii && ascii <= 90) || (97 <= ascii && ascii <= 122)){
                if(65 <= ascii && ascii <= 90)
                    str1.append((char)(ascii+32));
                else
                    str1.append(s.charAt(i));
            }
        }
        
        if(str1.toString().equals(str1.reverse().toString()))     return true;
        else    return false;

    }
}

// My Two Pointer Version
// 1ms slower than the above solution
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() < 2)  return true;
        
        int i = 0, j = s.length()-1;
        s = s.toLowerCase();
        
        while(i < j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                ++i;
                continue;
            }    
            
            if(!Character.isLetterOrDigit(s.charAt(j))){
                --j;
                continue;
            }    
            
            if(s.charAt(i) != s.charAt(j))    return false;
            
            ++i;
            --j;
        }
        
        return true;
    }
}