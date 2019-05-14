/***
Tags: Dynamic_Programming
Create: 2019/5/13
Update: 2019/5/13

Problem description:
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:
	Input: [1,2,3,1]
	Output: 4
	Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	            Total amount you can rob = 1 + 3 = 4.

Example 2:
	Input: [2,7,9,3,1]
	Output: 12
	Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
	            Total amount you can rob = 2 + 9 + 1 = 12.

***/

// Array Version (Idea from gnagarjun, excellent!!!)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 33.3 MB (less than 100.00%)

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if(len == 0)    return 0;
        else if(len == 1)   return nums[0];
        else if(len == 2)   return (nums[0] >= nums[1]) ? nums[0] : nums[1];
        else {
            int[] max = new int[len];
            max[0] = nums[0];
            max[1] = (nums[0] >= nums[1]) ? nums[0] : nums[1];
            for (int i = 2; i < len; i++) {
                max[i] = Math.max(max[i-2] + nums[i], max[i-1]);
            }
            return max[len-1];
        }
    }
}