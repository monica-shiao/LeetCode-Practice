/***
Tags: Dynamic_Programming
Create: 2019/9/7
Update: 2019/9/8

Problem description:
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:
	Input: 2
	Output: 2
	Explanation: There are two ways to climb to the top.
		1. 1 step + 1 step
		2. 2 steps


Example 2:
	Input: 3
	Output: 3
	Explanation: There are three ways to climb to the top.
		1. 1 step + 1 step + 1 step
		2. 1 step + 2 steps
		3. 2 steps + 1 step
***/
// Idea same as Fibonacci 

// Dynamic Programming Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 32.7 MB (less than 5.26%)

class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}

// Official "Fibonacci Number" Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 32.8 MB (less than 5.26%)

class Solution {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int first = 1, second = 2, third;
        
        for(int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

