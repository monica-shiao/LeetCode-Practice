/***
Tags: "Array"
Create: 2020/02/09
Update: 2019/01/28

Problem description:
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
    Input: [1,2,3,4,5,6,7] and k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
    Input: [-1,-100,3,99] and k = 2
    Output: [3,99,-1,-100]
    Explanation: 
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]

Note:
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    
    Could you do it in-place with O(1) extra space?
***/


// My Version3(like bubble sort -> transfer the last number step by step to the first place and in k times)

class Solution {
    public void rotate(int[] nums, int k) {
        int tmp, len = nums.length;
        
        for(int i = 0; i < k; i++) {
            for(int j = len - 1; j > 0; j--) {
                tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        }
    }
}


// My Version2
// Time complexity : O(n∗k). All the numbers are shifted by one step(O(n)) k times(O(k)).
// Space complexity (additional) : O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int i, j, tmp;

        for(i = 0; i < k; i++){
            tmp = nums[nums.length-1];
            
            for(j = nums.length - 2; j >= 0 ; j--){
                nums[j+1] = nums[j];
            }
            
            nums[0] = tmp;
        }
    }
}


//My Version1
// (i + target) % length，迴轉可以想成向右，每個向右後再取餘數就能變成迴轉動作。
// Time complexity : O(2*n) = O(n).
// Space complexity (additional) : O(n).

/*
class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotate2 = new int[nums.length];
        
        for(int i = 0; i< nums.length; i++){
            rotate2[(i+k) % nums.length] = nums[i];
        }
        
        for(int i = 0; i< nums.length; i++){
            nums[i] = rotate2[i];
        }
    }
}*/