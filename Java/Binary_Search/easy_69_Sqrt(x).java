/***
Tags: Binary_Search Math
Create: 2019/5/14
Update: 2019/5/14

Problem description:
Implement int sqrt(int x).

Compute and return the square root of x, wherexis guaranteed to be a non-negative integer.

Since the return typeis an integer, the decimal digits are truncated and only the integer part of the resultis returned.

Example 1:
	Input: 4
	Output: 2

Example 2:
	Input: 8
	Output: 2
	Explanation: The square root of 8 is 2.82842..., and since 
	            the decimal part is truncated, 2 is returned.
***/

// My First Version
// Runtime: 1 ms (faster than 100.00%); Memory Usage: 32.9 MB (less than 100.00%)

class Solution {
    public int mySqrt(int x) {
        int tmp = x / 2, left = 1, right = x;
        long mid;
        
        while(left < right) {
            mid = ((long)left + (long)right) / 2;
            // Too big
            if(mid * mid > x)   right = (int)mid;

            // Equal or smaller than square of next number
            // Ex. sqrt(10): square of 3 < 10 < square of 4, ans = 3;
            else if(Math.pow(mid+1, 2) > x)  return (int)mid;

            // Too Small
            else    left = (int)mid + 1;
        }
        return right;
    }
}
