/***
Tags: Array, Math, Bit_Manipulation
Create: 2019/5/16
Update: 2019/5/16

Problem description:
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:
	Input: [3,0,1]
	Output: 2


Example 2:
	Input: [9,6,4,2,3,5,7,0,1]
	Output: 8


Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
***/

// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.9 MB (less than 91.20%)

class Solution {
    public int missingNumber(int[] nums) {
        int cnt = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            cnt += nums[i];
            ans += i+1;
        }
        // ans: len!, cnt: sum of values of array
        return ans - cnt;
    }
}

// My Second Version
// Runtime: 7 ms (faster than 21.08%); Memory Usage: 37.8 MB (less than 95.91%)

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)    if(nums[i] != i)  return i;
        return nums.length;
    }
}
