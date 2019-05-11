/***
Tags: Math
Create: 2019/5/11
Update: 2019/5/11

Problem description:
Determine whether an integer is a palindrome. An integerisapalindrome when itreads the same backward as forward.

Example 1:
	Input: 121
	Output: true

Example 2:
	Input: -121
	Output: false
	Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
	Input: 10
	Output: false
	Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Follow up:

Coud you solveit without converting the integer to a string?

***/

// My Second Version (Math Version)
// Runtime: 6 ms (faster than 100.00%); Memory Usage: 34.9 MB (less than 100.00%)

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)   return false;
        int reverse = 0, cnt = 1, origin = x;
        
        while(x > 0){
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }
        
        if(origin == reverse)  return true;
        else    return false;
    }
}


// My First Version (String Version)
// Runtime: 8 ms (faster than 77.30%); Memory Usage: 34.9 MB(less than 100.00%)

class Solution {
    public boolean isPalindrome(int x) {
        String num = Integer.toString(x);
        int len = num.length() - 1;
        
        for(int i = 0; i <= len/2; i++)
            if(num.charAt(i) != num.charAt(len - i))    return false;
        
        return true;
    }
}
