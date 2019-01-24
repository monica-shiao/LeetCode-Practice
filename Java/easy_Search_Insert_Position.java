/*
Problem description:
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:
    Input: [1,3,5,6], 5
    Output: 2

Example 2:
    Input: [1,3,5,6], 2
    Output: 1

Example 3:
    Input: [1,3,5,6], 7
    Output: 4

Example 4: 
    Input: [1,3,5,6], 0
    Output: 0
*/

// This is a binary search problem. The complexity should be O(log(n)).

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, mid;
        int right = nums.length;
        
        while(left < right){
            mid = left + (right - left) / 2;
            
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid;
            }
            else{
                return mid;
            }
        }
        
        return right;
    }
}


/* My first Version
//The complexity is O(n).

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i;
        
        Arrays.sort(nums);
        for(i = 0; i < nums.length; i++){
            if(nums[i] == target || nums[i] > target){
                return i;
            }
        }
        
        return nums.length;
    }
}
*/