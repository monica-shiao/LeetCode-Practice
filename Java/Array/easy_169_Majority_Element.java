/***
Tags: Array
Create: 2019/8/1
Update: 2019/8/1

Problem description:
Given an array of size n, find the majority element. The majority element is the element that appears more than &lfloor; n/2 &rfloor; times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
	Input: [3,2,3]
	Output: 3

Example 2:
	Input: [2,2,1,1,1,2,2]
	Output: 2
***/

// Array version
// Runtime: 3 ms (faster than 46.38%); Memory Usage: 40.1 MB (less than 98.68%)
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length, i, j, max = 0;
        int[] st = new int[len];
        int[] cnt = new int[len];
        
        Arrays.fill(st, Integer.MAX_VALUE);
        Arrays.fill(cnt, 0);

        for(i = 0; i < len; i++) {
            for(j = 0; j <= i; j++) {
                // write in new element
                if(st[j] == Integer.MAX_VALUE) {
                    st[j] = nums[i];
                    cnt[j] = 1;
                    break;
                }
                
                // same element appearing
                if(st[j] == nums[i]) {
                    ++cnt[j];
                    break;
                }
            }
        }
        
        for(i = 0; i < len; i++) {
            if(cnt[i] > len / 2) {
                return st[i];
            }
        }
        
        return st[0];
    }
}
