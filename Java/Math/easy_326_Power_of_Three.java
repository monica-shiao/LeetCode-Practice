/***
Tags: Math
Create: 2019/8/21
Update: 2019/8/21

Problem description:
Given an integer, write a function to determine if it is a power of three.

Example 1:
	Input: 27
	Output: true


Example 2:
	Input: 0
	Output: false

Example 3:
	Input: 9
	Output: true

Example 4:
	Input: 45
	Output: false

Follow up:
Could you do it without using any loop / recursion?
***/

// My First Version
// Runtime: 11 ms (faster than 75.31%); Memory Usage: 36 MB (less than 6.25%)

class Solution {
    public boolean isPowerOfThree(int n) {
        double d = Math.log10(n) / Math.log10(3);

		// Officail: return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        if(d % 1 == 0)   return true;
        else    return false;
    }
}





