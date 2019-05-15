/***
Tags: Array, Two_Pointer
Create: 2019/5/16
Update: 2019/5/16

Problem description:
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:
	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]

Note:
		You must do this in-place without making a copy of the array.
		Minimize the total number of operations.

***/

// Official Version(Really easy but efficient)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.6 MB (less than 99.18%)

class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0, i;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != 0)    nums[pos++] = nums[i];
        }
        for(i = pos; i < nums.length; i++)  nums[pos++] = 0;
    }
}


// My Second Version(Less memory)
// Runtime: 18 ms (faster than 6.48%); Memory Usage: 37 MB (less than 99.36%)
/*
class Solution {
    public void moveZeroes(int[] nums) {
        int pos, ptr = 0;
        while(ptr < nums.length) {
            if(nums[ptr] == 0) {
                pos = ptr;
                while(pos < nums.length) {
                    // Move non-zero number forward
                    if(nums[pos] != 0) {
                        nums[ptr] = nums[pos];
                        nums[pos] = 0;
                        break;
                    }
                    ++pos;
                }
            }
            ++ptr;
        }
    }
}*/


// My First Version (Less memory)
// Runtime: 18 ms (faster than 6.48%); Memory Usage: 37 MB (less than 99.36%) 
/*
class Solution {
    public void moveZeroes(int[] nums) {
        int left = nums.length - 2, move, right = nums.length, tmp;

        // Backtracking
        while(left >= 0) {
            if(nums[left] == 0){
                move = left;
                // move 0 to head of 0 that's in the end of array step by step
                while(move < right - 1) {
                    tmp = nums[move];
                    nums[move] = nums[move + 1];
                    nums[++move] = tmp;
                }
                --right;
            }
            --left;
        }
    }
}*/