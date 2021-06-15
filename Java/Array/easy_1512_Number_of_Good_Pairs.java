/***
Tags: Array
Create: 2021/5/13
Update: 2021/5/13

Problem description:
Given an array of integersnums.

A pair(i,j)is called good ifnums[i] == nums[j] and i < j.

Return the number of good pairs.


Example 1:


Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.


Example 2:


Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.


Example 3:


Input: nums = [1,2,3]
Output: 0



Constraints:


	1 <= nums.length <= 100
	1 <= nums[i] <= 100

***/

/*
Runtime: 1 ms, faster than 64.85% 
Memory Usage: 36.4 MB, less than 50.47%
*/
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int i, j, len = nums.length, ans = 0;
        
        for(i = 0; i < len; i++) {
            for(j = i + 1; j < len; j++) {
                if(nums[i] == nums[j])  ++ans;
            }
        }
        return ans;
    }
}