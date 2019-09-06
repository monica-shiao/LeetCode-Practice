/***
Tags: Array
Create: 2019/9/5
Update: 2019/9/5

Problem description:
Given an array of integers where 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

***/



// My First Version (idea from tankztc)
// Runtime: 6 ms (faster than 79.59%); Memory Usage: 48.3 MB (less than 37.74%)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int i, len = nums.length;
        
        for(i = 0; i < len; i++) {
        	// swap each number to its belonging position
            while(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                nums[i] = nums[i] ^ nums[nums[i] - 1] ^ (nums[nums[i] - 1] = nums[i]);
            }
        }
        
        for(i = 0; i < len; i++) {
            if(nums[i] != i + 1)    ans.add(i + 1);
        }
        return ans;
    }
}



