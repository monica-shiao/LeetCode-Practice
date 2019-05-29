/***
Tags: String
Create: 2019/5/29
Update: 2019/5/29

Problem description:
Given a string S, return the "reversed" string where all characters that are not a letterstay in the same place, and all letters reverse their positions.


Example 1:
	Input: "ab-cd"
	Output: "dc-ba"


Example 2:
	Input: "a-bC-dEf-ghIj"
	Output: "j-Ih-gfE-dCba"


Example 3:
	Input: "Test1ng-Leet=code-Q!"
	Output: "Qedo1ct-eeLg=ntse-T!"

Note:

	S.length <= 100
	33 <= S[i].ASCIIcode <= 122
	S doesn't contain \ or "
***/



// My First Version (Two Pointer)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 33.6 MB (less than 100.00%)

class Solution {
    public String reverseOnlyLetters(String S) {
        int len = S.length(), left = 0, right = len - 1, i;
        char[] ans = new char[len];
        char tmp;

        while(true) {
            while( left < len && (!isLetter(S.charAt(left)))){
                ans[left] = S.charAt(left);
                ++left;
            }
            while(right >= 0 && (!isLetter(S.charAt(right)))){
                ans[right] = S.charAt(right);
                --right;
            }
            if(left <= right) {
                ans[left] = S.charAt(right);
                ans[right] = S.charAt(left);
                ++left;
                --right;
            }
            else    break;
        }
        
        return String.valueOf(ans);
    }
    
    public boolean isLetter(char letter) {
        int c = (int)letter;
        if((65 <= c && c <= 90) || (97 <= c && c <= 122))   return true;
        else    return false;
    }
        
}


// Official Version (One Pointer)
// Runtime: 1 ms (faster than 75.22%); Memory Usage: 33.8 MB (less than 100.00%)

class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        int i, j = S.length() - 1;
        // Use i to run all character in string and save not letter 
        for(i = 0; i < S.length(); i++) {
            if(Character.isLetter(S.charAt(i))){
            	// Go through the string backwards
                while(!Character.isLetter(S.charAt(j)))    j--;
                ans.append(S.charAt(j--));   
            }
            else {
            	// Store letters that aren't letters
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }
}