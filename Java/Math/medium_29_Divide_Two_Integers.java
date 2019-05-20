/***
Tags: Math, Binary_Search
Create: 2019/5/20
Update: 2019/5/20

Problem description:
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
	Input: dividend = 10, divisor = 3
	Output: 3

Example 2:
	Input: dividend = 7, divisor = -3
	Output: -2

Note:

	Both dividend and divisorwill be32-bitsigned integers.
	The divisor will never be 0.
	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [&minus;231, 231 &minus; 1]. For the purpose of this problem, assume that your function returns 231 &minus; 1 when the division resultoverflows.

***/

// My Second Version
// Runtime: 1 ms (faster than 100.00%); Memory Usage: 32.6 MB (less than 73.36%)

class Solution {
    public int divide(int dividend, int divisor) {
        return (dividend == Integer.MIN_VALUE && divisor == -1) ? Integer.MAX_VALUE : dividend / divisor;
    }
}


// My First Version
// Runtime: 1 ms (faster than 100.00%); Memory Usage: 32.7 MB (less than 63.29% )

class Solution {
    public int divide(int dividend, int divisor) {
        long ans = (long)dividend/(long)divisor;
        return (ans > Integer.MAX_VALUE - 1 || ans < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int)ans;
    }
}


