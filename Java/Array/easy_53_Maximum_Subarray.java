/***
Tags: "Array" "Divide & Conquer" "Dynamic Programming"
Create: 2019/02/16
Update: 2019/02/16

Problem description:
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
	Input: [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
***/

// My First Version (Dynamic Programming)
// O(n) time complexity.
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)    return 0;
        
        int ans = nums[0], max = nums[0], i;
 
        for(i = 1; i < nums.length; i++){
            max = Math.max(max+nums[i], nums[i]);
            ans = Math.max(ans, max);
        }
      
        return ans;
    }
}