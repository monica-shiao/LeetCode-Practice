/***
Tags: "Array" "Hash Table"
Create: 2019/01/18
Update: 2019/01/18

Problem description:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
	Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].

***/

// My First Version
// Brute Force, time complexity is O(n^2). Space complexity : O(1).

Space complexity : O(1)O(1). 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i, j;
        
        for(i=0; i<nums.length; i++){
            for(j=i+1;j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No");
    }
}
