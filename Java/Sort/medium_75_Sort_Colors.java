/***
Tags: Array, Two_Pointer, Sort
Create: 2019/5/16
Update: 2019/5/16

Problem description:
Given an array with n objects colored red, white or blue, sort them in-placeso that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:You are not suppose to use the library's sort function for this problem.

Example:
	Input: [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]

Follow up:

	A rather straight forward solution is a two-pass algorithm using counting sort.
	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
	Could you come up with aone-pass algorithm using only constant space?


***/

// My Third Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 34.2 MB (less than 100.00% )

class Solution {
    public void sortColors(int[] nums) {
    	// Store total numbers of three numbers 
        int[] cnt = {0, 0, 0};
        int i;
        
        for(i = 0; i < nums.length; i++) {
            if(nums[i] == 0)    ++cnt[0];
            else if(nums[i] == 1)   ++cnt[1];
            else    ++cnt[2];
        }
        
        for(i = 0; i < nums.length; i++) {
            if(i < cnt[0])  nums[i] = 0;
            else if(i < cnt[0] + cnt[1]) nums[i] = 1;
            else    nums[i] = 2;
        }
    }
}

// My Second Version(Selection Sort)
// Runtime: 1 ms (faster than 6.87%); Memory Usage: 34.6 MB (less than 99.86%)

class Solution {
    public void sortColors(int[] nums) {
        // Selection Sort
        int left = 0, ptr, min, len = nums.length, tmp;
        while(left < len - 1) {
            ptr = left+1;
            min = left;
            while(ptr < len) {
                if(nums[min] > nums[ptr])   min = ptr;
                ++ptr;
            }
            tmp = nums[left];
            nums[left] = nums[min];
            nums[min] = tmp;
            ++left;
        }
    }
}

// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 34.4 MB (less than 100.00%)

class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
