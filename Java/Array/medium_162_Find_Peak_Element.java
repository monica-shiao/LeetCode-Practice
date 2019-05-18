/***
Tags: Array
Create: 2019/5/17
Update: 2019/5/18

Problem description:
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:
	Input: nums = [1,2,3,1]
	Output: 2
	Explanation: 3 is a peak element and your function should return the index number 2.


Example 2:
	Input: nums = [1,2,1,3,5,6,4]
	Output: 1 or 5 
	Explanation: Your function can return either index number 1 where the peak element is 2, 
	            or index number 5 where the peak element is 6.


Note:
	Your solution should be in logarithmic complexity.

***/

// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.7 MB (less than 92.55%)

class Solution {
    public int findPeakElement(int[] nums) {
        int max = 0, i;
        for(i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                if(nums[i + 1] > nums[max])   max = i + 1;
            }
        }
        return max;
    }
}


// Officail Version(Iterative & binary search)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.6 MB (less than 94.24%)

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        while(l < r) {
            mid = (l + r) / 2;
            if(nums[mid] < nums[mid + 1])   l = mid + 1;
            else    r = mid;
        }
        return l;
    }
}