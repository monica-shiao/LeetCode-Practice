/***
Tags: Array
Create: 2019/5/30
Update: 2019/5/30

Problem description:
TheFibonacci numbers, commonly denotedF(n)form a sequence, called theFibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1)= 1
F(N) = F(N - 1) + F(N - 2), for N > 1.

Given N, calculate F(N).


Example 1:

	Input: 2
	Output: 1
	Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.


Example 2:

	Input: 3
	Output: 2
	Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.


Example 3:

	Input: 4
	Output: 3
	Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Note:

0 <= N <= 30.

***/

// My Third Version (Subtract)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 32.1 MB (less than 55.97%)

class Solution {
    public int fib(int N) {
        if(N == 0)    return 0;
        int pre = 0, curr = 1, tmp;
        
        for(int i = 2; i <= N; i++) {
            tmp = curr;
            curr = curr + pre;
            pre = tmp;
        }
        return curr;
    }
}


// My Second Version (Array)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 32.3 MB (less than 55.89%)

class Solution {
    public int fib(int N) {
        if(N == 0)    return 0;
        
        int[] fibo = new int[N + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        
        for(int i = 2; i <= N; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[N];
    }
}

// My First Version (Recursive)
// Runtime: 8 ms (faster than 35.59%); Memory Usage: 32 MB (less than 56.71%)

class Solution {
    public int fib(int N) {
        if(N > 1)   return fib(N-1)+fib(N-2);
        else return N;
    }
}


// My Fourth Version (Addition)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 31.9 MB (less than 57.11%)

class Solution {
    public int fib(int N) {
        int curr = 0, next = 1;
        for (int i = 0; i < N; i++) {
            int sum = curr + next;
            curr = next;
            next = sum;
        }
        return curr;
    }
}
