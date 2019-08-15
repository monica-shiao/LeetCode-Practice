/***
Tags: Math
Create: 2019/8/15
Update: 2019/8/15

Problem description:
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...


Example 1:
	Input: "A"
	Output: 1


Example 2:
	Input: "AB"
	Output: 28


Example 3:
	Input: "ZY"
	Output: 701

***/

// My First Version
// Runtime: 1 ms (faster than 100.00%); Memory Usage: 36 MB (less than 100.00%)

class Solution {
    public int titleToNumber(String s) {
        int i, j, carry = 26, ans = 0; 
        
        for(i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            ans += (s.charAt(i) - 64) * Math.pow(carry, j);
        }
        return ans;
    }
}
