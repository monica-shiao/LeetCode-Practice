/***
Tags: Array, Two_Pointers
Create: 2019/8/22
Update: 2019/8/22

Problem description:
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
	Given nums = [1,1,2],

	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

	It doesn't matter what you leave beyond the returned length.


Example 2:
	Given nums = [0,0,1,1,1,2,2,3,3,4],

	Your function should return length = 5, with the first five elements of nums being modified to0, 1, 2, 3, and4 respectively.

	It doesn't matter what values are set beyondthe returned length.


Clarification:

	Confused why the returned value is an integer but your answer is an array?

	Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

	Internally you can think of this:
		// nums is passed in by reference. (i.e., without making a copy)
		int len = removeDuplicates(nums);

		// any modification to nums in your function would be known by the caller.
		// using the length returned by your function, it prints the first len elements.
		for (int i = 0; i < len; i++) {
		  print(nums[i]);
		}
***/

// Official Version (Two Pointers)
// Runtime: 1 ms (faster than 97.22%); Memory Usage: 38.9 MB (less than 99.47%)
// Definition: change array in place and new length is meaning that the length of the array that the system will read.

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int i = 0, j;
        for(j = 0; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                ++i;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}