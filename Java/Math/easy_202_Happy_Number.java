/***
Tags: Math Hash_Table
Create: 2019/4/20
Update: 2019/4/20

Problem description:
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 
    Input: 19
    Output: true
    Explanation: 
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1

***/

// My First Version
// Runtime: 1 ms (faster than 88.26%); Memory Usage: 32.2 MB (less than 100.00%)

class Solution {
    public boolean isHappy(int n) {
        int tmp, cnt = 0;
        
        while(n != 1){
            if(cnt > 50)     return false;

            tmp = n;
            n = 0;

            while(tmp != 0){
                n += (tmp % 10) * (tmp % 10);
                tmp /= 10;
            }

            cnt ++;
        }
        return true;
    }
}

// HashSet Version
// Runtime: 2 ms (faster than 49.91%); Memory Usage: 32.5 MB (less than 100.00%)

class Solution {
    public boolean isHappy(int n) {
        int tmp;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        
        while(n != 1){
            tmp = n;
            n = 0;
            
            while(tmp != 0){
                n += (tmp % 10) * (tmp % 10);
                tmp /= 10;
            }
            
            if(set.contains(n))     return false;
            set.add(n);
        }
        return true;
    }
}